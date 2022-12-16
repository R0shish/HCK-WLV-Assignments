package Week5_Tutorial.Exception_Handling;

import java.util.InputMismatchException;
import java.util.Scanner;

class Divider {

    void divide(int num) {
        int divider;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a divisor: ");
        try {
            divider = scanner.nextInt();
            System.out.println(num / divider);
        } catch (ArithmeticException e) {
            System.out.println("Can not divide by 0!");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number!");
        }
        scanner.close();
    }

}

class Main {
    public static void main(String[] args) {
        Divider divider = new Divider();
        divider.divide(20);
    }
}
