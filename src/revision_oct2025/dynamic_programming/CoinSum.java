package revision_oct2025.dynamic_programming;
/*
* Given an integer R and an integer array of coins, find number of unique ways to form sum R.
* R = 5, coins = [1,2,4]    -> ans = 3
*
*
* */
public class CoinSum {
    public static void main(String[] args) {
        int R = 5;
        int[] coins = {1, 3, 4};
        System.out.println(bruteForce(R, coins));
    }

    static int bruteForce(int R, int[] coins) {
        return bruteForceHelper(R, coins, 0);
    }

    static int bruteForceHelper(int R, int[] coins, int index) {
        // base case -> when remaining R is zero, we have found 1 way to form R
        if (R == 0) {
            return 1;
        }

        int ways = 0;
        for (int i = index; i < coins.length; i++) {
            if (coins[i] <= R) {
                ways += bruteForceHelper(R - coins[i], coins, i);
            }
        }

        return ways;
    }
}
