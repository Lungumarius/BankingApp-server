package com.example.bankingappserver.controller;

import com.example.bankingappserver.DTO.TransactionDTO;
import com.example.bankingappserver.exceptions.TransactionFailedException;
import com.example.bankingappserver.exceptions.TransactionNotFoundException;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Transaction;
import com.example.bankingappserver.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/add")
    public TransactionDTO saveNewTransaction(@RequestBody Transaction transaction) throws TransactionFailedException {
        return transactionService.saveTransAction(transaction);
    }

    @PutMapping("/find_by_remitter")
    public List<TransactionDTO> findAllTransactionByRemitter(@RequestBody Account remitter) throws TransactionNotFoundException {
        return transactionService.findAllByRemitter(remitter);
    }

    @PutMapping("/find_by_receiver")
    public List<TransactionDTO> findAllTransactionByReceiver(@RequestBody Account receiver) throws TransactionNotFoundException {
        return transactionService.findAllByReceiver(receiver);
    }

    @PutMapping("/find_by_remitter_and_receiver")
    public List<TransactionDTO> findAllTransactionByRemitterAndReceiver(@RequestBody Account remitter, @RequestBody Account receiver)
            throws TransactionNotFoundException {
        return transactionService.findAllByRemitterAndReceiver(remitter, receiver);
    }
}
