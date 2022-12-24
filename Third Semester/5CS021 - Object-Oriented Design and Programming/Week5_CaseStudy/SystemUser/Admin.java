package Week5_CaseStudy.SystemUser;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Week5_CaseStudy.Main;
import Week5_CaseStudy.Models.RentalProperty;

public class Admin extends SystemUser {
    final String role = "Admin";

    // Auth
    @Override
    public void login(Scanner scanner) {
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
                    addLandlord(scanner);
                    break;
                case 2:
                    updateLandlord(scanner);
                    break;
                case 3:
                    deleteLandlord(scanner);
                    break;
                case 4:
                    addTenant(null);
                    break;
                case 5:
                    updateTenant(null);
                    break;
                case 6:
                    deleteTenant(null);
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
        }
    }

    @Override
    public void logout() {
        System.out.println("Logged Out Successfully!");
    }

    // Landlord
    public void addLandlord(Scanner scanner) {
        Main.showDivider();
        scanner.nextLine();
        System.out.println("Please enter the following property details:");

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

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
                contactDetails, rentalCharge);
        Main.addLandlord(landlord);
    }

    public void updateLandlord(Scanner scanner) {
        if (showLandlords() == 404)
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

    public void deleteLandlord(Scanner scanner) {
        if (showLandlords() == 404)
            return;
        System.out.println("\nEnter the number of the landlord you want to delete: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Main.getLandlordData(role).remove(choice - 1);
        System.out.println("Landlord Deleted Successfully!");
    }

    // Tenants
    public void addTenant(Tenant tenant) {
    }

    public void updateTenant(Tenant tenant) {
    }

    public void deleteTenant(String id) {
    }

    // Generate Reports
    public RentalProperty generateReport() {
        return new RentalProperty(1, 1, "One", 1);
    }

    public int showLandlords() {
        List<Landlord> landlords = Main.getLandlordData(role);
        Main.showDivider();
        if (landlords.size() == 0) {
            System.out.println("No Landlords Found!");
            return 404;
        }
        System.out.println("Landlord Details:");
        for (int i = 0; i < landlords.size(); i++) {
            System.out.println((i + 1) + ") " + landlords.get(i).getName());
        }
        return 0;
    }

}
