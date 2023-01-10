package Week7_Assignment.Activity1.Stack;

import java.util.ArrayList;

public class Stack {
    ArrayList<Integer> stack = new ArrayList<Integer>();

    void push(int e) {
        stack.add(e);
    }

    void pop() {
        if (stack.isEmpty()) {
            System.out.println("Error: Empty Stack");
            return;
        }
        stack.remove(stack.size() - 1);
    }

    Integer peek() {
        if (stack.isEmpty()) {
            System.out.println("Error: Empty Stack");
            return null;
        }
        return stack.get(stack.size() - 1);
    }
}

class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(12);
        stack.pop();
        stack.push(21);
        stack.push(32);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.push(15);
        stack.push(17);
        stack.pop();
        System.out.println(stack.peek());
    }
}