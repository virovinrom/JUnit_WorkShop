package lv.javaguru.junit.workshop.section4;

public interface ChangePasswordService {
    Response changePassword(User user, String newPassword);
}
