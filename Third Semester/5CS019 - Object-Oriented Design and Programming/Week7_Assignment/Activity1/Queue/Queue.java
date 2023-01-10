package Week7_Assignment.Activity1.Queue;

import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> queue = new ArrayList<Integer>();

    void enqueue(int e) {
        queue.add(e);
    }

    void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Error: Empty Queue");
            return;
        }
        queue.remove(0);
    }

    Integer peek() {
        if (queue.isEmpty()) {
            System.out.println("Error: Empty Queue");
            return null;
        }
        return queue.get(0);
    }
}

class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(60);
        queue.dequeue();
        queue.enqueue(24);
        System.out.println(queue.peek());
        queue.dequeue();
        queue.enqueue(67);
        queue.enqueue(55);
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
    }
}