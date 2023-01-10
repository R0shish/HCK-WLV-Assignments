package Week7_Assignment.Activity2;

class Main {
    public static void main(String[] args) {
        Banking banking = new Banking();
        while (true) {
            int choice;
            System.out.println("""
                    Please choose an instruction:
                    1) Create an account
                    2) Deposit amount
                    3) Withdraw amount
                    4) Check balance
                    5) Quit
                    """);
            try {
                choice = banking.scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong Input! Please Try Again!");
                continue;
            }
            banking.switchCase(choice);
        }
    }
}