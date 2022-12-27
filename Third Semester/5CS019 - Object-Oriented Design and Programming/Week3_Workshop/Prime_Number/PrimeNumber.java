package Week3_Workshop.Prime_Number;

import java.util.Scanner;

public class PrimeNumber {
    private int number;
    private int count;

    public PrimeNumber(int number) {
        this.number = number;
    }

    public boolean checkPrimeNumber() {
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count < 2;
    }

    public int getNumber() {
        return this.number;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any number:");
        PrimeNumber input = new PrimeNumber(scanner.nextInt());
        System.out
                .println("The given number " + input.getNumber() + " is"
                        + (input.checkPrimeNumber() ? " prime." : " not prime."));
        scanner.close();
    }
}
