package com.example.bankingappserver.services;

import com.example.bankingappserver.DTO.TransactionDTO;
import com.example.bankingappserver.exceptions.TransactionFailedException;
import com.example.bankingappserver.exceptions.TransactionNotFoundException;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;

import java.util.List;

public interface TransactionService {

    TransactionDTO saveTransAction(Transaction transaction) throws TransactionFailedException;
    List<Transaction> findAllByRemitter(Account remitter) throws TransactionNotFoundException;
    List<Transaction> findAllByReceiver(Account receiver);
    List<Transaction> findAllByRemitterAndReceiver(Account remitter, Account receiver);
}
