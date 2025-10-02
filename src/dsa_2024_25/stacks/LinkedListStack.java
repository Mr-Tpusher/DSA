package dsa_2024_25.stacks;
import java.util.LinkedList;

//@param <T> the type of elements in the stack
public class LinkedListStack<T> {

    LinkedList<T> elements;

    public LinkedListStack() {
        elements = new LinkedList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(T element) {
        elements.addFirst(element);
    }

    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Underflow!");
        return elements.removeFirst();
    }

    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Underflow!");
        return elements.getFirst();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
