package Week5_CaseStudy;

import java.util.ArrayList;
import java.util.Scanner;

import Week5_CaseStudy.Auth.Auth;
import Week5_CaseStudy.SystemUser.Admin;
import Week5_CaseStudy.SystemUser.FamilyTypeTenant;
import Week5_CaseStudy.SystemUser.Landlord;
import Week5_CaseStudy.SystemUser.StudentTypeTenant;
import Week5_CaseStudy.SystemUser.Tenant;

public class Main {
    private static ArrayList<Landlord> landlordData = new ArrayList<Landlord>();
    private static ArrayList<Tenant> tenantData = new ArrayList<Tenant>();

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
                Admin admin = new Admin(scanner);
                admin.login();
                break;
            case "Landlord":
                Landlord landlord = new Landlord(scanner);
                landlord.login();
                break;
            case "Tenant":
                System.out.println("Which type of Tenant are you?");
                System.out.println("1) Family Type\n2) Student Type");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    FamilyTypeTenant fTenant = new FamilyTypeTenant(scanner);
                    fTenant.login();
                } else if (choice == 2) {
                    StudentTypeTenant sTenant = new StudentTypeTenant(scanner);
                    sTenant.login();
                }
                break;
            default:
                break;
        }

        scanner.close();
    }

    public static ArrayList<Landlord> getLandlordData(String role) {
        if (role.equals("Admin") || role.equals("Tenant")) {
            return landlordData;
        }
        throw new AccessForbiddenException("You do not have access to view landlord data.");
    }

    public static ArrayList<Tenant> getTenantData(String role) {
        if (role.equals("Admin") || role.equals("Landlord")) {
            return tenantData;
        }
        throw new AccessForbiddenException("You do not have access to view tenant data.");
    }

    public static void showDivider() {
        System.out.println("--------------------");
    }

    // Landlord
    public static void addLandlord(Landlord landlord) {
        Main.landlordData.add(landlord);
    }

    public static int showLandlords(String role) {
        ArrayList<Landlord> landlords = Main.getLandlordData(role);
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

    public static int selectLandlord(String role, int index) {
        ArrayList<Landlord> landlords = Main.getLandlordData(role);
        Main.showDivider();
        System.out.println(landlords.get(index) + " selected.");
        return 0;
    }

    // Tenant
    public static void addTenant(Tenant tenant) {
        Main.tenantData.add(tenant);
    }

    public static int showTenants(String role) {
        ArrayList<Tenant> tenants = Main.getTenantData(role);
        Main.showDivider();
        if (tenants.size() == 0) {
            System.out.println("No Tenants Found!");
            return 404;
        }
        System.out.println("Tenant Details:");
        for (int i = 0; i < tenants.size(); i++) {
            System.out.println((i + 1) + ") " + tenants.get(i).getName());
        }
        return 0;
    }

    public static int selectTenant(String role, int index) {
        ArrayList<Tenant> tenants = Main.getTenantData(role);
        Main.showDivider();
        System.out.println(tenants.get(index) + " selected.");
        return 0;
    }

}

class AccessForbiddenException extends RuntimeException {
    public AccessForbiddenException(String err) {
        super(err + " Please contact an admin!");
    }
}