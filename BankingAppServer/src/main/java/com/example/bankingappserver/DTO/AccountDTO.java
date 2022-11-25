package com.example.bankingappserver.DTO;

import com.example.bankingappserver.model.Customer;
import lombok.Data;


@Data
public class AccountDTO {

    private Double balance;
    private Customer customer;

}
