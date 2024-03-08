package com.enviro.assessment.grad001.lawsonmatutu.entity;

public class WithdrawalNotification {

    private double initialBalance;
    private double withdrawalAmount;
    private double closingBalance;



    public WithdrawalNotification(double initialBalance, double withdrawalAmount, double closingBalance) {
        this.initialBalance = initialBalance;
        this.withdrawalAmount = withdrawalAmount;
        this.closingBalance = closingBalance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(double closingBalance) {
        this.closingBalance = closingBalance;
    }

}
