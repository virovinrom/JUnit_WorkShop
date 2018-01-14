package lv.javaguru.junit.workshop.section3;

import lv.javaguru.junit.workshop.section3.domain.User;

public interface ChangePasswordService {

    void changePassword(User user, String newPassword);

}
