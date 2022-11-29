package Week2_Workshop.Multi_Level_Inheritance;

public class MultiLevel {
    int x = 20;
    int y = 10;
    int product;

    void sum() {
        System.out.println("The sum is " + (x + y));
    }
}

class First extends MultiLevel {
    void multiply() {
        product = x * y;
        System.out.println("The multiplication is " + product);
    }
}

class Second extends First {
    void divide() {
        System.out.println("The multiplication is " + (x / y));
    }
}

class Third extends Second {
    void modulus() {
        System.out.println("The modulus is " + (x % y));
    }

    public static void main(String[] args) {
        Third third = new Third();
        third.sum();
        third.multiply();
        third.divide();
        third.modulus();
    }
}