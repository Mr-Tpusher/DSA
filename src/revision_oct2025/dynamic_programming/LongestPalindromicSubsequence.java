package revision_oct2025.dynamic_programming;

import java.util.Arrays;

/*
* Given a string, find the longest palindromic subsequence present in it.
* String s = "agbdba"
* answer = 5 i.e. abdba
* */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "agbdba";
        System.out.println(bruteForce(s));
        System.out.println(topDownDP(s));

    }

    static int bruteForce(String s) {
        return bruteForceHelper(s, 0, s.length() - 1);
    }

    static int topDownDP(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        topDownHelper(s, 0, s.length() - 1, dp);

        return dp[0][s.length() - 1];

    }

    static int topDownHelper(String s, int left, int right, int[][] dp) {
        if (left == right) return dp[left][right] = 1;
        if (left > right) return 0;

        if (dp[left][right] != -1) return dp[left][right];

        if (s.charAt(left) == s.charAt(right)) {
            return dp[left][right] = 2 + topDownHelper(s, left + 1, right - 1, dp);
        } else {
            int leftProgressed = topDownHelper(s, left + 1, right, dp);
            int rightProgressed = topDownHelper(s, left, right - 1, dp);
             return dp[left][right] = Math.max(leftProgressed, rightProgressed);
        }
    }

    static int bruteForceHelper(String s, int left, int right) {

        if (left == right) return 1;
        if (left > right) return 0;

        if (s.charAt(left) == s.charAt(right)) {
            return 2 + bruteForceHelper(s, left + 1, right - 1);
        } else {
            int first = bruteForceHelper(s, left + 1, right);
            int second = bruteForceHelper(s, left, right - 1);
            return Math.max(first, second);
        }
    }
}
