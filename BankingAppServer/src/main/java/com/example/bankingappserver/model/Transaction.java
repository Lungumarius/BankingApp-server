package com.example.bankingappserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Transaction {

    @Id
    private Long id;
    @OneToOne
    private Account remitter;
    @OneToOne
    private Account receiver;
    private double amount;

    public Transaction(Account remitter, Account receiver, double amount) {
        this.remitter = remitter;
        this.receiver = receiver;
        this.amount = amount;
    }
}
