package queues;

import java.util.Collections;
import java.util.Stack;

/*
* Implement Queue data structure using Stack
* */
public class QueueUsingStacks<T> {
    Stack<T> enqueueStack = new Stack<>();
    Stack<T> dequeueStack = new Stack<>();
    int count = 0;

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(T x) {
        enqueueStack.push(x);
        count++;
    }

    public T dequeue() {
        if (dequeueStack.isEmpty() && enqueueStack.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        count--;
        return dequeueStack.pop();
    }
}

