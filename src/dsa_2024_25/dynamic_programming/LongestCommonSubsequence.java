package dsa_2024_25.dynamic_programming;

import java.util.Arrays;

/*
* Given 2 strings, find the longest common subsequence.
* A : abbcdgf
* B : bbadcgf
* Answer : bbdgf : 5
*
* */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String A = "abbcdgfsjkdjsjsd";
        String B = "bbadcgf";
        System.out.println(solve(A, B));
    }

    public static int solve(String A, String B) {
        int[][] LCS = new int[A.length()][B.length()];
        solve(A, B, A.length() - 1, B.length() - 1, LCS);
        return LCS[A.length() - 1][B.length() - 1];
    }

    public static int solve(String A, String B, int a, int b, int[][] LCS) {
        if (a < 0 || b < 0) {
            return 0;
        }

        if (LCS[a][b] != 0) {
            return LCS[a][b];
        }

        if (A.charAt(a) == B.charAt(b)) {
            // When the characters match
            int lcs = 1 + solve(A, B, a - 1, b - 1, LCS);
            LCS[a][b] = lcs;
            return lcs;
        } else {
            // When the characters don't match
            int lcs1 = solve(A, B, a, b - 1, LCS);
            int lcs2 = solve(A, B, a - 1, b, LCS);
            int lcs = Math.max(lcs1, lcs2);
            LCS[a][b] = lcs;
            return lcs;
        }
    }
}
