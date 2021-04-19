package com.example.test_transaction.transaction;

import com.example.test_transaction.transaction.dto.AccountRequest;
import com.example.test_transaction.transaction.dto.PaymentAccountAcknowledgement;
import com.example.test_transaction.transaction.entity.AccountInfo;
import com.example.test_transaction.transaction.entity.PaymentInfo;
import com.example.test_transaction.transaction.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TransactionApplicationTests {

    @MockBean
    private PaymentService paymentService;

    @Test
    public void testListAllAccounts() {
        List<AccountInfo> accountInfoList = new ArrayList<>();
        accountInfoList.add(new AccountInfo(1L, 100L, Arrays.asList(new PaymentInfo(1L, 1L, new Date(), 100L))));

        Mockito.when(paymentService.accounts()).thenReturn(accountInfoList);
    }

    @Test
    public void testEditAccount() {
        AccountRequest accountRequest = new AccountRequest(
                new AccountInfo(1L, 100L, Arrays.asList(new PaymentInfo(1L, 1L, new Date(), 100L))),
                new PaymentInfo(1L, 1L, new Date(), 50L)
        );
        PaymentAccountAcknowledgement paymentAccountAcknowledgement = new PaymentAccountAcknowledgement(
                "success",
                accountRequest.getAccountInfo().getBalance() - accountRequest.getPaymentInfo().getAmount(),
                new AccountInfo(
                        1L, accountRequest.getAccountInfo().getBalance() - accountRequest.getPaymentInfo().getAmount(),
                        Arrays.asList(accountRequest.getPaymentInfo())
                )
        );

        Mockito.when(paymentService.payment(accountRequest)).thenReturn(paymentAccountAcknowledgement);
    }
}
