package com.abdelhadielomari.transactionservice.web.graphql;


import com.abdelhadielomari.transactionservice.entities.Transaction;
import com.abdelhadielomari.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TransactionGraphQLController {
    private final TransactionService transactionService;

    @MutationMapping
    public Transaction createTransaction(@Argument TransactionInput input) {
        Transaction tx = Transaction.builder()
                .accountId(input.accountId())
                .amount(input.amount())
                .currency(input.currency())
                .merchantCategory(input.merchantCategory())
                .country(input.country())
                .build();
        return transactionService.createTransaction(tx);
    }

    public record TransactionInput(java.util.UUID accountId, java.math.BigDecimal amount,
                                   String currency, String merchantCategory, String country) {}
}
