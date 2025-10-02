package dsa_2024_25.stacks;
/*
 * Implement a data structure that supports 5 operations:
 * 1. push(int i)
 * 2. pop()
 * 3. top()
 * 4. isEmpty()
 * 5. getMin()
 * */
public class MinStackBrute2 {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min;

    public MinStackBrute2() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public void push(int element) {
        mainStack.push(element);
        min = Math.min(min, element);
        if (minStack.isEmpty())
            minStack.push(element);
        if (!minStack.isEmpty() && min != minStack.peek())
            minStack.push(min);
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Underflow");

        int element = mainStack.pop();
        if (element == minStack.peek())
            minStack.pop();
        return element;
    }

    public int top() {
        if (isEmpty())
            throw new RuntimeException("Underflow");

        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            throw new RuntimeException("Underflow");

        return minStack.peek();
    }
}

class MinStackBrute2Main {
    public static void main(String[] args) {
        // push1, pop1
        int[] A = {3, 2, 9, 3, 4, 10, 1};
        MinStackBrute2 stack = new MinStackBrute2();
        for (int i : A) {
            stack.push(i);
        }

        for (int i = 0; i < A.length; i++) {
            System.out.println(stack.getMin());
            stack.pop();
        }
    }
}
