package lv.javaguru.junit.workshop.section3.validation.rules;

import lv.javaguru.junit.workshop.section3.domain.User;

class LettersAndNumbersValidationRule implements ValidationRule {
    @Override
    public void validate(User user, String newPassword) {
        boolean containsOnlyNumbers = newPassword.matches("\\d+");
        boolean containsOnlyLetters = newPassword.matches("[a-zA-Z]+");
        if (containsOnlyLetters || containsOnlyNumbers) {
            throw new RuntimeException("Password must contains letters and numbers");
        }

    }
}
