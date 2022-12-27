package Week5_CaseStudy.SystemUser;

import java.util.Scanner;

abstract class Tenant extends SystemUser {
    // Auth
    @Override
    public void login(Scanner scanner) {
    }

    @Override
    public void logout() {
    }

    abstract void viewLandlord();

    abstract void selectLandlord();
}

interface TenantRights {

    void leaveRoom();

    void requestPayment();

    void reviewLandlord();

    void reviewRentalProperty();

}

class StudentTypeTenant extends Tenant implements TenantRights {

    @Override
    void viewLandlord() {
    }

    @Override
    void selectLandlord() {
    }

    @Override
    public void leaveRoom() {
    }

    @Override
    public void requestPayment() {
    }

    @Override
    public void reviewLandlord() {
    }

    @Override
    public void reviewRentalProperty() {
    }

}

class FamilyTypeTenant extends Tenant implements TenantRights {

    @Override
    void viewLandlord() {
    }

    @Override
    void selectLandlord() {
    }

    @Override
    public void leaveRoom() {
    }

    @Override
    public void requestPayment() {
    }

    @Override
    public void reviewLandlord() {
    }

    @Override
    public void reviewRentalProperty() {
    }

}