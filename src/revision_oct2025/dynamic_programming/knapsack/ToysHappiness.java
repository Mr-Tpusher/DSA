package revision_oct2025.dynamic_programming.knapsack;

import java.util.Arrays;

/*
 * Given N toys, which have happiness value H and weight W, total bag capacity is cap.
 * Find the max happiness.
 * H = {1,3,5,6}
 * W = {2,3,4,5}
 * cap = 7
 *
 * */
public class ToysHappiness {
    public static void main(String[] args) {
        int[] H = {1, 3, 5, 6};
        int[] W = {2, 3, 4, 5};
        int cap = 7;

        System.out.println(bruteForce(H, W, cap));
        System.out.println(topDown(H, W, cap));
        System.out.println(bottomUpDP(H, W, cap));
    }

    static int bruteForce(int[] H, int[] W, int cap) {
        return bruteForceHelper(0, cap, H, W);
    }

    static int topDown(int[] H, int[] W, int cap) {
        int[][] dp = new int[H.length][cap + 1];

        // dp[i][j] = max happiness from index i till end with remaining cap j.

        for (int[] row : dp) Arrays.fill(row, -1);

        topDownHelper(0, cap, H, W, dp);

        return dp[0][cap];
    }

    static int bottomUpDP(int[] H, int[] W, int cap) {
        int n = H.length;
        // 1-based indexing
        int[][] dp = new int[n + 1][cap + 1];

        // dp[i][j] = max happiness for first i elements (means till (i - 1)th index) where bag capacity is j.

        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                // select
                int select = 0;

                if (W[i - 1] <= c) {
                    select = H[i - 1] + dp[i - 1][c - W[i - 1]];
                }

                int reject = dp[i - 1][c];

                dp[i][c] = Math.max(select, reject);
            }
        }
        return dp[n][cap];
    }

    static int topDownHelper(int index, int remCap, int[] H, int[] W, int[][] dp) {
        if (index == H.length || remCap == 0) return 0;

        if (dp[index][remCap] != -1) return dp[index][remCap];

        // select current toy
        int select = 0;
        if (W[index] <= remCap) select = H[index] + topDownHelper(index + 1, remCap - W[index], H, W, dp);

        // reject current toy
        int reject = topDownHelper(index + 1, remCap, H, W, dp);

        return dp[index][remCap] = Math.max(select, reject);
    }

    static int bruteForceHelper(int index, int remCap, int[] H, int[] W) {

        if (remCap == 0 || index == H.length) return 0;

        // select current toy
        int selectToy = 0;
        if (W[index] <= remCap) {
            selectToy = H[index] + bruteForceHelper(index + 1, remCap - W[index], H, W);
        }

        // reject current toy
        int rejectToy = bruteForceHelper(index + 1, remCap, H, W);

        return Math.max(selectToy, rejectToy);
    }
}
