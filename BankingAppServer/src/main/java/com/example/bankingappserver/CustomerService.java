package com.example.bankingappserver;

import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.model.CustomerDTO;
import com.example.bankingappserver.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public Customer convertDTOtoCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setPassword(Base64.getEncoder().encodeToString(customerDTO.getPassword().getBytes()));
        return customer;

    }
    public void saveCustomer(CustomerDTO customerDTO){
        customerRepository.save(convertDTOtoCustomer(customerDTO));
    }
}
