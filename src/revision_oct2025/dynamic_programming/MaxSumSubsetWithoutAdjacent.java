package revision_oct2025.dynamic_programming;

import java.util.Arrays;

public class MaxSumSubsetWithoutAdjacent {
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 0, 7, 10};
        bruteForce(A);
        maxSumDpRecursive(A);
    }

    static void bruteForce(int[] A) {
        System.out.println(bruteForceHelper(A, A.length - 1));
    }

    static void maxSumDpRecursive(int[] A) {
        int[] dp = new int[A.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = A[0];

        int ans = maxSumDpRecursiveHelper(A, A.length - 1, dp);
        System.out.println(ans);

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
