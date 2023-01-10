package Week7_Assignment.Activity1.LinkedList;

class Node {
    int data;
    Node next;
}

public class LinkedList {
    Node head;

    public void insertLast(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }

    }

    public void insertFirst(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void deleteFirst() throws Exception {
        if (head == null) {
            throw new Exception("Error: LinkedList Empty");
        }
        head = head.next;
    }

    public void insertMiddle(int index, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (index == 0) {
            insertFirst(data);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void deleteLast() throws Exception {
        if (head == null) {
            throw new Exception("Error: LinkedList Empty");
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node n = head;
        while (n.next.next != null) {
            n = n.next;
        }
        n.next = null;
    }

    public void deleteMiddle(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            n1 = null;
        }
    }

    public void display() {
        Node node = head;

        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }
}

class Main {

    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.insertLast(10);
        linkedList.insertLast(20);
        linkedList.insertLast(30);
        linkedList.deleteFirst();
        linkedList.insertFirst(5);
        linkedList.deleteLast();
        linkedList.insertFirst(40);
        linkedList.insertLast(50);
        linkedList.insertMiddle(3, 35);
        linkedList.deleteMiddle(4);
        linkedList.display();
    }

}