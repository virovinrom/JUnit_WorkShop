package lv.javaguru.junit.workshop.section3.validation.rules;

import lv.javaguru.junit.workshop.section3.domain.User;

class LengthValidationRule implements ValidationRule {
    @Override
    public void validate(User user, String newPassword) {
        if (newPassword.length() < 5) {
            throw new RuntimeException("Password is less than 5 symbols");
        }
    }
}
