package Week2_Workshop.Aggregation;

public class Employee {
    int id;
    String name;
    Address address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println(name + " has id no. " + id + " and lives in " + address.returnAddress());
    }

    public static void main(String[] args) {
        // Employee 1
        Address address1 = new Address("Rudramati Marg", "Kathmandu", "Nepal", "44600");
        Employee employee1 = new Employee(
                1, "Roshish", address1);

        employee1.display();

        // Employee 2
        Address address2 = new Address("Chabahil", "Kathmandu", "Nepal", "44600");
        Employee employee2 = new Employee(
                2, "Sujal", address2);

        employee2.display();

    }

}

class Address {
    String streetName;
    String city;
    String country;
    String zipCode;

    public Address(String streetName, String city, String country, String zipCode) {
        this.streetName = streetName;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    String returnAddress() {
        return streetName + ", " + city + ", " + country + "(" + zipCode + ")";
    }

}