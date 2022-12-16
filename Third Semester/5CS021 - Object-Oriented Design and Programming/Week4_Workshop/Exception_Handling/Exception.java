package Week4_Workshop.Exception_Handling;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputHandler {
    private String name;
    private int age;

    public InputHandler(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static InputHandler takeInput() {
        String name;
        int age = -1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Enter your age: ");

        try {
            age = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        scanner.close();
        return new InputHandler(name, age);
    }

    public void displayResult() {
        System.out.println(name);
        if (age == -1) {
            System.out.println("You entered invalid age!");
        } else {
            System.out.println(age);
        }
    }
}

class Main {
    public static void main(String[] args) {

        InputHandler input = InputHandler.takeInput();
        input.displayResult();

    }
}