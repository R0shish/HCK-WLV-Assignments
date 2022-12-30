package Week7_Tutorial.HashMap;

import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        System.out.println("\nThe keys and values are: ");
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        hashMap.put("Four", 4);

        System.out.println("\nThe keys and values are: ");
        hashMap.forEach((k, v) -> System.out.println(k + " has value " + v));

        System.out.println("\nThe keys are: ");
        for (String key : hashMap.keySet()) {
            System.out.println(key);
        }

        System.out.println("\nThe values are: ");
        for (Integer values : hashMap.values()) {
            System.out.println(values);
        }

        System.out.println("\nThe keys and values are: ");
        for (Entry<String, Integer> entrySet : hashMap.entrySet()) {
            System.out.println(entrySet.getKey() + " has value " + entrySet.getValue());
        }
    }
}
