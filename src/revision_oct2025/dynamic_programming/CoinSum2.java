package revision_oct2025.dynamic_programming;

import java.util.Arrays;

/*
 * Given an integer R and an integer array of coins, find number of UNIQUE ways to form sum R.
 * R = 5, coins = [1,2,4]    -> ans = 3
*
* */
public class CoinSum2 {
    public static void main(String[] args) {
        int R = 5;
        int[] coins = {4,1,3};

        System.out.println(bruteForce(R, coins));
        System.out.println(topDownDP(R, coins));

    }

    static int bruteForce(int R, int[] coins) {
        return bruteForceHelper(R, coins, 0);
    }

    static int topDownDP(int R, int[] coins) {
        int[][] dp = new int[R + 1][coins.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int[] sortedCoins = Arrays.copyOf(coins, coins.length);
        Arrays.sort(sortedCoins);

        return topDownHelper(R, sortedCoins, 0, dp);
    }

    static int topDownHelper(int R, int[] coins, int prevCoinIndex, int[][] dp) {
        if (R == 0) return 1;

        if (dp[R][prevCoinIndex] != -1) return dp[R][prevCoinIndex];

        int ways = 0;
        for (int i = prevCoinIndex; i < coins.length; i++) {
            if (coins[i] <= R) {
                ways += topDownHelper(R - coins[i], coins, i, dp);
            }
        }
        return dp[R][prevCoinIndex] = ways;
    }

    static int bruteForceHelper(int R, int[] coins, int prevCoinValue) {
        if (R == 0) {
            return 1;
        }

        int ways = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= R && (coins[i] >= prevCoinValue)) {
                ways += bruteForceHelper(R - coins[i], coins, coins[i]);
            }
        }
        return ways;
    }

}
