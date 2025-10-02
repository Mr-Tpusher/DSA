package dsa_2024_25.stacks;

public class MinStackBrute1 {
    /*
     * Implement a data structure that supports 5 operations:
     * 1. push(int i)
     * 2. pop()
     * 3. top()
     * 4. isEmpty()
     * 5. getMin()
     * */
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min;

    public MinStackBrute1() {
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
        minStack.push(min);
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Underflow");

        minStack.pop();
        return mainStack.pop();
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

class MinStackBrute1Main {
    public static void main(String[] args) {
        // push1, pop1
        int[] A = {3, 2, 9, 3, 4, 10, 1};
        MinStackBrute1 stack = new MinStackBrute1();
        for (int i : A) {
            stack.push(i);
        }

        for (int i : new int[A.length]) {
            System.out.println(stack.getMin());
            stack.pop();
        }
    }
}


