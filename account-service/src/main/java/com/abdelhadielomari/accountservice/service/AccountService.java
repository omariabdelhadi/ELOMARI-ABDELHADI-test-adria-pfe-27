package com.abdelhadielomari.accountservice.service;


import com.abdelhadielomari.accountservice.entities.Account;
import com.abdelhadielomari.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account getAccount(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account createAccount(Account account) {
        account.setId(UUID.randomUUID());
        return accountRepository.save(account);
    }

    public void updateBalance(UUID id, double newBalance) {
        Account acc = getAccount(id);
        acc.setBalance(newBalance);
        accountRepository.save(acc);
    }
}
