package Week2_Workshop.Inheritance;

public class Parent {
    int x, y, sum;

    void sum() {
        System.out.println("This is the parent class!");
    }
}

class Child extends Parent {
    void display() {
        x = 100;
        y = 200;
        sum = x + y;

        System.out.println("This is the child class method!");
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.sum();
        child.display();
    }
}
