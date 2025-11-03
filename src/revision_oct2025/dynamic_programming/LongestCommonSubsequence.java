package revision_oct2025.dynamic_programming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String a = "zacbdf";
        String b = "dazcd";
        System.out.println(bruteForceBackward(a, b));
        System.out.println(bruteForce2Forward(a, b));
        System.out.println(lcsTopDownDP(a, b));
        System.out.println(lcsBottomUpDP(a, b));

    }

    static int bruteForceBackward(String a, String b) {
        return backwardHelper(a, b, a.length() - 1, b.length() - 1);
    }


    static int bruteForce2Forward(String a, String b) {
        return forwardHelper(a, b, 0, 0);
    }

    static int lcsTopDownDP(String a, String b) {
        // 0-based indexing
        int[][] dp = new int[a.length()][b.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return lcsTopDownDPHelper(a, b, a.length() - 1, b.length() - 1, dp);

    }

    //---------------------------bottom up dp--------------------------------------------------------------------------
    static int lcsBottomUpDP(String a, String b) {
        // 1-based indexing
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }


    //----------------------------recursion and memoization-------------------------------------------------------------
    static int lcsTopDownDPHelper(String a, String b, int aIndex, int bIndex, int[][] dp) {
        if (aIndex < 0 || bIndex < 0) return 0;

        if (dp[aIndex][bIndex] != -1) {
            return dp[aIndex][bIndex];
        }

        if (a.charAt(aIndex) == b.charAt(bIndex)) {
            dp[aIndex][bIndex] = 1 + lcsTopDownDPHelper(a, b, aIndex - 1, bIndex - 1, dp);
        } else {
            int first = lcsTopDownDPHelper(a, b, aIndex, bIndex - 1, dp);
            int second = lcsTopDownDPHelper(a, b, aIndex - 1, bIndex, dp);
            dp[aIndex][bIndex] = Math.max(first, second);
        }

        return dp[aIndex][bIndex];
    }

    static int backwardHelper(String a, String b, int aIndex, int bIndex) {
        if (aIndex < 0 || bIndex < 0) return 0;

        // when char match
        if (a.charAt(aIndex) == b.charAt(bIndex)) {
            return 1 + backwardHelper(a, b, aIndex - 1, bIndex - 1);
        }

        // when chars don't match, we explore both possibilities
        int first = backwardHelper(a, b, aIndex, bIndex - 1);
        int second = backwardHelper(a, b, aIndex - 1, bIndex);

        return Math.max(first, second);
    }

    static int forwardHelper(String a, String b, int indexA, int indexB) {
        if (indexA == a.length() || indexB == b.length()) return 0;

        if (a.charAt(indexA) == b.charAt(indexB)) {
            return 1 + forwardHelper(a, b, indexA + 1, indexB + 1);
        }

        int first = forwardHelper(a, b, indexA, indexB + 1);
        int second = forwardHelper(a, b, indexA + 1, indexB);

        return Math.max(first, second);
    }

}
