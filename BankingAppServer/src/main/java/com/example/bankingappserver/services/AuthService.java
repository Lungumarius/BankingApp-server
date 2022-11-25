package com.example.bankingappserver.services;

import com.example.bankingappserver.model.Customer;

public interface AuthService {

    boolean authenticate(String username, String password);
}

