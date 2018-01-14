package lv.javaguru.junit.workshop.section3.validation.rules;

import lv.javaguru.junit.workshop.section3.domain.User;

public interface ValidationRule {

    void validate(User user, String newPassword);

}
