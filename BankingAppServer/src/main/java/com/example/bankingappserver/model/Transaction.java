package com.example.bankingappserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Transaction {

    @Id
    private Long id;
    @OneToOne
    private Account remitter;
    @OneToOne
    private Account receiver;
    private double amount;
}
