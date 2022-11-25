package com.example.bankingappserver.services;

import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Customer;

import java.util.List;


public interface CustomerService {

    public CustomerDTO saveNewCustomer(Customer customer);

    public CustomerDTO findCustomerById(int id);

    public CustomerDTO findCustomerByEmailAndPassword(String email, String password);

    public void addAccountToCustomer(Account account, Customer customer);

    List<Account> findAllAccounts(Customer customer);
}
