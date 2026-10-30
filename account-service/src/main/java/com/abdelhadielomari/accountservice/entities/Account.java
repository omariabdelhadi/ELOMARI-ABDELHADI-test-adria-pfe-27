package com.abdelhadielomari.accountservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id
    private UUID id;
    private String customerReference;
    private String status; // ACTIVE | BLOCKED
    private String currency;
    private double balance;
}