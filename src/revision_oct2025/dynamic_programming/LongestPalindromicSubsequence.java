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
        System.out.println(bottomUpDP(s));

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

    static int bottomUpDP(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        // pre-populate the base cases
        for (int i = 1; i <= n; i++)
            dp[i][i] = 1;

        for (int i = n; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) { // j is i + 1 handles base case of i > j
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[1][n];
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
