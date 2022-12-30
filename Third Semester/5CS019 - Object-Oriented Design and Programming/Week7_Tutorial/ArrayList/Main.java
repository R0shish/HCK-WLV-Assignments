package Week7_Tutorial.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter data " + (i + 1) + ": ");
            arrayList.add(scanner.nextLine());
        }

        System.out.println("Before removing: ");
        System.out.println(arrayList);

        // // arrayList.removeAll(arrayList);
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            arrayList.remove(i);
        }

        System.out.println("After removing: ");
        System.out.println(arrayList);

        scanner.close();
    }

}
