package com.example.bankingappserver.services;

import com.example.bankingappserver.DTO.AccountDTO;
import com.example.bankingappserver.model.Account;

public interface AccountService {

    // when creating a new account we need to assign it to the current logged in user
    public Account saveNewAccount(AccountDTO accountDTO, String mail);

    public Account getAccountByUserId(int id);

}
