package dsa_2024_25.stacks;

import java.util.Arrays;

/*
* Given an array, find the index of nearest greater and smaller element on the right of A[i].
* ind=   0  1  2  3   4  5
* A   = {4, 5, 2, 3, 10, 8}
* ans = {-1,0,-1, 2,  3, 3}
*
*
* */
public class NearestRight {
    public static void main(String[] args) {
        int[] A = {4, 5, 2, 3, 10, 8, 8};
        System.out.println(Arrays.toString(bruteForceGreaterRight(A)));
        System.out.println(Arrays.toString(bruteForceSmallerRight(A)));
        System.out.println(Arrays.toString(findNearestGreaterToRight(A)));
        System.out.println(Arrays.toString(findNearestSmallerToRight(A)));
    }

    public static int[] bruteForceGreaterRight(int[] A) {
        int length = A.length;
        int[] answer = new int[length];
        Arrays.fill(answer, -1);

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (A[j] > A[i]) {
                    answer[i] = j;
                    break;
                }
            }
        }

        return answer;
    }
    public static int[] bruteForceSmallerRight(int[] A) {
        int length = A.length;
        int[] answer = new int[length];
        Arrays.fill(answer, -1);

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (A[j] < A[i]) {
                    answer[i] = j;
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] findNearestGreaterToRight(int[] A) {
        int length = A.length;
        int[] answers = new int[length];
        Stack<Integer> minPossibilities = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            int currElement = A[i];

            while (!minPossibilities.isEmpty() && A[minPossibilities.peek()] <= currElement) {
                minPossibilities.pop();
            }
            if (minPossibilities.isEmpty()) {
                answers[i] = -1;
            } else {
                answers[i] = minPossibilities.peek();
            }
            minPossibilities.push(i);
        }

        return answers;
    }
    public static int[] findNearestSmallerToRight(int[] A) {
        int length = A.length;
        int[] answers = new int[length];
        Stack<Integer> minPossibilities = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            int currElement = A[i];

            while (!minPossibilities.isEmpty() && A[minPossibilities.peek()] >= currElement) {
                minPossibilities.pop();
            }
            if (minPossibilities.isEmpty()) {
                answers[i] = -1;
            } else {
                answers[i] = minPossibilities.peek();
            }
            minPossibilities.push(i);
        }

        return answers;
    }


}
