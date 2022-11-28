package com.example.bankingappserver.DTO;

import com.example.bankingappserver.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDTO {

    private Account remitter;
    private Account receiver;
    private double amount;
}
