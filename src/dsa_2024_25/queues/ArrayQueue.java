package dsa_2024_25.queues;

public class ArrayQueue {
    int head = 0;
    int tail = -1;
    int[] q;
    int SIZE;
    int count = 0;

    public ArrayQueue() {
        SIZE = 10;
        q = new int[SIZE];
    }
    public ArrayQueue(int size) {
        this.SIZE = size;
        q = new int[SIZE];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return (count == SIZE);
    }

    public void enqueue(int x) {
        if (isFull()) {
            throw new RuntimeException("OVERFLOW!");
        }
        tail = (tail + 1) % SIZE;
        q[tail] = x;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow!");
        }
        int element = q[head];
        head = (head + 1) % SIZE;
        count--;
        return element;
    }

    public int size() {
        return count;
    }
}
