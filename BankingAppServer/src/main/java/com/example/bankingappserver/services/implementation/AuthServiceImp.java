package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.services.AuthService;
import com.example.bankingappserver.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;


public class AuthServiceImp implements AuthService {
    @Autowired
    Customer customer; //always gives null customer even with Autowired

    //not working as intended
    @Override
    public boolean authenticate(String username, String password) {  //returns true if parameters in this method match in customer list.
        return Objects.equals(username, customer.getUsername()) && Objects.equals(password, customer.getPassword());
    }


}
