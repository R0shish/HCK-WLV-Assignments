package Week5_Workshop.Custom_Exception;

import java.util.Scanner;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String err) {
        super("Error: " + err + " Please re-enter the information");
    }
}

class Main {

    static void takeInput(Scanner scanner) {
        int num = scanner.nextInt();
        if (num < 20) {
            throw new InvalidInputException("Number can not be less than 20.");
        }
        if (num > 50) {
            throw new InvalidInputException("Number can not be greater than 50.");

        }
        System.out.println("Correct Input!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 20 to 50: ");
        try {
            takeInput(scanner);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception err) {
            System.out.println("Error: " + err);

        }
        scanner.close();
    }

}
