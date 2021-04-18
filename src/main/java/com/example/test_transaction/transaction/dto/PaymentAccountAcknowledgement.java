package com.example.test_transaction.transaction.dto;

import com.example.test_transaction.transaction.entity.AccountInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAccountAcknowledgement {
    private String status;
    private Long balance;
    private AccountInfo accountInfo;
}
