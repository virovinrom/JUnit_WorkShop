package lv.javaguru.junit.workshop.section3;

import lv.javaguru.junit.workshop.section3.domain.UserRepository;
import lv.javaguru.junit.workshop.section3.domain.User;
import lv.javaguru.junit.workshop.section3.validation.PasswordValidator;

class ChangePasswordServiceImpl implements ChangePasswordService {

    private UserRepository userRepository;
    private PasswordValidator passwordValidator;

    @Override
    public void changePassword(User user, String newPassword) {
        passwordValidator.validate(user, newPassword);
        userRepository.saveNewPassword(user, newPassword);
    }

}
