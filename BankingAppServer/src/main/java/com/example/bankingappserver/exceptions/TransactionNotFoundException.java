package com.example.bankingappserver.exceptions;

public class TransactionNotFoundException extends Exception {


    public TransactionNotFoundException() {
        super("No transaction/s found!");
    }


}
