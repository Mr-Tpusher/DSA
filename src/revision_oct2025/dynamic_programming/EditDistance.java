package revision_oct2025.dynamic_programming;

import dsa_2024_25.heaps.MaxHeap;

import java.util.Arrays;

/*
* Given 2 strings, convert String A to String B, only 3 operations are allowed:
* 1. insert a char
* 2. deleted a char
* 3. replace a char
*
*
*
* */
public class EditDistance {
    public static void main(String[] args) {
        String A = "anshuman";
        String B = "antihuman";

        System.out.println(bruteForce(A, B));
        System.out.println(editDistanceTopDownDP(A, B));

    }

    static int bruteForce(String A, String B) {
        return bruteForceHelper(A, B, 0, 0);
    }

    static int editDistanceTopDownDP(String A, String B) {

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return topDownDPHelper(A, B, 0, 0, dp);
    }

    static int topDownDPHelper(String A, String B, int indexA, int indexB, int[][] dp) {
        // when source is completely traversed
        if (indexA == A.length()) {
            dp[indexA][indexB] = B.length() - indexB;
            return dp[indexA][indexB];
        }

        // when destination is completely traversed
        if (indexB == B.length()) {
            dp[indexA][indexB] = A.length() - indexA;
            return dp[indexA][indexB];
        }

        // return memoized result
        if (dp[indexA][indexB] != -1) {
            return dp[indexA][indexB];
        }

        // if current char match
        if (A.charAt(indexA) == B.charAt(indexB)) {
            dp[indexA][indexB] =  topDownDPHelper(A, B, indexA + 1, indexB + 1, dp);
        } else {
            int replace = 1 + topDownDPHelper(A, B, indexA + 1, indexB + 1, dp);
            int insert = 1 + topDownDPHelper(A, B, indexA, indexB + 1, dp);
            int delete = 1 + topDownDPHelper(A, B, indexA + 1, indexB, dp);
            dp[indexA][indexB] = Math.min(Math.min(replace, insert), delete);
        }

        return dp[indexA][indexB];
    }

    static int bruteForceHelper(String A, String B, int indexA, int indexB) {
        if (indexA == A.length()) {
            return B.length() - indexB;
        }
        if (indexB == B.length()) {
            return A.length() - indexA;
        }

        if (A.charAt(indexA) == B.charAt(indexB)) {
            return bruteForceHelper(A, B, indexA + 1, indexB + 1);
        }

        int replace = 1 + bruteForceHelper(A, B, indexA + 1, indexB + 1);
        int insert = 1 + bruteForceHelper(A, B, indexA, indexB + 1);
        int delete = 1 + bruteForceHelper(A, B, indexA + 1, indexB);

        return Math.min(Math.min(replace, insert), delete);
    }
}
