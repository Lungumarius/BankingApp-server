package com.example.bankingappserver.controller;

import com.example.bankingappserver.CustomerService;
import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.model.CustomerDTO;
import com.example.bankingappserver.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public void saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
    }

    @GetMapping("/getall")
    public List<Customer> getAll(){
        List list = new ArrayList();
        customerRepository.findAll().forEach(
                customer -> {
                    list.add(customer);
                }
        );
        return list;
    }
}
