package com.enviro.assessment.grad001.lawsonmatutu.service;

import com.enviro.assessment.grad001.lawsonmatutu.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.lawsonmatutu.entity.WithdrawalNotification;
import com.enviro.assessment.grad001.lawsonmatutu.exceptions.entityexceptions.InvalidWithdrawalException;

import java.util.Date;
import java.util.List;

public interface WithdrawalService {
    WithdrawalNotification createWithdrawalNotice(Long productId, double withdrawalAmount, String bankingDetails)
            throws InvalidWithdrawalException;

    List<WithdrawalNotice> getWithdrawalNoticesByProduct(Long productId) throws InvalidWithdrawalException;

    List<WithdrawalNotice> getAllWithdrawalNotices();

    // For CSV File Generation

    List<WithdrawalNotice> getWithdrawalNoticesByProductAndDateRange(Long productId, Date startDate, Date endDate);

}
