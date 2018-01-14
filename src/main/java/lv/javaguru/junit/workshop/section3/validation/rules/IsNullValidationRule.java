package lv.javaguru.junit.workshop.section3.validation.rules;

import lv.javaguru.junit.workshop.section3.domain.User;

class IsNullValidationRule implements ValidationRule {

    @Override
    public void validate(User user, String newPassword) {
        if (newPassword == null) {
            throw new RuntimeException("Password is null");
        }
    }
}
