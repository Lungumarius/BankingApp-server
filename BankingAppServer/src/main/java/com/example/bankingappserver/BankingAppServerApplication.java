package com.example.bankingappserver;

import com.example.bankingappserver.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingAppServerApplication.class, args);
        Customer customer1 = new Customer();
    }

}
