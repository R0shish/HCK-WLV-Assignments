package Week7_Assignment.Activity2;

import java.util.Hashtable;
import java.util.Scanner;

public class Banking {
    String name;
    int amount;
    final Scanner scanner = new Scanner(System.in);
    private Hashtable<String, Float> accounts = new Hashtable<String, Float>();

    public Banking() {
        System.out.println("Welcome to Roshish ko Bank!");
    }

    private boolean checkAccount(String name) {
        return accounts.containsKey(name);
    }

    public void createAccount(String name, float amount) {
        if (checkAccount(name)) {
            System.out.println("Account already exists!");
            return;
        }
        accounts.put(name, amount);
    }

    public void depositAmount(String name, float amount) {
        if (!checkAccount(name)) {
            System.out.println("User does not exist!");
            return;
        }
        float currentAmount = accounts.get(name);
        if (amount < 0) {
            System.out.println("Amount must not be negative!");
            return;
        }
        accounts.replace(name, currentAmount + amount);
    }

    public void withdrawAmount(String name, float amount) {
        if (!checkAccount(name)) {
            System.out.println("User does not exist!");
            return;
        }
        float currentAmount = accounts.get(name);
        if (amount < 0) {
            System.out.println("Amount must not be negative!");
            return;
        }
        if (amount > currentAmount) {
            System.out.println("Amount exceeds the current amount!");
            return;
        }
        accounts.replace(name, currentAmount - amount);
    }

    public Float checkBalance(String name) {
        if (!checkAccount(name)) {
            System.out.println("User does not exist!");
            return null;
        }
        return accounts.get(name);
    }

    public void switchCase(int choice) {
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter account name: ");
                name = scanner.nextLine();
                System.out.println("Enter amount to deposit: ");
                try {
                    amount = scanner.nextInt();
                    createAccount(name, amount);
                } catch (Exception e) {
                    System.out.println("Amount must be numeric!");
                    scanner.nextLine();
                }
                break;
            case 2:
                System.out.println("Enter account name: ");
                name = scanner.nextLine();
                System.out.println("Enter amount to deposit: ");
                try {
                    amount = scanner.nextInt();
                    depositAmount(name, amount);
                } catch (Exception e) {
                    System.out.println("Amount must be numeric!");
                    scanner.nextLine();
                }
                break;
            case 3:
                System.out.println("Enter account name: ");
                name = scanner.nextLine();
                System.out.println("Enter amount to withdraw: ");
                try {
                    amount = scanner.nextInt();
                    withdrawAmount(name, amount);
                } catch (Exception e) {
                    System.out.println("Amount must be numeric!");
                    scanner.nextLine();
                    break;
                }
                break;
            case 4:
                System.out.println("Enter account name: ");
                name = scanner.nextLine();
                System.out.println(checkBalance(name));
                break;
            case 5:
                quitProgram();
                break;
            default:
                System.out.println("Invalid Input! Please try again!");
                break;
        }
    }

    private void quitProgram() {
        System.out.println("Thank you for using our bank!");
        System.exit(0);
    }
}
