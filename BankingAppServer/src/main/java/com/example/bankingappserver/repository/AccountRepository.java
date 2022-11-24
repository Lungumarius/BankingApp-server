package com.example.bankingappserver.repository;

import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findAccountsByCustomer(Customer customer);
}
