package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.DTO.TransactionDTO;
import com.example.bankingappserver.exceptions.TransactionFailedException;
import com.example.bankingappserver.exceptions.TransactionNotFoundException;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;
import com.example.bankingappserver.repository.TransactionsRepository;
import com.example.bankingappserver.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {


    @Autowired
    private TransactionsRepository transactionsRepository;


    @Override
    public TransactionDTO saveTransAction(Transaction transaction) throws TransactionFailedException {
        checkFields(transaction);
        transactionsRepository.save(transaction);
        return getTransactionDTO(transaction);
    }

    @Override
    public List<Transaction> findAllByRemitter(Account remitter) throws TransactionNotFoundException {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction t : transactionsRepository.findAll()) {
            if (t.getRemitter().equals(remitter)) {
                transactions.add(t);
            }
        }
        if (transactions.isEmpty()){
            throw new TransactionNotFoundException();
        }
        return transactions;
    }

    @Override
    public List<Transaction> findAllByReceiver(Account receiver) {
        return null;
    }

    @Override
    public List<Transaction> findAllByRemitterAndReceiver(Account remitter, Account receiver) {
        return null;
    }


    private TransactionDTO getTransactionDTO(Transaction transaction) {
        return new TransactionDTO(transaction.getRemitter(), transaction.getReceiver(), transaction.getAmount());
    }

    private void checkFields(Transaction transaction) throws TransactionFailedException {
        if (transaction.getRemitter() == null || transaction.getReceiver() == null || transaction.getAmount() <= 0) {
            throw new TransactionFailedException(transaction);
        }
    }
}
