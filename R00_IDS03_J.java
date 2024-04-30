import java.util.logging.Logger;
import java.util.regex.Pattern;

public class UserLogin {
    private static final Logger logger = Logger.getLogger(UserLogin.class.getName());

    public static void main(String[] args) {
        String username = "exampleUser";
        boolean loginSuccessful = true; // This can be set based on your login logic

        if (loginSuccessful) {
            logger.severe("User login succeeded for: " + sanitizeUser(username));
        } else {
            logger.severe("User login failed for: " + sanitizeUser(username));
        }
    }

    public static String sanitizeUser(String username) {
        // Corrected the Pattern.matches usage to ensure it works as intended
        return Pattern.matches("[A-Za-z0-9 ]+", username) ? username : "unauthorized user";
    }
}
