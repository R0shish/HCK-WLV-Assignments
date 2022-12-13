package Week4_Workshop.Validate_Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    static boolean validateEmail(String email) {
        String regex = "^np+[0-9]+cs+[0-9]+s+[0-9]{6}+@heraldcollege\\.edu\\.np$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean validatePassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email, password;

        while (true) {
            System.out.println("Enter your email: ");
            email = scanner.nextLine();
            if (Validation.validateEmail(email)) {
                break;
            }
            System.out.println("Invalid Email! Please Try Again!");
        }

        while (true) {
            System.out.println("Enter your password: ");
            password = scanner.nextLine();
            if (Validation.validatePassword(password)) {
                break;
            }
            System.out.println("Invalid Password! Please Try Again!");

        }

        System.out.println(Validation.validatePassword(password) ? "Valid Password" : "Invalid Password");
        scanner.close();
    }
}