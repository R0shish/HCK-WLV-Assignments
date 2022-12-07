package Week3_Workshop.Palindrome;

import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(int number) {
        int temp = number;
        int digit, result = 0;
        while (temp > 0) {
            digit = temp % 10;
            result = result * 10 + digit;
            temp /= 10;
        }
        return (result == number);
    }

    public static boolean isPalindrome(String string) {
        String result;
        int mid = string.length() / 2;
        if (string.length() % 2 == 0) {
            result = string.substring(0, mid);
        } else {
            result = string.substring(0, mid + 1);
        }
        for (int i = mid - 1; i >= 0; i--) {
            result += result.charAt(i);
        }
        return result.equals(string);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or a number:");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println(
                    "The given number is " + (Palindrome.isPalindrome(number) ? "a palindrome."
                            : "not a palindrome."));
        } else if (scanner.hasNext()) {
            String string = scanner.nextLine();
            System.out.println(
                    "The given word is " + (Palindrome.isPalindrome(string) ? "a palindrome." : "not a palindrome."));
        }
        scanner.close();
    }
}