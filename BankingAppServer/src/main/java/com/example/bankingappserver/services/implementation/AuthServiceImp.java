package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.services.AuthService;
import com.example.bankingappserver.services.AuthService;

import java.util.Objects;


public class AuthServiceImp implements AuthService {
    Customer customer;
    @Override
    public boolean authenticate(String username, String password) {  //returns true if parameters in this method match in customer list.
        return Objects.equals(username, customer.getUsername()) && Objects.equals(password, customer.getPassword());
    }


}
