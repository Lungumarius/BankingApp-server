package com.example.bankingappserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Data
@Entity
public class Account {
    @Id
    private Integer id;
    private Double balance;
    @ManyToOne
    private Customer customer;


}
