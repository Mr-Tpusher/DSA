package dynamic_programming;

import java.util.Arrays;

/*
* Given an array of integers, find the max sum from the array, without selecting adjacent elements.
* e.g.
* A = {2, 3, 5, 7, 0, 10}
* Answer = {2, 5, 10} = 17
*
* */
public class MaxSumNonAdjacent {
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 0, 7, 10};
        System.out.println(maxSumRecursive(A));
    }

    public static int maxSumRecursive(int[] A) {
        int[] maxSums = new int[A.length];
        Arrays.fill(maxSums, Integer.MIN_VALUE);
        return maxSumRecursive(A, maxSums, A.length - 1);
    }

    private static int maxSumRecursive(int[] A, int[] maxSums, int index) {
        if (index < 0) {
            return 0;
        }

        if (maxSums[index] != Integer.MIN_VALUE) {
            return maxSums[index];
        }

        int includeCurrent = A[index] + maxSumRecursive(A, maxSums, index - 2);
        int excludeCurrent = maxSumRecursive(A, maxSums, index - 1);

        int maxSumCurrent = Math.max(excludeCurrent, includeCurrent);
        maxSums[index] = maxSumCurrent;

        return maxSumCurrent;
    }
}
