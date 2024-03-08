package com.enviro.assessment.grad001.lawsonmatutu.controller;

import com.enviro.assessment.grad001.lawsonmatutu.entity.Investor;
import com.enviro.assessment.grad001.lawsonmatutu.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investor")
public class InvestorController {

    private final InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @GetMapping("/register")
    public ResponseEntity<List<Investor>> getAllInvestors() {
        List<Investor> investors = investorService.getAllInvestors();
        return new ResponseEntity<>(investors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long id) {
        return investorService.getInvestorById(id)
                .map(investor -> new ResponseEntity<>(investor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/getAll")
    public ResponseEntity<Investor> createInvestor(@RequestBody Investor investor) {
        Investor createdInvestor = investorService.saveInvestor(investor);
        return new ResponseEntity<>(createdInvestor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestor(@PathVariable Long id) {
        investorService.deleteInvestor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
