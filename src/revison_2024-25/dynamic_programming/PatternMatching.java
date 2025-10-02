package dynamic_programming;
/*
* Given a string S, and a pattern P, find if the string can be represented by the
* given pattern.
* There can be 2 special symbols in the pattern:
*   1. ? ---> can be replaced by 1 character
*   2. * ---> can be replaced by a sequence of characters(0 to n)
*
* S : alanturing
* P : al?n*i*g
* answer: true
*
*
* */
public class PatternMatching {
    public static void main(String[] args) {
        //String s = "alanturing";
        //String p = "al?n*i*g";

        String s = "aaa";
        String p = "*";
        //System.out.println(bruteForce(s, p, 0, 0));
        System.out.println(dpSolve(s, p));

    }

    public static int dpSolve(String s, String p) {
        // dp approach
        int[][] dp = new  int[s.length() + 1][p.length() + 1];

        // We consider empty string at the 0th indices of dp array.
        // Empty string matches an empty pattern
        dp[0][0] = 1;

        // Handle patterns with leading '*' that can match empty string.
        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];    // can match empty string
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                /*
                    For '*' we had two possibilities: empty and sequence of chars
                   1. if we had reached current i,j state after considering empty then our
                      prev state would've been => dp[i][j-1]
                   2. if we had considered sequence of chars,
                      prev state would've been => dp[i-1][j]

                 */
                    dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[s.length()][p.length()];
    }


    public static int dpSolve2(String s, String p) {
        // dp array will store results for the current row and the previous row
        int[] dp = new  int[p.length() + 1];

        dp[0]= 1;

        // Handle patterns with leading '*' that can match empty string.
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 1];    // can match empty string
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            int[] newDp = new int[p.length() + 1];
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    newDp[j] = dp[j - 1];    // direct match
                }
                else if (p.charAt(j - 1) == '?') {
                    newDp[j] = dp[j - 1];    // direct match
                }
                else if (p.charAt(j - 1) == '*') {
                /*
                    For '*' we had two possibilities: empty and sequence of chars
                   1. if we had reached current i,j state after considering empty then our
                      prev state would've been => dp[i][j-1]
                   2. if we had considered sequence of chars,
                      prev state would've been => dp[i-1][j]

                 */
                    newDp[j] = newDp[j - 1] | dp[j];
                }
                else {
                    newDp[j] = 0;
                }
            }
            dp = newDp;
        }

        return dp[p.length()];
    }

    public static boolean bruteForce(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (i == s.length() || j == p.length()) {
            // out of bounds
            return false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return bruteForce(s, p, i + 1, j + 1);
        }

        if (p.charAt(j) == '*') {
            boolean whenEmptyChar = bruteForce(s, p, i, j + 1);
            boolean whenSeqOfChars = bruteForce(s, p, i + 1, j);
            return whenEmptyChar || whenSeqOfChars;
        }

        else {
            return false;
        }

    }
}
