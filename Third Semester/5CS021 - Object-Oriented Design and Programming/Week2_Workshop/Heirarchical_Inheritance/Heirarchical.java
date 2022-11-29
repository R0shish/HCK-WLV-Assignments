package Week2_Workshop.Heirarchical_Inheritance;

public class Heirarchical {
    int x;
    int y;

    static int sum(int x, int y) {
        return x + y;
    }
}

class Left extends Heirarchical {
    int multiply(int x, int y) {
        return x * y;
    }
}

class Right extends Heirarchical {
    int divide(int x, int y) {
        return x / y;
    }
}

class Middle extends Heirarchical {
    int modulus(int x, int y) {
        return x % y;
    }

    public static void main(String[] args) {
        Left left = new Left();
        Right right = new Right();
        Middle middle = new Middle();
        
        System.out.println("The sum is " + sum(10, 20));
        System.out.println("The multiplication is " + left.multiply(10, 20));
        System.out.println("The division is " + right.divide(10, 20));
        System.out.println("The modulus is " + middle.modulus(10, 20));
    }
}