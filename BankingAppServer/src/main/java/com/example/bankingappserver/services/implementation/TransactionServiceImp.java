package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.DTO.TransactionDTO;
import com.example.bankingappserver.exceptions.TransactionFailedException;
import com.example.bankingappserver.exceptions.TransactionNotFoundException;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;
import com.example.bankingappserver.repository.AccountRepository;
import com.example.bankingappserver.repository.TransactionsRepository;
import com.example.bankingappserver.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImp implements TransactionService {


    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public TransactionDTO saveTransAction(Transaction transaction) throws TransactionFailedException {
        checkFields(transaction);
        isEnoughFunds(transaction.getRemitter(), transaction.getAmount());
        transactionsRepository.save(transaction);
        return getTransactionDTO(transaction);
    }

    @Override
    public List<TransactionDTO> findAllByRemitter(Account remitter) throws TransactionNotFoundException {
        if (transactionsRepository.findAllByRemitter(remitter).isEmpty()) {
            throw new TransactionNotFoundException();
        }
        return getListOfTransactionDTO(transactionsRepository.findAllByRemitter(remitter));
    }

    @Override
    public List<TransactionDTO> findAllByReceiver(Account receiver) throws TransactionNotFoundException {
        if (transactionsRepository.findAllByReceiver(receiver).isEmpty()) {
            throw new TransactionNotFoundException();
        }
        return getListOfTransactionDTO(transactionsRepository.findAllByReceiver(receiver));
    }

    @Override
    public List<TransactionDTO> findAllByRemitterAndReceiver(Account remitter, Account receiver) throws TransactionNotFoundException {
        if (transactionsRepository.findAllByRemitterAndReceiver(remitter, receiver).isEmpty()) {
            throw new TransactionNotFoundException();
        }
        return getListOfTransactionDTO(transactionsRepository.findAllByRemitterAndReceiver(remitter, receiver));
    }


    private TransactionDTO getTransactionDTO(Transaction transaction) {
        return new TransactionDTO(transaction.getRemitter(), transaction.getReceiver(), transaction.getAmount());
    }

    private List<TransactionDTO> getListOfTransactionDTO(List<Transaction> transactions) {
        return transactions.stream().map(this::getTransactionDTO).collect(Collectors.toList());
    }

    private void checkFields(Transaction transaction) throws TransactionFailedException {
        if (transaction.getRemitter() == null || transaction.getReceiver() == null || transaction.getAmount() <= 0) {
            throw new TransactionFailedException(transaction);
        }
    }

    private void isEnoughFunds(Account remitter, double amount) throws TransactionFailedException {
        if (remitter.getBalance() >= amount) {
            throw new TransactionFailedException();
        }
        remitter.setBalance(remitter.getBalance() - amount);
        accountRepository.saveAndFlush(remitter);
    }
}
