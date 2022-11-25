package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;
import com.example.bankingappserver.repository.TransactionRepository;
import com.example.bankingappserver.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAllByRemitter(Account remitter) {
        return null;
    }

    @Override
    public List<Transaction> findAllByReceiver(Account receiver) {
        return null;
    }

    @Override
    public List<Transaction> findAllByRemitterAndReceiver(Account remitter, Account receiver) {
        return null;
    }

    @Override
    public Transaction createTransaction(Account remitter, Account receiver, double amount) {
        return null;
    }
}
