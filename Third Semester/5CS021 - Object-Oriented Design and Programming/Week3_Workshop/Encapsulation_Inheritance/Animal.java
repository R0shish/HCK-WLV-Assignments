package Week3_Workshop.Encapsulation_Inheritance;

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

class Bear extends Animal {
    public Bear(String name, String age, String weight) {
        super(name, age, weight);
    }

    void hibernate() {
        System.out.println(this.getName() + " is hibernating...");
    }

    void displayInfo() {
        System.out.println(this.getName() + " the bear is " + this.getAge() + " years old.");
    }
}

class Penguin extends Animal {
    public Penguin(String name, String age, String weight) {
        super(name, age, weight);
    }

    void flipflop() {
        System.out.println(this.getName() + " is flipflopping...");
    }

    void displayInfo() {
        System.out.println(this.getName() + " the penguin is " + this.getAge() + " years old.");
    }
}

class Main {
    public static void main(String[] args) {
        Bear grizzly = new Bear("Grizzly", "15", "120");
        grizzly.displayInfo();
        grizzly.eat();
        grizzly.hibernate();

        Penguin kowalski = new Penguin("Kowalski", "3", "20");
        kowalski.displayInfo();
        kowalski.sleep();
        kowalski.flipflop();
    }
}
