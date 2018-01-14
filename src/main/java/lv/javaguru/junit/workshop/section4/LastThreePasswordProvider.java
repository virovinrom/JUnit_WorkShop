package lv.javaguru.junit.workshop.section4;

import java.util.List;

public interface LastThreePasswordProvider {
    List<String> getLastThreePasswords(User user);
}
