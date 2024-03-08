package com.enviro.assessment.grad001.lawsonmatutu.repository;

import com.enviro.assessment.grad001.lawsonmatutu.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvestorRepository  extends JpaRepository<Investor,Long> {
    @Query("SELECT i FROM Investor i JOIN i.products p WHERE p.id = :productId")
    Investor findByProductId(Long productId);
}
