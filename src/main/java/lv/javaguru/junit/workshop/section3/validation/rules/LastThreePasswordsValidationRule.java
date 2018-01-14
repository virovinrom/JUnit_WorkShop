package lv.javaguru.junit.workshop.section3.validation.rules;

import lv.javaguru.junit.workshop.section3.domain.UserRepository;
import lv.javaguru.junit.workshop.section3.domain.User;

import java.util.List;

class LastThreePasswordsValidationRule implements ValidationRule {

    private UserRepository userRepository;

    LastThreePasswordsValidationRule(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(User user, String newPassword) {
        List<String> lastThreePasswords = userRepository.getLastThreePasswords(user);
        if(lastThreePasswords.contains(newPassword)) {
            throw new RuntimeException("Password must be different of last three");
        }
    }
}
