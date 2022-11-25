package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.DTO.TransactionDTO;
import com.example.bankingappserver.exceptions.TransactionFailedException;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.model.Transaction;
import com.example.bankingappserver.repository.TransactionsRepository;
import com.example.bankingappserver.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TransactionServiceImpTest {

    @Autowired
    private TransactionService transactionService;
    @MockBean
    private TransactionsRepository transactionsRepository;

    Customer remitter;
    Customer receiver;
    Account remittersAccount;
    Account receiversAccount;
    Account receiversSecretAccount;
    Transaction transaction1;
    Transaction transaction2;
    Transaction transaction3;

    @BeforeEach
    void setUp() throws Exception {

        remitter = new Customer("Senior", "Dinero",
                "dinero@mucho@elMondo.se", "999999", "zuper$Ecure");
        receiver = new Customer("Pepe", "MinusDinero",
                "pepe@noMucho@elMondo.se", "000000", "que");

        remittersAccount = new Account(5_000_00.00, remitter);
        receiversAccount = new Account(-1_000.00, receiver);
        receiversSecretAccount = new Account(-1_000.00, receiver);

        transaction1 = new Transaction(remittersAccount, receiversAccount, 50.20);
        transaction2 = new Transaction(remittersAccount, receiversAccount, 150.00);
        transaction3 = new Transaction(remittersAccount, receiversAccount, 11.50);

        transactionService.saveTransAction(transaction1);
        transactionService.saveTransAction(transaction2);
        transactionService.saveTransAction(transaction3);
    }

    @Test
    void whenTransactionCreated_thenShouldReturnTransactionDTO() throws Exception {
        assertEquals(transactionService.saveTransAction(transaction1), new TransactionDTO(transaction1.getRemitter(),
                transaction1.getReceiver(), transaction1.getAmount()));
    }

    @Test
    void whenTransactionCreatedWithEmptyField_thenShouldThrowException() {
      assertThrows(TransactionFailedException.class ,()->{
          transactionService.saveTransAction(new Transaction(null, null, 0));
      });
    }

    @Test
    void whenSearchTransactionByRemitter_thenReturnListOfTransactions() {


    }

    @Test
    void findAllByReceiver() {
    }

    @Test
    void findAllByRemitterAndReceiver() {
    }

}