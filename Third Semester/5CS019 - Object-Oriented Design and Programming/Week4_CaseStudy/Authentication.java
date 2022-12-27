package Week4_CaseStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Authentication {
    private static List<User> userData = new ArrayList<User>();

    protected static void addToUserData(User user) {
        userData.add(user);
    }

    protected static void showAllUser() {
        for (int i = 0; i < userData.size(); i++) {
            System.out.println((i + 1) + ") " + userData.get(i).getFullName());
        }
        System.out.println("\n");
    }

    protected static void showUserData(String accessToken, int index) {
        if (accessToken.equals("admin")) {
            System.out.println("Full Name: " + userData.get(index - 1).getFullName());
            System.out.println("Mobile Number: " + userData.get(index - 1).getMobileNumber());
            System.out.println("Date of Birth: " + userData.get(index - 1).getDateOfBirth());
        } else {
            System.out.println("\nForbidden! Wrong Access Token!");
        }
    }

    protected static boolean isUserDataEmpty() {
        return (userData.size() == 0);
    }
}

class Signup extends Authentication {
    public static void signup(Scanner scanner) {

        User user = new User();
        scanner.nextLine();

        while (true) {
            try {
                System.out.println("Please enter your full name: ");
                String fullName = scanner.nextLine();
                user.setFullName(fullName);
                break;
            } catch (InvalidInputException e) {
                System.out.println("\n" + e.getMessage());
            }
        }

        while (true) {
            try {

                System.out.println("Please enter your mobile number: ");
                String mobileNumber = scanner.next();
                user.setMobileNumber(mobileNumber);
                break;
            } catch (InvalidInputException e) {
                System.out.println("\n" + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Please enter your password: ");
                String password = scanner.next();

                System.out.println("Please confirm your password: ");
                String confirmPassword = scanner.next();

                user.setPassword(password, confirmPassword);
                break;
            } catch (InvalidInputException e) {
                System.out.println("\n" + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Please enter your date of birth (DD/MM/YYYY): ");
                String dateOfBirth = scanner.next();
                user.setDateOfBirth(dateOfBirth);
                break;
            } catch (InvalidInputException e) {
                System.out.println("\n" + e.getMessage());
            }
        }

        Authentication.addToUserData(user);
        System.out.println("\nUser registered successfully.");
    }
}
