package Week6_Workshop.Reverse_Number;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 1
        int number, result = 0, digit; // 3
        while (true) { // m
            System.out.println("Enter a number longer than 4 digits: "); // m - 1
            number = scanner.nextInt(); // m - 1
            if (number >= 1000) {
                break;
            }
            System.out.println("Invalid Input. Please Try Again!");
        }
        while (number > 0) {
            digit = number % 10;
            result = result * 10 + digit;
            number /= 10;
        }
        System.out.println("The reverse is " + result);
        scanner.close();
    }
}