package com.enviro.assessment.grad001.lawsonmatutu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="withdrawal_notice")
public class WithdrawalNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private double withdrawalAmount;
    private Date withdrawalDate;
    private String bankingDetails;

    // Constructors

    public WithdrawalNotice() {
    }

    public WithdrawalNotice(Product product, double withdrawalAmount, Date withdrawalDate, String bankingDetails) {
        this.product = product;
        this.withdrawalAmount = withdrawalAmount;
        this.withdrawalDate = withdrawalDate;
        this.bankingDetails = bankingDetails;
    }


}
