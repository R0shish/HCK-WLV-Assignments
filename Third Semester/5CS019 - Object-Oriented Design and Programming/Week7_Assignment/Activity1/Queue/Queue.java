package Week7_Assignment.Activity1.Queue;

import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> queue = new ArrayList<Integer>();

    void enqueue(int e) {
        queue.add(e);
    }

    void dequeue() throws Exception {
        if (queue.isEmpty()) {
            throw new Exception("Error: Queue Underflow");
        }
        queue.remove(0);
    }

    int peek() throws Exception {
        if (queue.isEmpty()) {
            throw new Exception("Error: Empty Queue");
        }
        return queue.get(0);
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        System.out.println(queue.peek());
        queue.enqueue(8);
        queue.dequeue();
        System.out.println(queue.peek());
        queue.enqueue(10);
        System.out.println(queue.peek());
    }
}