package lv.javaguru.junit.workshop.section4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class ChangePasswordServiceImplTest {

    @Mock
    private LastThreePasswordProvider lastThreePasswordProvider;

    @InjectMocks
    private ChangePasswordService service = new ChangePasswordServiceImpl();

    @Test
    public void shouldFailWhenNewPasswordIsNull() {
        User user = new User();
        Response response = service.changePassword(user, null);
        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages().get(0), "Password length is less than 5 symbols");
    }

    @Test
    public void shouldFailWhenNewPasswordIsEmpty() {
        User user = new User();
        Response response = service.changePassword(user, "");
        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages().get(0), "Password length is less than 5 symbols");
    }

    @Test
    public void shouldFailWhenNewPasswordLessThan5Symbols() {
        User user = new User();
        Response response = service.changePassword(user, "123");
        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages().get(0), "Password length is less than 5 symbols");
    }

    @Test
    public void shouldFailWhenNewPasswordContainsOnlyLetters() {
        User user = new User();
        Response response = service.changePassword(user, "abcde");
        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages().get(0), "Password must contain letters and numbers");
    }

    @Test
    public void shouldFailWhenNewPasswordContainsOnlyNumbers() {
        User user = new User();
        Response response = service.changePassword(user, "12345");
        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages().get(0), "Password must contain letters and numbers");
    }

    @Test
    public void shouldSuccess() {
        User user = new User();
        Response response = service.changePassword(user, "12a45");
        assertTrue(response.isSuccess());
    }


    @Test
    public void shouldFailWhenLastThreePasswordsContainsNewPassword() {
        User user = new User();

        List<String> oldPasswords = new ArrayList<>();
        oldPasswords.add("1234a");
        oldPasswords.add("1234b");
        oldPasswords.add("1234c");
        Mockito.doReturn(oldPasswords)
                .when(lastThreePasswordProvider)
                .getLastThreePasswords(user);

        Response response = service.changePassword(user, "1234a");
        assertFalse(response.isSuccess());
        assertEquals(response.getErrorMessages().get(0), "New password must be different from last three");
    }

}