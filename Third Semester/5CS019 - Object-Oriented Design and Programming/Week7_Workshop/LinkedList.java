package Week7_Workshop;

class Node {
    String data;
    Node next;
}

class LinkedList {
    Node head;

    void insert(String s) {
        Node node = new Node();
        node.data = s;
        node.next = null;
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    void insertAt(int index, String s) {
        Node node = new Node();
        node.data = s;
        node.next = null;
        if (index == 0) {
            insertAtStart(s);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    void insertAtStart(String s) {
        Node node = new Node();
        node.data = s;
        node.next = head;
        head = node;
    }

    void show() {
        Node n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    void deleteAt(int index) {
        {
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
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAt(0, "First");
        linkedList.insertAt(1, "Second");
        linkedList.insertAtStart("AtStart");
        linkedList.insert("Third");
        System.out.println("Before Deleting: ");
        linkedList.show();

        linkedList.deleteAt(0);
        linkedList.deleteAt(2);
        System.out.println("After Deleting: ");
        linkedList.show();
    }
}