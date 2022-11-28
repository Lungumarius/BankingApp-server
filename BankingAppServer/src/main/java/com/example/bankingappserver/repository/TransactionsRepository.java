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

//    List<Transaction> findAllByRemitterAndOrderByDateIssuedDesc(Account remitter);
//    List<Transaction> findAllByRemitterAndOrderByDateIssuedAsc(Account remitter);
//
//    List<Transaction> findAllByReceiverAndOrderByDateIssuedDesc(Account receiver);
//    List<Transaction> findAllByReceiverAndOrderByDateIssuedAsc(Account receiver);
//
//    List<Transaction> findAllByRemitterAndReceiverAndOrderByDateIssuedDesc(Account remitter, Account receiver);
//    List<Transaction> findAllByRemitterAndReceiverAndOrderByDateIssuedAsc(Account remitter, Account receiver);


}
