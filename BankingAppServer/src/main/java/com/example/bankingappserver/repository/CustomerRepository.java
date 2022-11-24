package com.example.bankingappserver.repository;

import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional <Customer> findByEmailAndPassword(String email, String password);

    List<Account> findAllAccounts(Customer customer);
}
