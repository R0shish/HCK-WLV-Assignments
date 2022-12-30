package Week5_CaseStudy.SystemUser;

import java.util.InputMismatchException;
import java.util.Scanner;

import Week5_CaseStudy.Main;
import Week5_CaseStudy.Models.RentalProperty;

interface LandlordRights {
    void giveNotice();

    void reviewTenant();

    void requestPayment();
}

public class Landlord extends SystemUser implements LandlordRights {
    private String name;
    private RentalProperty property;
    private String contactDetails;
    private String rentalCharge;
    final Scanner scanner;

    public Landlord(String name, RentalProperty property, String contactDetails, String rentalCharge, Scanner scanner) {
        this.name = name;
        this.property = property;
        this.contactDetails = contactDetails;
        this.rentalCharge = rentalCharge;
        this.scanner = scanner;
    }

    public Landlord(Scanner scanner) {
        this.scanner = scanner;
    }

    // Auth
    @Override
    public void login() {
        System.out.println("\nWelcome Landlord!");
        while (true) {
            Main.showDivider();
            System.out.println("""

                    What would you like to do?

                    1) Give Notice
                    2) Review Tenant
                    3) Request Payment
                    4) Add Bills
                    5) Logout
                    """);

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                choice = 6;
            }
            switch (choice) {
                case 1:
                    giveNotice();
                    break;
                case 2:
                    reviewTenant();
                    break;
                case 3:
                    requestPayment();
                    break;
                case 4:
                    addBill(null, choice);
                    break;
                case 5:
                    logout();
                    break;
                default:
                    System.out.println("Wrong Input!");
                    scanner.nextLine();
                    continue;
            }
            if (choice == 5)
                break;
        }
    }

    @Override
    public void logout() {
        System.out.println("Logged out successfully!");
    }

    @Override
    public void giveNotice() {
        System.out.println("Enter the notice: ");
        String notice = scanner.nextLine();
        // Save the notice here 👇
        System.out.println(notice);
        System.out.println("Thank you for your notice!");
    }

    @Override
    public void reviewTenant() {
        System.out.println("Enter review of tenant: ");
        String review = scanner.nextLine();
        // Save the review here 👇
        System.out.println(review);
        System.out.println("Thank you for your review!");
    }

    @Override
    public void requestPayment() {
        System.out.println("Your payment request has been sent successfully.");
    }

    // Getter and Setter

    public static void displayLandlordDetails(Landlord landlord) {
        System.out.println("Name: " + landlord.getName() + "\n");
        RentalProperty.displayRentalPropertyDetails(landlord.getProperty());
        System.out.println("\nContact Details: " + landlord.getContactDetails());
        System.out.println("Rental Charge: " + landlord.getRentalCharge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RentalProperty getProperty() {
        return property;
    }

    public void setProperty(RentalProperty property) {
        this.property = property;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getRentalCharge() {
        return rentalCharge;
    }

    public void setRentalCharge(String rentalCharge) {
        this.rentalCharge = rentalCharge;
    }

    // Add bills
    public void addBill(Tenant tenant, int bill) {
        System.out.println(tenant.getName() + "has been billed " + "Rs " + bill + " sucessfully.");
    }

}
