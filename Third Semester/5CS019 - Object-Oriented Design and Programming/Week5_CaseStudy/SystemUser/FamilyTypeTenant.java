package Week5_CaseStudy.SystemUser;

import java.util.ArrayList;
import java.util.Scanner;

import Week5_CaseStudy.Main;

public class FamilyTypeTenant extends Tenant {

    public FamilyTypeTenant(Scanner scanner) {
        super(scanner);
    }

    @Override
    void viewLandlord() {
        if (Main.showLandlords(role) == 404)
            System.out.println("No landlord found!");
    }

    @Override
    void selectLandlord(ArrayList<Landlord> landlordData) {
        if (Main.showLandlords(role) == 404)
            return;
        System.out.println("Which landlord do you want to select?");
        int choice = scanner.nextInt();
        Main.selectLandlord(role, choice - 1);
    }

    @Override
    public void leaveRoom() {
        System.out.println("Room left successfully.");
    }

    @Override
    public void duePayment() {
        System.out.println("Landlord has been notified of your request!");
    }

    @Override
    public void reviewLandlord() {
        System.out.println("Enter review of landlord: ");
        String review = scanner.nextLine();
        // Save the review here 👇
        System.out.println(review);
        System.out.println("Thank you for your review!");
    }

    @Override
    public void reviewRentalProperty() {
        System.out.println("Enter review of property: ");
        String review = scanner.nextLine();
        // Save the review here 👇
        System.out.println(review);
        System.out.println("Thank you for your review!");
    }

}