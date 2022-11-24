package com.example.bankingappserver.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private String password;
}
