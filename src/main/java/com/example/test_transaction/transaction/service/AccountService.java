package com.example.test_transaction.transaction.service;

import com.example.test_transaction.transaction.entity.Account;
import com.example.test_transaction.transaction.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public Iterable<Account> accounts() {
        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        if (null != id) {
            accountRepository.deleteById(id);
        } else throw new RuntimeException("account not found");
    }

    public Optional<Account> findAccountById(Long id) {
        var foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            return foundAccount;
        } else throw new RuntimeException("account not found");
    }

    @Transactional
    public Account editAccount(Account account, Long id, Long balance) {
        var foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            account.setBalance(balance);
        } else throw new RuntimeException("account not found");
        return accountRepository.save(account);
    }
}
