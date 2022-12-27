package Week4_CaseStudy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice;
            System.out.println(
                    "\nPlease enter 1 for Sign Up.\nPlease enter 2 to show all registered user.\nPlease enter 3 for Quit.\n");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                break;
            }
            if (choice == 1) {
                Signup.signup(scanner);
                continue;
            } else if (choice == 2) {
                if (Authentication.isUserDataEmpty()) {
                    System.out.println("0 User Registered :((");
                    continue;
                }
                Authentication.showAllUser();

                System.out.println("Please enter the number whose data you want to view or 0 to return to main menu: ");
                int index;
                try {
                    index = scanner.nextInt();
                } catch (Exception e) {
                    continue;
                }
                if (index == 0) {
                    continue;
                }
                System.out.println("Please enter your access token: ");
                String accessToken = scanner.next();

                Authentication.showUserData(accessToken, index);

                continue;
            }
            break;
        }
        System.out.println("Thank you for using the application.");
        scanner.close();
    }
}
