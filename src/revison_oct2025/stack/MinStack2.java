package revison_oct2025.stack;

import java.util.Stack;

public class MinStack2 {
    Stack<Integer> stack1 = new Stack<>();
    int currMin = Integer.MAX_VALUE;

    public void push(int x) {

        if (stack1.isEmpty()) {
            currMin = x;
            stack1.push(x);
        } else {
            if (x < currMin) {
                int toPush = x - currMin;
                currMin = x;
                stack1.push(toPush);
            } else {
                stack1.push(x);
            }

        }

    }

    public void pop() {
        if (stack1.isEmpty())
            return;

        int popped = stack1.pop();
        if (popped < currMin) {
            int prevMin = currMin - popped;
            currMin = prevMin;
        }
    }

    public int top() {
        if (stack1.isEmpty())
            return -1;
        int top = stack1.peek();
        if (top < currMin) {
            return currMin;
        } else {
            return top;
        }
    }

    public int getMin() {
        if (stack1.isEmpty())
            return -1;

        return currMin;
    }
}

