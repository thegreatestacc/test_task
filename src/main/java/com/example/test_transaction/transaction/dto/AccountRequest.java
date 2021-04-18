package com.example.test_transaction.transaction.dto;

import com.example.test_transaction.transaction.entity.AccountInfo;
import com.example.test_transaction.transaction.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private AccountInfo accountInfo;
    private PaymentInfo paymentInfo;
}
