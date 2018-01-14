package lv.javaguru.junit.workshop.section3.validation.rules;

import lv.javaguru.junit.workshop.section3.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ValidationRuleFactoryTest {

    private UserRepository userRepository;
    private ValidationRuleFactory factory;


    @Before
    public void setup() {
        userRepository = mock(UserRepository.class);
        factory = new ValidationRuleFactory(userRepository);
    }

    @Test
    public void shouldContain5Rules() {
        List<ValidationRule> rules = factory.createValidationRules();
        assertThat(rules, is(notNullValue()));
        assertThat(rules.size(), is(5));
    }

    @Test
    public void shouldBeInRightOrder() {
        List<ValidationRule> rules = factory.createValidationRules();
        assertThat(rules.get(0), is(instanceOf(IsNullValidationRule.class)));
        assertThat(rules.get(1), is(instanceOf(IsEmptyValidationRule.class)));
    }

}
