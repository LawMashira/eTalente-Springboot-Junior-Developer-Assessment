package com.enviro.assessment.grad001.lawsonmatutu.service;

import com.enviro.assessment.grad001.lawsonmatutu.entity.Investor;

import java.util.List;
import java.util.Optional;

public interface InvestorService {

    List<Investor> getAllInvestors();

    Optional<Investor> getInvestorById(Long id);

    Investor saveInvestor(Investor investor);

    void deleteInvestor(Long id);

}
