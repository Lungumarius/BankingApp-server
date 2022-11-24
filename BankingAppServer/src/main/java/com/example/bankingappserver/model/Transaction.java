package com.example.bankingappserver.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Transaction {

    @Id
    private Integer id;
    private Account remitter;
    private Account receiver;
    private double amount;
}
