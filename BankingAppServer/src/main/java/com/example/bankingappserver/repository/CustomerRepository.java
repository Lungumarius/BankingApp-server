package com.example.bankingappserver.repository;

import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public CustomerDTO findByEmailAndPassword(String email, String password);
 
}
