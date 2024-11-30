package dynamic_programming;
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
        //System.out.println(solveRecursively(s));
    }

    public static int solveRecursively(String s) {
        int[][] dp = new int[s.length()][s.length()];
        //return solveRecursively(s, 0, s.length() - 1, dp);
        return 0;
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
}
