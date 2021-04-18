package com.example.test_transaction.transaction.controller;

import com.example.test_transaction.transaction.dto.AccountRequest;
import com.example.test_transaction.transaction.dto.PaymentAccountAcknowledgement;
import com.example.test_transaction.transaction.entity.AccountInfo;
import com.example.test_transaction.transaction.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final PaymentService accountService;

    @GetMapping("/all")
    public Iterable<AccountInfo> getAllAccounts() {
        return accountService.accounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountInfo> getAccount(@PathVariable Long id) {
        var result = accountService.findAccountById(id);
        return result.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @SneakyThrows
    @PostMapping("/create")
    public ResponseEntity<AccountInfo> createAccount(@RequestBody AccountInfo account) {
        var result = accountService.createAccount(account);
        return ResponseEntity.created(new URI("/account/create" + result.getId()))
                .body(result);
    }

    @PostMapping("/edit")
    public PaymentAccountAcknowledgement action(@RequestBody AccountRequest request) {
        return accountService.makeTransactionAction(request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccountInfo> deleteProduct(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
}
