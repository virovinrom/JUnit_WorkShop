package lv.javaguru.junit.workshop.section3.validation;

import lv.javaguru.junit.workshop.section3.domain.User;
import lv.javaguru.junit.workshop.section3.validation.rules.ValidationRuleFactory;

class PasswordValidatorImpl implements PasswordValidator {

    private ValidationRuleFactory ruleFactory;

    PasswordValidatorImpl(ValidationRuleFactory ruleFactory) {
        this.ruleFactory = ruleFactory;
    }

    @Override
    public void validate(User user, String newPassword) {
        ruleFactory.createValidationRules()
                .forEach(rule -> rule.validate(user, newPassword));
    }

}
