package com.example.springboot.service;

import com.example.springboot.model.Account;
import com.example.springboot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAccountsByBalanceGreaterThan(double balance) {
        return accountRepository.findByBalanceGreaterThan(balance);
    }

    public Account updateAccount(int id, Account updatedAccount) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            // Update account details based on updatedAccount
            account.setBalance(updatedAccount.getBalance());
            // Set other fields as needed
            return accountRepository.save(account);
        }
        // Handle not found scenario
        return null;
    }

    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }
}
