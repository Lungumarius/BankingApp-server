package com.example.bankingappserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    private Long id;
    private Double balance;
    @ManyToOne
    private Customer customer;


    public Account(Double balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }
}
