package dsa_2024_25.stacks;

import java.util.Arrays;

/*
 * Given a stream of elements, sort those items using stacks.
 * A stream means online, once the element is used, it won't be available again.
 * */
public class SortUsingStacks {
    public static void main(String[] args) {
        int[] A = {3, 1, 9, 2, 4, 8};
        //int[] A = {};
        System.out.println(Arrays.toString(sort(A)));

    }

    // worst case TC=O(N^2)
    public static int[] sort(int[] A) {
        Stack<Integer> sortedStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        for (int i : A) {

            // Add elements of sorted stack into temp stack until they are greater than current element
            while (!sortedStack.isEmpty() && sortedStack.peek() < i) {
                tempStack.push(sortedStack.pop());
            }

            // then add current element in the stack
            sortedStack.push(i);

            // Add back the elements from temp stack
            while (!tempStack.isEmpty()) {
                sortedStack.push(tempStack.pop());
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = sortedStack.pop();
        }
        return A;
    }
}

