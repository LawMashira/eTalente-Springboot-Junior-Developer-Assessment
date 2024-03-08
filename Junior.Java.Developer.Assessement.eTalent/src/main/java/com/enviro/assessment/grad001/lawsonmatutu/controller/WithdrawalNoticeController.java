package com.enviro.assessment.grad001.lawsonmatutu.controller;

import com.enviro.assessment.grad001.lawsonmatutu.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.lawsonmatutu.entity.WithdrawalNotification;
import com.enviro.assessment.grad001.lawsonmatutu.exceptions.entityexceptions.InvalidWithdrawalException;
import com.enviro.assessment.grad001.lawsonmatutu.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalNoticeController {


    private final WithdrawalService withdrawalService;

    @Autowired
    public WithdrawalNoticeController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createWithdrawalNotice(@RequestParam Long productId,
                                                    @RequestParam double withdrawalAmount,
                                                    @RequestParam String bankingDetails) {
        try {
            WithdrawalNotification withdrawalNotification = withdrawalService.createWithdrawalNotice(productId, withdrawalAmount, bankingDetails);
            return ResponseEntity.ok(withdrawalNotification);
        } catch (InvalidWithdrawalException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/notices/{productId}")
    public ResponseEntity<?> getWithdrawalNoticesByProduct(@PathVariable Long productId) throws InvalidWithdrawalException {
        List<WithdrawalNotice> withdrawalNotices = withdrawalService.getWithdrawalNoticesByProduct(productId);
        return ResponseEntity.ok(withdrawalNotices);
    }

    @GetMapping("/notices")
    public ResponseEntity<?> getAllWithdrawalNotices() {
        List<WithdrawalNotice> withdrawalNotices = withdrawalService.getAllWithdrawalNotices();
        return ResponseEntity.ok(withdrawalNotices);
    }
}
