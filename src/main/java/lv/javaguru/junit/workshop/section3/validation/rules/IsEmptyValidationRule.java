package lv.javaguru.junit.workshop.section3.validation.rules;

import lv.javaguru.junit.workshop.section3.domain.User;

class IsEmptyValidationRule implements ValidationRule {

    @Override
    public void validate(User user, String newPassword) {
        if (newPassword.isEmpty()) {
            throw new RuntimeException("Password is empty");
        }
    }
}
