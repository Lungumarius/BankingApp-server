package services;

import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.model.CustomerDTO;

public interface CustomerService {

    public CustomerDTO saveNewCustomer(Customer customer);

    public CustomerDTO findCustomerById(int id);

    public CustomerDTO findCustomerByEmailAndPassword(String email, String password);
}
