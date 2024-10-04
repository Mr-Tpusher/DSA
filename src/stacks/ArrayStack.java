package stacks;

public class ArrayStack {
    private int size = 10;
    private final int[] items;
    int head = -1;

    ArrayStack() {
        items = new int[size];
    }

    ArrayStack(int size) {
        this.size = size;
        items = new int[size];
    }
    
    public boolean isEmpty() {
        return head == -1;
    }
    
    public int push(int element) {
        if (head == size - 1) {
            throw new RuntimeException("Overflow!");
        }
        items[++head] = element;
        return element;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow!");
        }
        return items[head--];
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow!");
        }
        return items[head];
    }
}
