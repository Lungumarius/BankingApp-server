package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.repository.CustomerRepository;
import com.example.bankingappserver.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImp implements AuthService {
//    @Autowired
//    Customer customer; //always gives null customer even with Autowired
    // It is null cuz you are getting the model, not the repository where all the users are stored
    @Autowired
    CustomerRepository customerRepository;

    //not working as intended
    @Override
    public boolean authenticate(String username, String password) {
        //returns true if parameters in this method match in customer list.
        //retrieve the customer based on the username given on the login page
        Customer customer = customerRepository.findCustomerByUsername(username);
        return Objects.equals(customer.getPassword(), password);
//        return Objects.equals(username, customer.getUsername()) && Objects.equals(password, customer.getPassword());
    }


}
