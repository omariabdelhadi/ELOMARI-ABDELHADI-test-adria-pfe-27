package com.abdelhadielomari.transactionservice.repository;


import com.abdelhadielomari.transactionservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {}
