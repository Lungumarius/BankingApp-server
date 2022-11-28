package com.example.bankingappserver.repository;

import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByRemitter(Account remitter);
    List<Transaction> findAllByReceiver(Account receiver);
    List<Transaction> findAllByRemitterAndReceiver(Account remitter, Account receiver);
}
