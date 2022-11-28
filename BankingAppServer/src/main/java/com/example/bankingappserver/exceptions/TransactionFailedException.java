package com.example.bankingappserver.exceptions;

import com.example.bankingappserver.model.Transaction;

public class TransactionFailedException extends Exception {


    public TransactionFailedException(Transaction transaction) {
        getMessage(transaction);
    }

    private String getMessage(Transaction transaction) {
        StringBuilder stringBuilder = new StringBuilder();

        if (transaction.getRemitter() == null) {
            stringBuilder.append("Remitter was not found!\n");
        }
        if (transaction.getReceiver() == null) {
            stringBuilder.append("Receiver was not found!\n");
        }
        if (transaction.getAmount() <= 0){
            stringBuilder.append("Amount cant be 0 or negative.");
        }
        return stringBuilder.toString();
    }
}
