package lv.javaguru.junit.workshop.section4;

import java.util.List;

public class ChangePasswordServiceImpl implements ChangePasswordService {

    private LastThreePasswordProvider lastThreePasswordProvider;

    @Override
    public Response changePassword(User user, String newPassword) {
        if (newPassword == null
                || newPassword.isEmpty()
                || newPassword.length() < 5) {
            return new Response(false, "Password length is less than 5 symbols");
        }

        boolean containsOnlyNumbers = newPassword.matches("\\d+");
        boolean containsOnlyLetters = newPassword.matches("[a-zA-Z]+");
        if (containsOnlyLetters || containsOnlyNumbers) {
            return new Response(false, "Password must contain letters and numbers");
        }

        List<String> lastThreePasswords = lastThreePasswordProvider.getLastThreePasswords(user);
        if (lastThreePasswords.contains(newPassword)) {
            return new Response(false, "New password must be different from last three");
        }

        return new Response(true);
    }

}
