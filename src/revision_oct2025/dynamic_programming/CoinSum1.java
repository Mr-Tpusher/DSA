package revision_oct2025.dynamic_programming;

import java.util.Arrays;

/*
 * Given an integer R and an integer array of coins, find number of all ways to form sum R.
 * R = 5, coins = [1,2,4]    -> ans = 6
 *
 *
 * */
public class CoinSum1 {
    public static void main(String[] args) {
        int R = 5;
        int[] coins = {1, 3, 4};
        System.out.println(bruteForce(R, coins));
        System.out.println(coinSumTopDownDP(R, coins));
        System.out.println(coinSumBottomUpDP(R, coins));
    }

    static int bruteForce(int R, int[] coins) {
        return bruteForceHelper(R, coins);
    }

    static int coinSumTopDownDP(int R, int[] coins) {
        int[] dp = new int[R + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        topDownHelper(R, coins, dp);

        return dp[R];
    }

    static int coinSumBottomUpDP(int R, int[] coins) {
        int[] dp = new int[R + 1];
        dp[0] = 1; // base case

        for (int r = 1; r <= R; r++) {
            for (int coin : coins) {
                if (coin <= r) {
                    dp[r] += dp[r - coin];
                }
            }
        }

        return dp[R];
    }

    static int topDownHelper(int R, int[] coins, int[] dp) {
        if (R == 0) {
            return 1;
        }

        if (dp[R] != -1) {
            return dp[R];
        }

        int ways = 0;
        for (int coin : coins) {
            if (coin <= R) {
                ways += topDownHelper(R - coin, coins, dp);
            }
        }

        return dp[R] = ways;
    }

    static int bruteForceHelper(int R, int[] coins) {
        // base case -> when remaining R is zero, we have found 1 way to form R
        if (R == 0) {
            return 1;
        }

        int ways = 0;
        for (int coin : coins) {
            if (coin <= R) {
                ways += bruteForceHelper(R - coin, coins);
            }
        }

        return ways;
    }
}
