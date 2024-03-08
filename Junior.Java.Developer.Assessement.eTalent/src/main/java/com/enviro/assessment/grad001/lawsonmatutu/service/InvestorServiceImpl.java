package com.enviro.assessment.grad001.lawsonmatutu.service;

import com.enviro.assessment.grad001.lawsonmatutu.entity.Investor;
import com.enviro.assessment.grad001.lawsonmatutu.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InvestorServiceImpl implements  InvestorService {
    private final InvestorRepository investorRepository;

    @Autowired
    public InvestorServiceImpl(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @Override
    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    @Override
    public Optional<Investor> getInvestorById(Long id) {
        return investorRepository.findById(id);
    }

    @Override
    public Investor saveInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    @Override
    public void deleteInvestor(Long id) {
        investorRepository.deleteById(id);
    }

}
