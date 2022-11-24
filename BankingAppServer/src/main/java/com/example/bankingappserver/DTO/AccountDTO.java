package com.example.bankingappserver.DTO;

import com.example.bankingappserver.model.Customer;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class AccountDTO {

    private Double balance;
    Customer customer;

}
