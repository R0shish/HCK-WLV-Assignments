package Week5_CaseStudy.SystemUser;

import java.util.InputMismatchException;
import java.util.Scanner;

import Week5_CaseStudy.Main;
import Week5_CaseStudy.Models.RentalProperty;

public class Admin extends SystemUser {
    final String role = "Admin";
    final Scanner scanner;

    public Admin(Scanner scanner) {
        this.scanner = scanner;
    }

    // Auth
    @Override
    public void login() {
        System.out.println("\nWelcome Admin!");
        while (true) {
            Main.showDivider();
            System.out.println("""

                    What would you like to do?

                    1) Add Landlord
                    2) Update Landlord
                    3) Delete Landlord
                    4) Add Tenant
                    5) Update Tenant
                    6) Delete Tenant
                    7) Generate Report
                    8) Logout
                    """);

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                choice = 9;
            }
            switch (choice) {
                case 1:
                    addLandlord();
                    break;
                case 2:
                    updateLandlord();
                    break;
                case 3:
                    deleteLandlord();
                    break;
                case 4:
                    addTenant();
                    break;
                case 5:
                    updateTenant();
                    break;
                case 6:
                    deleteTenant();
                    break;
                case 7:
                    System.out.println(generateReport());
                    break;
                case 8:
                    logout();
                    break;
                default:
                    System.out.println("Wrong Input!");
                    scanner.nextLine();
                    continue;
            }
            if (choice == 8)
                break;
        }
    }

    @Override
    public void logout() {
        System.out.println("Logged Out Successfully!");
    }

    // Landlord
    public void addLandlord() {
        Main.showDivider();
        scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Please enter the following property details:");
        System.out.println("No of Rooms:");
        int numberOfRooms = scanner.nextInt();
        System.out.println("Level of Room:");
        int levelOfRoom = scanner.nextInt();
        System.out.println("Location:");
        String location = scanner.next();
        System.out.println("Length of Stay:");
        int lengthOfStay = scanner.nextInt();

        System.out.println("Enter your contact details: ");
        String contactDetails = scanner.next();

        System.out.println("Enter your rental charge: ");
        String rentalCharge = scanner.next();

        Landlord landlord = new Landlord(name, new RentalProperty(numberOfRooms, levelOfRoom, location, lengthOfStay),
                contactDetails, rentalCharge, scanner);
        Main.addLandlord(landlord);
    }

    public void updateLandlord() {
        if (Main.showLandlords(role) == 404)
            return;
        System.out.println("\nEnter the number of the landlord you want to update: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Landlord landlord = Main.getLandlordData(role).get(choice - 1);
        System.out.println("Enter your name: ");
        landlord.setName(scanner.nextLine());
        System.out.println("Enter your contact details: ");
        landlord.setContactDetails(scanner.nextLine());
        System.out.println("Enter your rental charge: ");
        landlord.setRentalCharge(scanner.nextLine());
    }

    public void deleteLandlord() {
        if (Main.showLandlords(role) == 404)
            return;
        System.out.println("\nEnter the number of the landlord you want to delete: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Main.getLandlordData(role).remove(choice - 1);
        System.out.println("Landlord Deleted Successfully!");
    }

    // Tenants
    public void addTenant() {
        Main.showDivider();
        scanner.nextLine();
        while (true) {
            System.out.println("Please choose a type of tenant\n1) Family\n2)Student: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Wrong Input!");
            }
        }

    }

    public void updateTenant() {
        if (Main.showLandlords(role) == 404)
            return;
        System.out.println("\nEnter the number of the landlord you want to update: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Landlord landlord = Main.getLandlordData(role).get(choice - 1);
        System.out.println("Enter your name: ");
        landlord.setName(scanner.nextLine());
        System.out.println("Enter your contact details: ");
        landlord.setContactDetails(scanner.nextLine());
        System.out.println("Enter your rental charge: ");
        landlord.setRentalCharge(scanner.nextLine());
    }

    public void deleteTenant() {
        if (Main.showLandlords(role) == 404)
            return;
        System.out.println("\nEnter the number of the tenant you want to delete: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Main.getLandlordData(role).remove(choice - 1);
        System.out.println("Tenant Deleted Successfully!");
    }

    // Generate Reports
    public RentalProperty generateReport() {
        System.out.println("Report Generated Successfully.");
        return new RentalProperty(1, 1, "One", 1);
    }

}
