package revison_oct2025.stack;
/*
Given a stack of integers A, sort it using another stack.
Return the array of integers after sorting the stack using another stack.
*/
import java.util.Arrays;
import java.util.Stack;

public class SortUsing2Stacks {
    public static void main(String[] args) {
        int[] output = solve(new int[]{5, 11, 17, 100});
        System.out.println(Arrays.toString(output));

    }
    static int[] solve(int[] A) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            stack1.push(A[i]);
        }

        while (!stack1.isEmpty()) {
            int temp = stack1.pop();

            while (!stack2.isEmpty() && stack2.peek() > temp) {
                stack1.push(stack2.pop());
            }

            stack2.push(temp);
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        int[] output = new int[A.length];
        int i = 0;
        while (!stack1.isEmpty()) {
            output[i++] = stack1.pop();
        }

        return output;
    }
}
