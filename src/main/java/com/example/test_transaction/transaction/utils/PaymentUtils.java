package com.example.test_transaction.transaction.utils;

import com.example.test_transaction.transaction.exception.InsufficientAmountException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class PaymentUtils {

    @SneakyThrows
    public static boolean validateCreditLimit(Long currentBalance, Long paidAmount) {
        if (currentBalance < paidAmount) {
            throw new InsufficientAmountException("insufficient fund");
        }
        return true;
    }
}
