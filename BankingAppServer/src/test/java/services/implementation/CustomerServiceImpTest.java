package services.implementation;

import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import services.CustomerService;

class CustomerServiceImpTest {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@mail.com");
        customer.setPhone("+333 555 777");
        customer.setPassword("Abcd123!");
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void saveNewCustomer() {
    }

    @Test
    void findCustomerById() {
    }

    @Test
    void findCustomerByEmailAndPassword() {
    }

    @Test
    void addAccountToCustomer() {
    }

    @Test
    void findAllAccounts() {
    }
}