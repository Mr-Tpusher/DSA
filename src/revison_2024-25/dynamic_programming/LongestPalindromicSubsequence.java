package dynamic_programming;

import java.util.Arrays;

/*
* Find longest palindromic subsequence present in a string.
* S : agbdba
* lps: abdba    answer:5
*
* */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "acdajfadfakj";
        System.out.println(bruteForce(s, 0, s.length() - 1));
        System.out.println(solveRecursively(s));
        System.out.println(solveIteratively(s));
    }

    public static int solveIteratively(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        // Base case: all subsequences of length 1 are palindromes of length 1
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        // fill dp matrix for length - 2 to n
        for (int l = 2; l <= length; l++) { // l = subsequence length
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 +  dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }


    public static int solveRecursively(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return solveRecursively(s, 0, s.length() - 1, dp);
    }

    public static int bruteForce(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return 2 + bruteForce(s, i + 1, j - 1);
        } else {
            int a = bruteForce(s, i, j - 1);
            int b = bruteForce(s, i + 1, j);
            return Math.max(a, b);
        }
    }


    public static int solveRecursively(String s, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            dp[i][j] = 1;
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            int ans = 2 + solveRecursively(s, i + 1, j - 1, dp);
            dp[i][j] = ans;
            return ans;
        } else {
            int a = solveRecursively(s, i, j - 1, dp);
            int b = solveRecursively(s, i + 1, j, dp);
            int max = Math.max(a, b);
            dp[i][j] = max;
            return max;
        }
    }
}
