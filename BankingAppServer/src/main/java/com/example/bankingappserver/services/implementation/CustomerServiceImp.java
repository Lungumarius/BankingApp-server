package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.repository.CustomerRepository;
import com.example.bankingappserver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO saveNewCustomer(Customer customer) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerById(int id) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public void addAccountToCustomer(Account account, Customer customer) {

    }

    @Override
    public List<Account> findAllAccounts(Customer customer) {
        return null;
    }
}