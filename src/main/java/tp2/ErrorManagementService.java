package tp2;
import java.util.ArrayList;
import java.util.List;

public class ErrorManagementService {
    private List<String> errorLogs = new ArrayList<>();

    public void logError(String error) {
        errorLogs.add(error);
        System.err.println("Error logged: " + error);
    }

    public List<String> getErrorLogs() {
        return errorLogs;
    }
}