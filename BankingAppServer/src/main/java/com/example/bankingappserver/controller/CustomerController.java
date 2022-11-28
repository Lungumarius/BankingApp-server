package com.example.bankingappserver.controller;

import com.example.bankingappserver.repository.CustomerRepository;
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
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public void saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveNewCustomer(customerDTO);
    }
//    @PutMapping("/{id}")
//    public CustomerDTO getCustomerDTO(@PathVariable("id") Long id){
//        return customerService.findCustomerIdByMail(id);
//    }

//    @GetMapping("/getall")
//    public List<Customer> getAll(){
//        List list = new ArrayList();
//        customerRepository.findAll().forEach(
//                customer -> {
//                    list.add(customer);
//                }
//        );
//        return list;
//    }
}