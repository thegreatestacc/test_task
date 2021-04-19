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

import java.math.BigDecimal;
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
        accountInfoList.add(new AccountInfo(1L, new BigDecimal(100), Arrays.asList(new PaymentInfo(1L, 1L, new Date(), new BigDecimal(100)))));

        Mockito.when(paymentService.accounts()).thenReturn(accountInfoList);
    }

    @Test
    public void testEditAccount() {
        AccountRequest accountRequest = new AccountRequest(
                new AccountInfo(1L, new BigDecimal(100), Arrays.asList(new PaymentInfo(1L, 1L, new Date(),  new BigDecimal(100)))),
                new PaymentInfo(1L, 1L, new Date(), new BigDecimal(50))
        );
        PaymentAccountAcknowledgement paymentAccountAcknowledgement = new PaymentAccountAcknowledgement(
                "success",
                accountRequest.getAccountInfo().getBalance().subtract(accountRequest.getPaymentInfo().getAmount()),
                new AccountInfo(
                        1L, accountRequest.getAccountInfo().getBalance().subtract(accountRequest.getPaymentInfo().getAmount()),
                        Arrays.asList(accountRequest.getPaymentInfo())
                )
        );

        Mockito.when(paymentService.payment(accountRequest)).thenReturn(paymentAccountAcknowledgement);
    }
}
