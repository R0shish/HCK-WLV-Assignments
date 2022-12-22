package Week5_CaseStudy.Models;

public class RentalProperty {
    final private int numberOfRooms;
    final private int levelOfRooms;
    final private String location;
    final private int lengthOfStay;

    public RentalProperty(int numberOfRooms, int levelOfRooms, String location, int lengthOfStay) {
        this.numberOfRooms = numberOfRooms;
        this.levelOfRooms = levelOfRooms;
        this.location = location;
        this.lengthOfStay = lengthOfStay;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getLevelOfRooms() {
        return levelOfRooms;
    }

    public String getLocation() {
        return location;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

}
