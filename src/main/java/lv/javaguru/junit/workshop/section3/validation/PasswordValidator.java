package lv.javaguru.junit.workshop.section3.validation;

import lv.javaguru.junit.workshop.section3.domain.User;

public interface PasswordValidator {

    void validate(User user, String newPassword);

}
