package revision_oct2025.dynamic_programming;
/*
* Given an array of integers, find the max sum from the array, without selecting adjacent elements.
*
* */
import dsa_2024_25.heaps.MaxHeap;

import java.util.Arrays;

public class MaxSumSubsetWithoutAdjacent {
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 0, 7, 10};
        bruteForce(A);
        maxSumDpRecursive(A);
        System.out.println(maxSumDpIterative(A));
        System.out.println(maxSumDpIterative2(A));

    }

    static void bruteForce(int[] A) {
        System.out.println(bruteForceHelper(A, A.length - 1));
    }

    static void maxSumDpRecursive(int[] A) {
        int[] dp = new int[A.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = A[0];

        maxSumDpRecursiveHelper(A, A.length - 1, dp);
        System.out.println(dp[A.length - 1]);

    }

    static int maxSumDpIterative(int[] A) {
        int[] dp = new int[A.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);

        for (int i = 2; i < A.length; i++) {
            dp[i] = Math.max(A[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[A.length - 1];
    }


    static int maxSumDpIterative2(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];

        int prev2 = A[0];
        int prev1 = Math.max(A[0], A[1]);

        for (int i = 2; i < A.length; i++) {
            int curr = Math.max(A[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


    static int maxSumDpRecursiveHelper(int[] A, int index, int[] dp) {
        if (index < 0) return 0;

        if (dp[index] != Integer.MIN_VALUE)
            return dp[index];

        int withCurr = A[index] + maxSumDpRecursiveHelper(A, index - 2, dp);
        int withOutCurrent = maxSumDpRecursiveHelper(A, index - 1, dp);
        dp[index] = Math.max(withCurr, withOutCurrent);
        return dp[index];
    }

    static int bruteForceHelper(int[] A, int index) {
        if (index < 0) return 0;

        int sumWithCurrent = A[index] + bruteForceHelper(A, index - 2);
        int sumWithoutCurrent = bruteForceHelper(A, index - 1);
        return Math.max(sumWithCurrent, sumWithoutCurrent);
    }

}
