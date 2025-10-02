package dsa_2024_25.queues;

public class SimpleArrayQueue {
    int front = 0;
    int rear = -1;
    final int SIZE;
    int[] q;

    public SimpleArrayQueue() {
        this.SIZE = 10;
        q = new int[SIZE];
    }

    public SimpleArrayQueue(int size) {
        this.SIZE = size;
        this.q = new int[SIZE];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public void enqueue(int element) {
        if (rear >= SIZE - 1) {
            throw new RuntimeException("Overflow: queue is full.");
        }
        q[++rear] = element;
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: queue is empty.");
        }
        front++;
    }

    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }
}

class ArrayQueueMain {
    public static void main(String[] args) {
        SimpleArrayQueue queue = new SimpleArrayQueue();
        queue.printQueue();
        queue.enqueue(1);
        queue.printQueue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }
}
