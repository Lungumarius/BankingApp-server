package com.example.bankingappserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
}
