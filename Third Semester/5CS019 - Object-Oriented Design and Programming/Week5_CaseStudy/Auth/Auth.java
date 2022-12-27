package Week5_CaseStudy.Auth;

import java.util.List;
import java.util.Map;

public class Auth {
    final private List<Map<String, String>> passwordData;

    public Auth() {
        Passwords passwords = new Passwords();
        this.passwordData = passwords.getPasswordData();
    }

    public String getRole(String username, String password) {
        for (Map<String, String> credentials : passwordData) {
            if (username.equals(credentials.get("username")) && password.equals(credentials.get("password"))) {
                return credentials.get("role");
            }
        }
        throw new InvalidCredentialsException("Invalid Username or Password!");
    }
}

class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String err) {
        super(err + " Please try again!");
    }
}
