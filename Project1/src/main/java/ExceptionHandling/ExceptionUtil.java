package ExceptionHandling;

public class ExceptionUtil {
    public static void handleException(Exception e) {
        // Log exception, send alerts, etc.
        System.err.println("An error occurred: " + e.getMessage());
    }
}
