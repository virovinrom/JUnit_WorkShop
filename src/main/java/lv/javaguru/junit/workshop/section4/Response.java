package lv.javaguru.junit.workshop.section4;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private boolean success;
    private List<String> errorMessages;

    public Response(boolean success) {
        this.success = success;
        this.errorMessages = new ArrayList();
    }

    public Response(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessages = new ArrayList();
        errorMessages.add(errorMessage);
    }

    public Response(boolean success, List<String> errorMessages) {
        this.success = success;
        this.errorMessages = errorMessages;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
