package com.example.bankingappserver.services.implementation;

import com.example.bankingappserver.DTO.AccountDTO;
import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.repository.CustomerRepository;
import com.example.bankingappserver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveNewCustomer(CustomerDTO customerDTO) {

        customerRepository.save(convertDTOtoCustomer(customerDTO));
    }



    @Override
    public Customer convertDTOtoCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setPassword(Base64.getEncoder().encodeToString(customerDTO.getPassword().getBytes()));
        return customer;

    }
    public CustomerDTO convertCustomerToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setPassword(Arrays.toString(Base64.getDecoder().decode(customer.getPassword().getBytes())));
        return customerDTO;

    }


    @Override
    public CustomerDTO findCustomerByMail(String mail) {

        return convertCustomerToDTO(Objects.requireNonNull(customerRepository.findCustomerByEmail(mail)));
    }

    @Override
    public Long findCustomerIdByMail(String mail) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerByMail(Long id) {
        return null;
    }

    @Override
    public CustomerDTO login(String email, String password) {
        return null;
    }

//    @Override
//    public void addAccountToCustomer(AccountDTO accountDTO, String email) {
//
//    }
//    public Long findCustomerIdByMail(String email){
//        Customer customer = customerRepository.findCustomerByEmail(email);
//        return customer.getId();
//    }

    @Override
    public List<AccountDTO> findAllAccounts(String customerMail) {
        return null;
    }
}
