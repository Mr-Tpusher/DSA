package queues;

public class LinkedListQueue<T> {
    Node head;
    Node tail;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (tail == null) {
            tail = head = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void dequeue() {
        if (isEmpty())
            throw new RuntimeException("Underflow");

        head = head.getNext();

        if (head == null)
            tail = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Queue: ");

        Node curr = head;
        while (curr != null) {
            sb.append(curr.getData()).append("->");
            curr = curr.getNext();
        }
        return sb.toString();
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

class LinkedListQueueMain {
    public static void main(String[] args) {
        LinkedListQueue<Integer> llq = new LinkedListQueue<>();
        llq.enqueue(5);
        llq.enqueue(10);
        llq.enqueue(15);
        System.out.println(llq);
        llq.dequeue();
        System.out.println(llq);
        llq.enqueue(30);
        llq.dequeue();
        llq.dequeue();
        System.out.println(llq);
    }
}
