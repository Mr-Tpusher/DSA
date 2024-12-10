package dynamic_programming;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] H = {2, 3, 5};
        int[] W = {3, 4, 7};
        int cap = 8;

        System.out.println(solve1(H, W, cap));
    }

    public static int solve1(int[] H, int[] W, int cap) {
        int[][] dp = new int[H.length + 1][cap + 1];
        for (int i = 1; i <= H.length; i++) {
            for (int j = 1; j <= cap; j++) {
                // Select the element
                if (j - W[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i][j - W[i - 1]] + H[i - 1]);
                }
                else { // Reject
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[W.length][cap];
    }
}
