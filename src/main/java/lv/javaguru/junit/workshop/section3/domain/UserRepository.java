package lv.javaguru.junit.workshop.section3.domain;

import java.util.List;

public interface UserRepository {

    List<String> getLastThreePasswords(User user);

    void saveNewPassword(User user, String newPassword);

}
