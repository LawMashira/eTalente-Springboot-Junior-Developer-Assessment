package com.enviro.assessment.grad001.lawsonmatutu.repository;

import com.enviro.assessment.grad001.lawsonmatutu.entity.Product;
import com.enviro.assessment.grad001.lawsonmatutu.entity.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice,Long>
{

    List<WithdrawalNotice> findByProduct(Product product);

    // CsV Generation
    List<WithdrawalNotice> findByProductIdAndWithdrawalDateBetween(Long productId, Date startDate, Date endDate);

}
