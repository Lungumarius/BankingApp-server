package com.example.bankingappserver.repository;

import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository <Transaction, Integer> {

    List<Transaction> findAllByRemitter(Account remitter);
    List<Transaction> findAllByReceiver(Account receiver);
    List<Transaction> findAllByRemitterAndReceiver(Account remitter, Account receiver);
    Transaction createTransaction(Account remitter, Account receiver, double amount);
}
