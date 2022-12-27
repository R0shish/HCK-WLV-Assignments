package Week5_CaseStudy.SystemUser;

import java.util.Scanner;

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

    public Landlord(String name, RentalProperty property, String contactDetails, String rentalCharge) {
        this.name = name;
        this.property = property;
        this.contactDetails = contactDetails;
        this.rentalCharge = rentalCharge;
    }

    public Landlord() {
    }

    // Auth
    @Override
    public void login(Scanner scanner) {
        System.out.println("Welcome Landlord!");
    }

    @Override
    public void logout() {
    }

    @Override
    public void giveNotice() {
    }

    @Override
    public void reviewTenant() {
    }

    @Override
    public void requestPayment() {
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

    }

}
