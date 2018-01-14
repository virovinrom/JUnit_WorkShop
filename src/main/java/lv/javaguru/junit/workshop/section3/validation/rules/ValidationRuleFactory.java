package lv.javaguru.junit.workshop.section3.validation.rules;

import lv.javaguru.junit.workshop.section3.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class ValidationRuleFactory {

    private UserRepository userRepository;

    public ValidationRuleFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<ValidationRule> createValidationRules() {
        List<ValidationRule> rules = new ArrayList<>();
        rules.add(new IsNullValidationRule());
        rules.add(new IsEmptyValidationRule());
        rules.add(new LengthValidationRule());
        rules.add(new LettersAndNumbersValidationRule());
        rules.add(new LastThreePasswordsValidationRule(userRepository));
        return rules;
    }

}
