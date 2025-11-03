package revision_oct2025.dynamic_programming;

import java.util.Arrays;

public class LengthOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A = {0, 8, 4, 12, 10, 6, 14, 1, 9, 5, 13};
        System.out.println(bruteForce(A));
        System.out.println(bruteForce2(A));
        System.out.println(dp1(A));
        System.out.println(bottomUpDp(A));

    }

    static int bruteForce(int[] A) {
        Result result = new Result();
        bruteForceHelper(A, 0, Integer.MIN_VALUE, result);
        return result.globalLIS;
    }

    static int bruteForce2(int[] A) {
        return bruteForceHelper2(A, 0, -1);
    }

    static int dp1(int[] A) {
        /*
        * 1. Element of choice -> include or exclude current
        * 2. dp state[i][prevIndex + 1] -> LIS starting from index with prevIndex as the last included element
        *   note : we are taking prevIndex + 1 , because prevIndex can start at -1.
        * */

        int[][] dp = new int[A.length][A.length + 1];
        for (int [] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dp1Helper(A, dp, 0, -1);

    }


    static int bottomUpDp(int[] A) {
        if (A == null || A.length == 0) return 0;
        // here we can just consider the dp state to be
        // dp[i] -> the longest increasing subsequence ending at i
        // A = {1, 8, 2, 4}

        int[] dp = new int[A.length];
        Arrays.fill(dp, 1); // because every element in itself is an LIS
        int answer = 1;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    static int dp1Helper(int[] A, int[][] dp, int index, int prevIndex) {
        if (index == A.length)
            return 0;

        // since our prev index starts from -1, we are storing at prevIndex + 1.
        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int excludingCurrent = dp1Helper(A, dp, index + 1, prevIndex);

        int includingCurrent = 0;
        if (prevIndex == -1 || A[prevIndex] < A[index]) {
            includingCurrent = 1 + dp1Helper(A, dp, index + 1, index);
        }

        dp[index][prevIndex + 1] = Math.max(excludingCurrent, includingCurrent);
        return dp[index][prevIndex + 1];
    }

    static void bruteForceHelper(int[] A, int index, int prev, Result result) {
        if (index == A.length) {
            result.globalLIS = Math.max(result.globalLIS, result.currLIS);
            return;
        }

        for (int i = index; i < A.length; i++) {
            if (A[i] >  prev) {
                result.currLIS++;
                bruteForceHelper(A, i + 1, A[i], result);
                result.currLIS--;
            }
        }
    }

    static int bruteForceHelper2(int[] A, int index, int prevIndex) {
        if (index == A.length) {
            return 0;
        }

        int includingCurrentElement = 0;

        if (prevIndex == -1 || A[index] > A[prevIndex]) {
            includingCurrentElement = 1 + bruteForceHelper2(A, index + 1, index);
        }

        int excludingCurrentElement = bruteForceHelper2(A, index + 1, prevIndex);

        return Math.max(includingCurrentElement, excludingCurrentElement);
    }






    private static class Result {
        int currLIS;
        int globalLIS;
        Result() {
            currLIS = 0;
            globalLIS = 0;
        }
    }
}
