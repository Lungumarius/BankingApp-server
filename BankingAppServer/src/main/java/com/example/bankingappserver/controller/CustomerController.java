package com.example.bankingappserver.controller;


import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public void saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveNewCustomer(customerDTO);
    }

}