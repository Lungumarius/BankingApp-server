package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.DTO.TransactionDTO;
import com.example.bankingappserver.exceptions.TransactionFailedException;
import com.example.bankingappserver.exceptions.TransactionNotFoundException;
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

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

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
    Transaction transaction4;

    @BeforeEach
    void setUp() throws Exception {

        remitter = new Customer("Senior", "Dinero",
                "dinero@mucho@elMondo.se", "999999", "zuper$Ecure");
        receiver = new Customer("Pepe", "MinusDinero",
                "pepe@noMucho@elMondo.se", "000000", "que");

        remittersAccount = new Account(5_000_000.00, remitter);
        receiversAccount = new Account(-1_000.00, receiver);
        receiversSecretAccount = new Account(5_000.00, receiver);

        transaction1 = new Transaction(remittersAccount, receiversAccount, 500.20);
        transaction2 = new Transaction(remittersAccount, receiversAccount, 150.00);
        transaction3 = new Transaction(remittersAccount, receiversAccount, 110.50);
        transaction4 = new Transaction(receiversSecretAccount, receiversAccount, 239.30);

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
    void whenNotEnoughFunds_thenShouldThrowException() {
        assertThrows(TransactionFailedException.class ,()->{
            transactionService.saveTransAction(new Transaction(remittersAccount, receiversAccount, 1_000_000.00));
        });
    }

    @Test
    void whenSearchTransactionByRemitter_thenReturnListOfTransactions() throws TransactionNotFoundException {
        when(transactionsRepository.findAllByRemitter(remittersAccount)).thenReturn(Stream.of(transaction1, transaction2,
                transaction3).collect(Collectors.toList()));
        assertEquals(3, transactionService.findAllByRemitter(remittersAccount).size());
    }

    @Test
    void whenSearchTransactionByReceiver_thenReturnListOfTransactions() throws TransactionNotFoundException {
        when(transactionsRepository.findAllByReceiver(receiversAccount)).thenReturn(Stream.of(transaction1, transaction2,
                transaction3, transaction4).collect(Collectors.toList()));
        assertEquals(4, transactionService.findAllByReceiver(receiversAccount).size());
    }

    @Test
    void whenSearchTransactionByRemitterAndReceiver_thenReturnListOfTransactions() throws TransactionNotFoundException {
        when(transactionsRepository.findAllByRemitterAndReceiver(remittersAccount, receiversAccount))
                .thenReturn(Stream.of(transaction1, transaction2,
                transaction3).collect(Collectors.toList()));
        assertEquals(3, transactionService.findAllByRemitterAndReceiver(remittersAccount,receiversAccount).size());
    }

}