package services.implementation;

import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.model.CustomerDTO;
import com.example.bankingappserver.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO saveNewCustomer(Customer customer) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerById(int id) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerByEmailAndPassword(String email, String password) {
        return null;
    }
}
