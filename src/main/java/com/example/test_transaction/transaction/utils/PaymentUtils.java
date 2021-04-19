package com.example.test_transaction.transaction.utils;

import com.example.test_transaction.transaction.exception.InsufficientAmountException;
import lombok.SneakyThrows;

import java.math.BigDecimal;

public class PaymentUtils {

    @SneakyThrows
    public static boolean validateCreditLimit(BigDecimal currentBalance, BigDecimal paidAmount) {
        if (currentBalance.compareTo(paidAmount) <= 0) {
            throw new InsufficientAmountException("insufficient fund");
        }
        return true;
    }
}
