package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] H = {2, 3, 5};
        int[] W = {3, 4, 7};
        int cap = 8;

        System.out.println(solve1(H, W, cap));
        System.out.println(solve2(H, W, cap));
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

    public static int solve2(int[] H, int[] W, int capacity) {
        int[] dp = new int[capacity + 1];
        Arrays.fill(dp, 0);

        // Iterate over each item
        for (int i = 0; i < W.length; i++) {
            // For each item, update the dp array for all capacities from W[i] to capacity
            for (int j = W[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + H[i]);
            }
        }

        // dp[capacity] will have the maximum value achievable for the given capacity
        return dp[capacity];
    }
}
