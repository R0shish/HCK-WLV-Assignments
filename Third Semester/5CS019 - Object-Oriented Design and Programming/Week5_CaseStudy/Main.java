package Week5_CaseStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Week5_CaseStudy.Auth.Auth;
import Week5_CaseStudy.SystemUser.Admin;
import Week5_CaseStudy.SystemUser.Landlord;

public class Main {
    private static List<Landlord> landlordData = new ArrayList<Landlord>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""

                Welcome to Room Rental Management System

                Please login to continue!

                """);

        Auth auth = new Auth();
        String role;

        while (true) {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            try {
                role = auth.getRole(username, password);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        switch (role) {
            case "Admin":
                Admin admin = new Admin();
                admin.login(scanner);
                break;
            case "Landlord":
                Landlord landlord = new Landlord();
                landlord.login(scanner);
                break;
            default:
                break;
        }

        scanner.close();
    }

    public static List<Landlord> getLandlordData(String role) {
        if (role.equals("Admin")) {
            return landlordData;
        }
        throw new AccessForbiddenException("You do not have access to view landlord data.");
    }

    public static void showDivider() {
        System.out.println("--------------------");
    }

    public static void addLandlord(Landlord landlord) {
        Main.landlordData.add(landlord);
    }

}

class AccessForbiddenException extends RuntimeException {
    public AccessForbiddenException(String err) {
        super(err + " Please contact an admin!");
    }
}