package Week1_Workshop.Car;

class Car {
    String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public static void main(String[] args) {
        Car ford = new Car("Ford");
        String brand = ford.getBrand();
        System.out.println(brand);
    }
}
