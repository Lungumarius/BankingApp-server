package services.implementation;

import com.example.bankingappserver.model.Customer;
import com.example.bankingappserver.services.implementation.AuthServiceImp;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = Customer.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) //this was required to test null parameters
public class AuthServiceImpTests {



    @Test
    @NullSource //this is also required for null parameters
    public void authenticate_whenNullValueIsProvidedForInput_resultShouldBeFalse() {
        {
            try {
                Customer customer = new Customer();
                AuthServiceImp authServiceImp = new AuthServiceImp();
                boolean result = authServiceImp.authenticate("", "");
                assertFalse(result, "result should be false");
                System.out.println(result);
            } catch (NullPointerException expected) {
                expected.getCause();
            }
        }
    }

    // ill try to get the following 2 tests to work during weekend,prob need to change authenticate method
    @Test
    public void authenticate_whenIncorrectValuesAreProvided_resultShouldBeFalse(){
        Customer customer = new Customer();
        customer.setUsername("someUser");
        customer.setPassword("somePass");
        AuthServiceImp authServiceImp = new AuthServiceImp();
        boolean result = authServiceImp.authenticate("1", "1");
        assertFalse(result,"this should return false");
        System.out.println(result);
    }

    @Test
    public void authenticate_whenCorrectValuesAreProvided_resultShouldBeTrue(){
        Customer customer = new Customer();
        customer.setUsername("someUser");
        customer.setPassword("somePass");
        AuthServiceImp authServiceImp = new AuthServiceImp();
        boolean result = authServiceImp.authenticate("someUser", "somePass");
        assertTrue(result,"this should return true");
        System.out.println(result);
    }
}

