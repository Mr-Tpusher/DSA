package revision_oct2025.stack;

import java.util.Stack;

public class MinStackMain {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println("min=" + minStack.getMinVersion1());
        minStack.push(2);
        System.out.println("min=" + minStack.getMinVersion1());
        minStack.push(9);
        System.out.println("min=" + minStack.getMinVersion1());
        minStack.push(3);
        minStack.push(4);
        minStack.push(10);
        minStack.push(1);
        System.out.println("min=" + minStack.getMinVersion1());

    }


    static class MinStack {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        boolean isEmpty() {
            return stack1.isEmpty();
        }

        int push(int item) {
            stack1.push(item);
            return item;
        }

        int peek() {
            return stack1.peek();
        }

        int pop() {
            return stack1.pop();
        }

        int getMinVersion1() {
            if (isEmpty())
                return -1;

            int min = Integer.MAX_VALUE;

            while (!stack1.isEmpty()) {
                int curr = stack1.pop();
                min = Math.min(min, curr);
                stack2.push(curr);
            }

            while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            return min;
        }

    }
}
