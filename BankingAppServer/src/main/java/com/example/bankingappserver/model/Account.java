package com.example.bankingappserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Data
@Entity
public class Account {
    @Id
    private Long id;
    private Double balance;
    @ManyToOne
    private Customer customer;


}
