package dsa_2024_25.stacks;

import java.util.ArrayList;

public class Stack<T> {
    private final ArrayList<T> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean push(T element) {
        return elements.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow!");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow!");
        }
        return elements.get(elements.size() - 1);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
