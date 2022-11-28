package services.implementation;

import com.example.bankingappserver.BankingAppServerApplication;
import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = BankingAppServerApplication.class)
class CustomerServiceImpTest {

    @MockBean
    private CustomerRepository customerRepository;

//    @Autowired
//    private CustomerService customerService;
CustomerDTO customerDTO = new CustomerDTO("John","Doe","john.doe@mail.com","+333 555 777","Abcd123!");
//        customerDTO.setFirstName();
//        customerDTO.setLastName();
//        customerDTO.setEmail();
//        customerDTO.setPhone();
//        customerDTO.setPassword();



    List<Account> accountList = new ArrayList<>();
    Long id = 1L;

    Customer customer = new Customer(id, "John","Doe","john.doe@mail.com","+333 555 777","Abcd123!","pass",accountList);
//        customer.setFirstName("John");
//        customer.setLastName("Doe");
//        customer.setEmail("john.doe@mail.com");
//        customer.setPhone("+333 555 777");
//        customer.setPassword("Abcd123!");


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void convertCustomertoDTO(){
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setPassword(customerDTO.getPassword());

        Assertions.assertEquals(customer.getPhone(), customerDTO.getPhone());
        Assertions.assertEquals(customer.getLastName(), customerDTO.getLastName());
        Assertions.assertEquals(customer.getEmail(), customerDTO.getEmail());
        Assertions.assertEquals(customer.getPassword(), customerDTO.getPassword());
        Assertions.assertEquals(customer.getFirstName(), customerDTO.getFirstName());

    }
    @Test
    void convertDTOToCustomer(){
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setPassword(customer.getPassword());

        Assertions.assertEquals(customer.getPhone(), customerDTO.getPhone());
        Assertions.assertEquals(customer.getLastName(), customerDTO.getLastName());
        Assertions.assertEquals(customer.getEmail(), customerDTO.getEmail());
        Assertions.assertEquals(customer.getPassword(), customerDTO.getPassword());
        Assertions.assertEquals(customer.getFirstName(), customerDTO.getFirstName());

    }


    @Test
    void saveUser() {

        when(customerRepository.save(customer)).thenReturn(customer);
        customerRepository.save(customer);
        Mockito.verify(customerRepository, times(1)).save(customer);

    }

    @Test
    void findCustomerById() {
        when(customerRepository.findById(1L)).thenReturn(Optional.ofNullable(customer));
        customerRepository.findById(1L);
        Assertions.assertEquals(customerRepository.findById(1L), Optional.ofNullable(customer));
        Mockito.verify(customerRepository, times(2)).findById(1L);
    }

    @Test
    void login() {
    }
    @Test
    void findCustomerIdByMail(){
        when(customerRepository.findCustomerByEmail("john.doe@mail.com")).thenReturn(customer);
        customerRepository.findCustomerByEmail("john.doe@mail.com");
        Mockito.verify(customerRepository, times(1)).findCustomerByEmail("john.doe@mail.com");
    }

//    @Test
//    void addAccountToCustomer() {
//        when*
//    }

    @Test
    void findAllAccounts() {
    }
}