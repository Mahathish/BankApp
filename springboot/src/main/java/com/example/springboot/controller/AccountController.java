package com.example.springboot.controller;

import com.example.springboot.model.Account;
import com.example.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/balanceGreaterThan/{balance}")
    public List<Account> getAccountsByBalanceGreaterThan(@PathVariable double balance) {
        return accountService.getAccountsByBalanceGreaterThan(balance);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable int id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
    }
}
