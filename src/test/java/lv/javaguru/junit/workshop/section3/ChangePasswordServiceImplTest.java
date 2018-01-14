package lv.javaguru.junit.workshop.section3;

import lv.javaguru.junit.workshop.section3.domain.UserRepository;
import lv.javaguru.junit.workshop.section3.domain.User;
import lv.javaguru.junit.workshop.section3.validation.PasswordValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class ChangePasswordServiceImplTest {

    @Mock private UserRepository userRepository;
    @Mock private PasswordValidator passwordValidator;

    @InjectMocks
    private ChangePasswordService service = new ChangePasswordServiceImpl();


    @Test
    public void shouldInvokeValidationAndThenSaveNewPasswordForUser() {
        User user = new User();
        service.changePassword(user, "newPassword");
        InOrder inOrder = inOrder(userRepository, passwordValidator);
        inOrder.verify(passwordValidator).validate(user, "newPassword");
        inOrder.verify(userRepository).saveNewPassword(user, "newPassword");
    }

}
