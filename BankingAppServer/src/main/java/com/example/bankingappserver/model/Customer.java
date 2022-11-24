package com.example.bankingappserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Customer {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    //customer must have access to his accounts
    @OneToMany
    private List<Account> accounts = new ArrayList<>();


    //getters and setters


}
