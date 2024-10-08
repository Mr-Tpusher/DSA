package stacks;

import java.util.Arrays;

/*
* Given an array, find the index of nearest smaller element on the left of A[i].
* ind=   0  1  2  3   4  5
* A   = {4, 5, 2, 3, 10, 8}
* ans = {-1,0,-1, 2,  3, 3}
*
*
* */
public class NearestSmallerLeft {
    public static void main(String[] args) {
        int[] A = {4, 5, 2, 3, 10, 8, 8};
        System.out.println(Arrays.toString(bruteForce(A)));
        System.out.println(Arrays.toString(smallerLeft(A)));
    }

    public static int[] bruteForce(int[] A) {
        int length = A.length;
        int[] answer = new int[length];
        Arrays.fill(answer, -1);

        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    answer[i] = j;
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] smallerLeft(int[] A) {
        int length = A.length;
        int[] answers = new int[length];
        Stack<Integer> minPossibilities = new Stack<>();
        for (int i = 0; i < length; i++) {
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
