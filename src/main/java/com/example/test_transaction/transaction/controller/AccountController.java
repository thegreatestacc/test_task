package com.example.test_transaction.transaction.controller;

import com.example.test_transaction.transaction.entity.Account;
import com.example.test_transaction.transaction.service.AccountService;
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
    private final AccountService accountService;

    @GetMapping("/all")
    public Iterable<Account> getAllAccounts() {
        return accountService.accounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        var result = accountService.findAccountById(id);
        return result.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @SneakyThrows
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        var result = accountService.createAccount(account);
        return ResponseEntity.created(new URI("/account/create" + result.getId()))
                .body(result);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Account> editAccount(@PathVariable Long id, @RequestParam Long balance) {
        var result = accountService.editAccount(id, balance);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Account> deleteProduct(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
}
