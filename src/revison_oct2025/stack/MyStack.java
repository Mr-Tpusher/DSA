package revison_oct2025.stack;

public class MyStack {
    private int[] items;
    private int size;
    private int head = -1;

    public MyStack() {
        new MyStack(10);
    }
    public MyStack(int size) {
        this.size = size;
        this.items = new int[size];
    }

    boolean isEmpty() {
        return head == -1;
    }

    boolean push(int x) {
        if (head == size - 1) {
            return false;
        }
        items[++head] = x;
        return true;
    }

    int pop() {
        if (isEmpty())
            throw new RuntimeException("Underflow");
        return items[head--];
    }

    int top() {
        if (isEmpty())
            throw new RuntimeException("Underflow");
        return items[head];
    }
}
