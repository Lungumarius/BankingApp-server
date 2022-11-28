package com.example.bankingappserver.services;

import com.example.bankingappserver.DTO.TransactionDTO;
import com.example.bankingappserver.exceptions.TransactionFailedException;
import com.example.bankingappserver.exceptions.TransactionNotFoundException;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;

import java.util.List;

public interface TransactionService {

    TransactionDTO saveTransAction(Transaction transaction) throws TransactionFailedException;

    List<TransactionDTO> findAllByRemitter(Account remitter) throws TransactionNotFoundException;

    List<TransactionDTO> findAllByReceiver(Account receiver) throws TransactionNotFoundException;

    List<TransactionDTO> findAllByRemitterAndReceiver(Account remitter, Account receiver) throws TransactionNotFoundException;

}
