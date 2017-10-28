package ru.ezhov.validators;

import org.junit.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 28.10.2017.
 */
public class CustomerITest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() throws Exception {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        validatorFactory.close();
    }

    @Test
    public void shouldRiseNoConstraintViolation() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("test@mail.ru");
        customer.setDateOfBirth(new Date(5000));

        Set<ConstraintViolation<Customer>> set = validator.validate(customer);

        assertEquals(0, set.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseInvalidEmail() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("test");
        customer.setDateOfBirth(new Date(5000));

        Set<ConstraintViolation<Customer>> set = validator.validate(customer);

        assertEquals(1, set.size());
        assertEquals("email, который ты пытаешься мне подсунуть полная дичь", set.iterator().next().getMessage());
    }
}