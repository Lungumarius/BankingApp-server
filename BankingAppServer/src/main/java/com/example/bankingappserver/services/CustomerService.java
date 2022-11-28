package com.example.bankingappserver.services;

import com.example.bankingappserver.DTO.AccountDTO;
import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.model.Customer;

import java.util.List;


public interface CustomerService {

    public Customer convertDTOtoCustomer(CustomerDTO customerDTO);
    public CustomerDTO convertCustomerToDTO(Customer customer);

    public void saveNewCustomer(CustomerDTO customerDTO);

    public CustomerDTO findCustomerByMail(String mail);

    public Long findCustomerIdByMail(String mail);

    CustomerDTO findCustomerByMail(Long id);

    public CustomerDTO login(String email, String password);

    List<AccountDTO> findAllAccounts(String customerMail);
}
