package com.abdelhadielomari.transactionservice.service;


import com.abdelhadielomari.transactionservice.client.AccountClient;
import com.abdelhadielomari.transactionservice.entities.Transaction;
import com.abdelhadielomari.transactionservice.repository.TransactionRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    @CircuitBreaker(name = "accountService", fallbackMethod = "fallbackAccountCheck")
    public Transaction createTransaction(Transaction transaction) {
        // Vérification du compte via Feign
        Map<String, Object> account = accountClient.getAccount(transaction.getAccountId());

        if (!"ACTIVE".equals(account.get("status"))) {
            throw new RuntimeException("Account is not active");
        }

        // Ici tu devras ajouter la logique de solde plus tard
        transaction.setId(UUID.randomUUID());
        transaction.setCreatedAt(Instant.now());
        return transactionRepository.save(transaction);
    }

    // Fallback si Account Service est down ou timeout
    public Transaction fallbackAccountCheck(Transaction transaction, Throwable t) {
        throw new RuntimeException("Account service is currently unavailable. Error: " + t.getMessage());
    }
}
