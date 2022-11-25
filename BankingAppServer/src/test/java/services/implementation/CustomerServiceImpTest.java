package services.implementation;

import com.example.bankingappserver.BankingAppServerApplication;
import com.example.bankingappserver.DTO.CustomerDTO;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

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
//    Account account = new Account(1L,2D,customer);
    Customer customer = new Customer(1L,"John","Doe","john.doe@mail.com","+333 555 777","Abcd123!",accountList);
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

        Assert.assertEquals(customer.getPhone(),customerDTO.getPhone());
        Assert.assertEquals(customer.getLastName(),customerDTO.getLastName());
        Assert.assertEquals(customer.getEmail(),customerDTO.getEmail());
        Assert.assertEquals(customer.getPassword(),customerDTO.getPassword());
        Assert.assertEquals(customer.getFirstName(),customerDTO.getFirstName());

    }

    @Test
    void saveUser() {

        when(customerRepository.save(customer)).thenReturn(customer);
        customerRepository.save(customer);
        Mockito.verify(customerRepository, times(1)).save(customer);

    }

    @Test
    void findCustomerById() {
    }

    @Test
    void login() {
    }

    @Test
    void addAccountToCustomer() {
    }

    @Test
    void findAllAccounts() {
    }
}