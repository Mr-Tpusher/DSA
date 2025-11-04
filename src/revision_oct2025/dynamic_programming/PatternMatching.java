package revision_oct2025.dynamic_programming;

import java.util.Arrays;

/*
* Given a String S and a Pattern P, find if S can be represented by P.
* There can be two special characters present in the pattern:
* 1) ? -> can be replaced by any 1 character
* 2) * -> can be replaced by 0 to n characters
*
* S = "aba"     P = "a?a"   answer = true
*
* */
public class PatternMatching {
    public static void main(String[] args) {
        String S = "aba";
        String P = "a?a";
        System.out.println(bruteForce(S, P));
        System.out.println(topDownDP(S, P));
        System.out.println(bottomUpDP(S, P));
    }

    static boolean bruteForce(String s, String p) {
        return bruteForceHelper(s, p, 0, 0) == 1;
    }

    static boolean topDownDP(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return topDownHelper(s, p, 0, 0, dp) == 1;
    }

    static boolean bottomUpDP(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // base case - empty chars match
        dp[0][0] = true;

        // corner case - when there are pattern has * at the beginning -> i.e. * matches with an empty string
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // case 1
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }

    static int topDownHelper(String s, String p, int i, int j, int[][] dp) {
        if (i == s.length() && j == p.length()) return 1;

        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') return dp[i][j] = 0;
            }
            return dp[i][j] = 1;
        }

        if (j == p.length()) return dp[i][j] = 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = topDownHelper(s, p, i + 1, j + 1, dp);
        }

        else if (p.charAt(j) == '*') {
            int empty = topDownHelper(s, p, i, j + 1, dp);
            int sequence = topDownHelper(s, p, i + 1, j, dp);
            return dp[i][j] = empty | sequence;
        }

        else {
            return dp[i][j] = 0;
        }
    }



    static int bruteForceHelper(String s, String p, int i, int j) {
        // base case - both strings are going out of bounds together, indicating they match.
        if (i == s.length() && j == p.length()) {
            return 1;
        }

        // base case
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') return 0;
            }
            return 1;
        }

        if (j == p.length()) return 0;


        // case 1 & 2
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return bruteForceHelper(s, p, i + 1, j + 1);
        }

        // case 3
        if (p.charAt(j) == '*') {
            int empty = bruteForceHelper(s, p, i, j + 1);
            int sequence = bruteForceHelper(s, p, i + 1, j);
            return empty | sequence;
        }

        // case 4 = characters don't match
        else {
            return 0;
        }

    }
}
