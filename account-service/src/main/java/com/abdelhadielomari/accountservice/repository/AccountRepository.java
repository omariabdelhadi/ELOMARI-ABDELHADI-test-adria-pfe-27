package com.abdelhadielomari.accountservice.repository;


import com.abdelhadielomari.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {}
