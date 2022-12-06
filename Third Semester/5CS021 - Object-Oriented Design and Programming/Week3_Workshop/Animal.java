package Week3_Workshop;

public class Animal {
    private String name;
    private String age;
    private String weight;

    public Animal(String name, String age, String weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    void displayInfo() {
        System.out.println(name + " is " + age + " years old. It weighs " + weight + " kg.");
    }

    void eat() {
        System.out.println(name + " is eating...");
    }

    void sleep() {
        System.out.println(name + " is sleeping...");
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

}

class Dog extends Animal {
    public Dog(String name, String age, String weight) {
        super(name, age, weight);
    }

    void bark() {
        System.out.println(this.getName() + " is barking...");
    }

    void displayInfo() {
        System.out.println(this.getName() + " the dog is " + this.getAge() + " years old.");
    }
}

class Fish extends Animal {
    public Fish(String name, String age, String weight) {
        super(name, age, weight);
    }

    void blopblop() {
        System.out.println(this.getName() + " is blopblopping...");
    }

    void displayInfo() {
        System.out.println(this.getName() + " the fish is " + this.getAge() + " years old.");
    }
}

class Main {
    public static void main(String[] args) {
        Dog shiba = new Dog("Shiba", "5", "20");
        shiba.displayInfo();
        shiba.eat();
        shiba.bark();

        Fish rio = new Fish("Rio", "1", "2");
        rio.displayInfo();
        rio.sleep();
        rio.blopblop();
    }
}
