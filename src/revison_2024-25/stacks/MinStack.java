package stacks;
import java.util.ArrayList;

/*
* Implement a data structure that supports 5 operations:
* 1. push(int i)
* 2. pop()
* 3. top()
* 4. isEmpty()
* 5. getMin()
* */
public class MinStack {
    ArrayList<Integer> items = new ArrayList<>();
    int currMin = Integer.MAX_VALUE;

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void push(int element) {
        if (isEmpty()) {
            currMin = element;
        }
        if (element < currMin) {
            int prevMin = currMin;
            currMin = element;
            element = currMin - prevMin;
        }
        items.add(element);
    }

    public int pop() {
        if (isEmpty())
            return -1;

        int popped = items.remove(items.size() - 1);
        if (popped < currMin) {
            int actualElement = currMin;
            currMin = currMin - popped;
            popped = actualElement;
        }
        return popped;
    }

    public int top() {
        if (isEmpty())
            return -1;

        int element = items.get(items.size() - 1);
        if (element < currMin) {
            int actualElement = currMin;
            currMin = currMin - element;
            element = actualElement;
        }
        return element;
    }

    public int getMin() {
        if (isEmpty())
            return -1;
        return currMin;
    }

    @Override
    public String toString() {
        System.out.println(items);
        return items.toString();
    }
}

class MinStackMain {
    public static void main(String[] args) {
        // push1, pop1
        int[] A = {3, 2, 9, 3, 4, 10, 1};
        MinStack stack = new MinStack();
        for (int i : A) {
            stack.push(i);
        }
        stack.toString();

        for (int i : new int[A.length]) {
            System.out.println("Current Min:" + stack.getMin());
            System.out.println("popped:" + stack.pop());
        }

    }
}
