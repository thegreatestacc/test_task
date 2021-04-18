package com.example.test_transaction.transaction.service;

import com.example.test_transaction.transaction.dto.AccountRequest;
import com.example.test_transaction.transaction.dto.PaymentAccountAcknowledgement;
import com.example.test_transaction.transaction.entity.AccountInfo;
import com.example.test_transaction.transaction.entity.PaymentInfo;
import com.example.test_transaction.transaction.repository.AccountInfoRepository;
import com.example.test_transaction.transaction.repository.PaymentInfoRepository;
import com.example.test_transaction.transaction.utils.PaymentUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final AccountInfoRepository accountRepository;
    private final PaymentInfoRepository paymentInfoRepository;

    public Iterable<AccountInfo> accounts() {
        return accountRepository.findAll();
    }

    public AccountInfo createAccount(AccountInfo account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        if (null != id) {
            accountRepository.deleteById(id);
        } else throw new RuntimeException("account not found");
    }

    public Optional<AccountInfo> findAccountById(Long id) {
        var foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            return foundAccount;
        } else throw new RuntimeException("account not found");
    }

    @Transactional
    public AccountInfo editAccount(Long id, Long balance) {
        var foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            foundAccount.get().setBalance(balance);
        } else throw new RuntimeException("account not found");
        return accountRepository.save(foundAccount.get());
    }

    @Transactional
    public PaymentAccountAcknowledgement makeTransactionAction(AccountRequest request) {
        var accountInfo = request.getAccountInfo();

        var account = accountRepository.findById(accountInfo.getId());

        var paymentInfo = request.getPaymentInfo();
        if (account.isEmpty()) {
            throw new RuntimeException("account doesn't exist");
        }
        PaymentUtils.validateCreditLimit(account.get().getBalance(), paymentInfo.getAmount());

        long difference = account.get().getBalance() - paymentInfo.getAmount();


        paymentInfo.setAccountId(accountInfo.getId());
        paymentInfo.setAmount(difference);
        accountInfo.setBalance(difference);
        paymentInfoRepository.save(paymentInfo);
        accountRepository.save(accountInfo);

        return new PaymentAccountAcknowledgement("success", difference, accountInfo);
    }
}
