package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given N toys, which have happiness value H and weight W, total bag capacity C.
 * Find the max Happiness.
 *
 * */
public class ToyStore {
    public static void main(String[] args) {
        int[] H = {1, 3, 5, 6};
        int[] W = {2, 3, 4, 5};
        int C = 7;

        System.out.println(bruteForce(H, W, 0, C));
        System.out.println(recursiveDp(H, W, 0, C));
        System.out.println(iterativeDp(H, W, C));


    }

    public static int bruteForce(int[] H, int[] W, int index, int remainingCap) {
        if (remainingCap < 0 || index >= W.length) {
            return 0;
        }

        // select the element
        int selected = 0;
        if (W[index] <= remainingCap) {
            selected = H[index] + bruteForce(H, W, index + 1, remainingCap - W[index]);
        }

        // reject the element
        int rejected = bruteForce(H, W, index + 1, remainingCap);

        return Math.max(selected, rejected);
    }

    public static int recursiveDp(int[] H, int[] W, int index, int remainingCap) {
        int[][] dp = new int[W.length + 1][remainingCap + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

       return recursiveDp(H, W, dp, index, remainingCap);
    }

    public static int recursiveDp(int[] H, int[] W, int[][] dp, int index, int remainingCap) {
        if (remainingCap < 0 || index >= W.length) {
            return 0;
        }

        if (dp[index][remainingCap] != -1) {
            return dp[index][remainingCap];
        }
        // select the element
        int selected = 0;
        if (W[index] <= remainingCap) {
            selected = H[index] + recursiveDp(H, W, dp, index + 1, remainingCap - W[index]);
        }

        // reject the element
        int rejected = recursiveDp(H, W, dp, index + 1, remainingCap);

        int ans = Math.max(selected, rejected);
        dp[index][remainingCap] = ans;
        return ans;
    }

    public static int iterativeDp(int[] H, int[] W, int capacity) {
        // 1 - based indexed dp array
        int[][] dp = new int[W.length + 1][capacity + 1];
        for (int i = 1; i <= H.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j - W[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] ,
                            dp[i - 1][j - W[i - 1]] + H[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[W.length][capacity];
    }
}
