package com.enviro.assessment.grad001.lawsonmatutu.service;

import com.enviro.assessment.grad001.lawsonmatutu.entity.Investor;
import com.enviro.assessment.grad001.lawsonmatutu.entity.Product;
import com.enviro.assessment.grad001.lawsonmatutu.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.lawsonmatutu.entity.WithdrawalNotification;
import com.enviro.assessment.grad001.lawsonmatutu.exceptions.entityexceptions.InvalidWithdrawalException;
import com.enviro.assessment.grad001.lawsonmatutu.repository.InvestorRepository;
import com.enviro.assessment.grad001.lawsonmatutu.repository.ProductRepository;
import com.enviro.assessment.grad001.lawsonmatutu.repository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
@Service
public class WithdrawalServiceImpl  implements WithdrawalService{

    private final ProductRepository productRepository;
    private final WithdrawalNoticeRepository withdrawalNoticeRepository;
    private final InvestorRepository investorRepository;
    @Autowired
    public WithdrawalServiceImpl(ProductRepository productRepository, WithdrawalNoticeRepository withdrawalNoticeRepository, InvestorRepository investorRepository) {
        this.productRepository = productRepository;
        this.withdrawalNoticeRepository = withdrawalNoticeRepository;
        this.investorRepository=investorRepository;
    }

    @Override
    public WithdrawalNotification createWithdrawalNotice(Long productId, double withdrawalAmount, String bankingDetails)
            throws InvalidWithdrawalException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new InvalidWithdrawalException("Product not found with ID: " + productId));

        double initialBalance = product.getCurrentBalance();
        double closingBalance = initialBalance - withdrawalAmount;

        // Checking if withdrawal amount is greater than current balance
        if (withdrawalAmount > initialBalance) {
            throw new InvalidWithdrawalException("Withdrawal amount exceeds current balance");
        }

        // Checking if withdrawal amount is more than 90% of the current balance
        double maxWithdrawalAmount = 0.9 * initialBalance;
        if (withdrawalAmount > maxWithdrawalAmount) {
            throw new InvalidWithdrawalException("Withdrawal amount exceeds 90% of current balance");
        }

        // checking if the  product is RETIREMENT, check investor's age
        if (product.getType().equals("RETIREMENT")) {
            Investor investor = investorRepository.findByProductId(product.getId());
            int investorAge = calculateInvestorAge(investor.getDateOfBirth());
            if (investorAge <= 65) {
                throw new InvalidWithdrawalException("Investor's age must be greater than 65 for RETIREMENT products");
            }
        }

        // Updating product's balance
        product.setCurrentBalance(closingBalance);
        productRepository.save(product);

        // Creating withdrawal notice
        WithdrawalNotice withdrawalNotice = new WithdrawalNotice(product, withdrawalAmount, new Date(), bankingDetails);
        withdrawalNoticeRepository.save(withdrawalNotice);

        return new WithdrawalNotification(initialBalance, withdrawalAmount, closingBalance);
    }

    private int calculateInvestorAge(Date dateOfBirth) {
        LocalDate birthDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }


    @Override
    public List<WithdrawalNotice> getWithdrawalNoticesByProduct(Long productId) throws InvalidWithdrawalException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new InvalidWithdrawalException("Product not found with ID: " + productId));

        return withdrawalNoticeRepository.findByProduct(product);
    }

    @Override
    public List<WithdrawalNotice> getAllWithdrawalNotices() {
        return withdrawalNoticeRepository.findAll();
    }

    // For CSV File Generation

    @Override
    public List<WithdrawalNotice> getWithdrawalNoticesByProductAndDateRange(Long productId, Date startDate, Date endDate) {
        return withdrawalNoticeRepository.findByProductIdAndWithdrawalDateBetween(productId, startDate, endDate);
    }

}
