package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.repository.AccountRepository;
import com.example.bankingappserver.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImpTest {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveNewAccount() {
    }

    @Test
    void getAccountByUserId() {
    }
}