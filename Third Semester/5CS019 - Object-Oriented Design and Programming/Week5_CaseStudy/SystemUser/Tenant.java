package Week5_CaseStudy.SystemUser;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Week5_CaseStudy.Main;

public abstract class Tenant extends SystemUser implements TenantRights {
    String role = "Tenant";
    private String name;
    final Scanner scanner;

    public Tenant(Scanner scanner) {
        this.scanner = scanner;
    }

    // Auth
    @Override
    public void login() {
        System.out.println("\nWelcome Tenant!");
        while (true) {
            Main.showDivider();
            System.out.println("""

                    What would you like to do?

                    1) View Landlord
                    2) Select Landlord
                    3) Leave Room
                    4) Due Payment
                    5) Review Landlord
                    6) Review Rental Property
                    7) Logout
                    """);

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                choice = 8;
            }
            switch (choice) {
                case 1:
                    viewLandlord();
                    break;
                case 2:
                    selectLandlord(null);
                    break;
                case 3:
                    leaveRoom();
                    break;
                case 4:
                    duePayment();
                    break;
                case 5:
                    reviewLandlord();
                    break;
                case 6:
                    reviewRentalProperty();
                    break;
                case 7:
                    logout();
                    break;
                default:
                    System.out.println("Wrong Input!");
                    scanner.nextLine();
                    continue;
            }
            if (choice == 7)
                break;
        }
    }

    @Override
    public void logout() {
        System.out.println("Logged out successfully!");
    }

    abstract void viewLandlord();

    abstract void selectLandlord(ArrayList<Landlord> landlordData);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

interface TenantRights {

    void leaveRoom();

    void duePayment();

    void reviewLandlord();

    void reviewRentalProperty();

}
