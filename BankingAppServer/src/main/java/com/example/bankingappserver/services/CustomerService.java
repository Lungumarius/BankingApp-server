package com.example.bankingappserver.services;

import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Customer;

import java.util.List;


public interface CustomerService {

    public Customer convertDTOtoCustomer(CustomerDTO customerDTO);
    public CustomerDTO convertCustomerToDTO(Customer customer);

    public void saveNewCustomer(CustomerDTO customerDTO);

    public CustomerDTO findCustomerById(Long id);

    public Long findCustomerIdByMail(String mail);

    public CustomerDTO login(String email, String password);

    List<Account> findAllAccounts(Customer customer);
}
