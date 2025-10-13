package revison_oct2025.stack;

public class MyStack {
    private final int[] items;
    private final int size;
    private int head = -1;

    public MyStack() {
        this(10);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack : [");
        for (int i = 0; i <= head; i++) {
            sb.append(items[i]);
            if (i < head)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
