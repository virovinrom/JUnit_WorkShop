package lv.javaguru.junit.workshop.section3.validation;

import lv.javaguru.junit.workshop.section3.domain.User;
import lv.javaguru.junit.workshop.section3.domain.UserRepository;
import lv.javaguru.junit.workshop.section3.validation.rules.ValidationRuleFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class PasswordValidatorImplTest {

    private UserRepository userRepository;
    private ValidationRuleFactory ruleFactory;
    private PasswordValidator passwordValidator;

    @Before
    public void setup() {
        userRepository = mock(UserRepository.class);
        ruleFactory = new ValidationRuleFactory(userRepository);
        passwordValidator = new PasswordValidatorImpl(ruleFactory);
    }

    @Test
    public void shouldThrowExceptionIfPasswordIsNull1() {
        try {
            passwordValidator.validate(new User(), null);
            fail();
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Password is null");
        }
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionIfPasswordIsNull2() {
        passwordValidator.validate(new User(), null);
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfPasswordIsNull3() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Password is null");
        passwordValidator.validate(new User(), null);
    }

    @Test
    public void shouldThrowExceptionIfPasswordIsEmpty() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Password is empty");
        passwordValidator.validate(new User(), "");
    }

    @Test
    public void shouldThrowExceptionIfPasswordIsLessThan5Symbols() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Password is less than 5 symbols");
        passwordValidator.validate(new User(), "123");
    }

    @Test
    public void shouldThrowExceptionIfPasswordContainsOnlyLetters() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Password must contains letters and numbers");
        passwordValidator.validate(new User(), "abcde");
    }

    @Test
    public void shouldThrowExceptionIfPasswordContainsOnlyNumbers() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Password must contains letters and numbers");
        passwordValidator.validate(new User(), "12345");
    }

    @Test
    public void shouldThrowExceptionIfNewPasswordMachOneOfTheeLast() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Password must be different of last three");

        doReturn(Arrays.asList("1234wq"))
                .when(userRepository).getLastThreePasswords(any(User.class));

        passwordValidator.validate(new User(), "1234wq");
    }

}