package services;

import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAllByRemitter(Account remitter);
    List<Transaction> findAllByReceiver(Account receiver);
    List<Transaction> findAllByRemitterAndReceiver(Account remitter, Account receiver);
    Transaction createTransaction(Account remitter, Account receiver, double amount);
}
