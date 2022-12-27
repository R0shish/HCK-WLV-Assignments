package Week6_Workshop.Sum_of_Numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = -1;
        int sum = 0;
        while (num != 0) {
            System.out.println("Enter a number: ");
            num = scanner.nextInt();
            sum += num;
        }
        System.out.println("The sum is " + sum);
        scanner.close();
    }
}

// Time Complexity
// 1+1+1+n+(3n-3)+1+1
// 2 + 4n -> Total
// n -> O(n)