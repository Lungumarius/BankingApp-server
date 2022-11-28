package com.example.bankingappserver.controller;

import com.example.bankingappserver.DTO.AccountDTO;
import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.repository.CustomerRepository;
import com.example.bankingappserver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping({"/{mail}"})
    public CustomerDTO getCustomerDTO(@PathVariable("mail") String mail) {
        return this.customerService.findCustomerByMail(mail);
    }
    @GetMapping({"/accounts/{mail}"})
    public List<AccountDTO> getCustomerAccounts(@PathVariable("mail") String email) {
        return null;
    }
    @PutMapping({"/changemail/{mail}"})
    public CustomerDTO changeMail(@PathVariable("mail") String mail) {
        return null;
    }
    @PutMapping({"/changepass/{mail}"})
    public CustomerDTO changePassword(@PathVariable("mail") String mail) {
        return null;
    }



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