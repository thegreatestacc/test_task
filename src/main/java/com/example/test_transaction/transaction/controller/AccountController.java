package com.example.test_transaction.transaction.controller;

import com.example.test_transaction.transaction.dto.AccountRequest;
import com.example.test_transaction.transaction.dto.PaymentAccountAcknowledgement;
import com.example.test_transaction.transaction.entity.AccountInfo;
import com.example.test_transaction.transaction.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/edit")
    public PaymentAccountAcknowledgement edit(@RequestBody AccountRequest request) {
        return accountService.payment(request);
    }
}
