package dynamic_programming;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array A of distinct elements, which denotes the denomination of currency, and
 * we have unlimited supply of this currency.
 * Given an integer R, find total number unique of ways to sum R.
 * A = {1, 3, 4}     R = 5
 * ways:
 *       1,1,1,1,1
 *       1,1,3
 *       1,4
 * Answer:3
 * */
public class CoinSum2 {
    public static void main(String[] args) {
        int[] A = {4, 1, 3};
        int R = 5;
        System.out.println(bruteForce(A, R));
        System.out.println(bruteForce2(A, R, 0));
        System.out.println(coinSumIterative(A, R));
    }

    // Brute force approach where we calculate all the possible combinations
    public static int bruteForce(int[] A, int R) {
        ArrayList<ArrayList<Integer>> totalWays = new ArrayList<>();
        ArrayList<Integer> way = new ArrayList<>();
        bruteForce(A, R, totalWays, way, 0);

        int count = 0;
        for (ArrayList<Integer> al : totalWays) {
            System.out.println(al);
            count++;
        }
        return count;
    }

    // Instead of calculating all combinations we just increment the count
    public static int bruteForce2(int[] A, int R, int prev) {
        if (R == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= R && A[i] >= prev) {
                count += bruteForce2(A, R - A[i], A[i]);
            }
        }
        return count;
    }


    private static int coinSumIterative(int[] A, int R) {

        int[] dp = new int[R + 1];
        dp[0] = 1;

        // for each coin, we are calculating ways to make R
        // it's like can we make sum 5 by using coin 1, coin 3, coin 4

        for (int coin : A) {
            for (int i = coin; i <= R; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[R];
    }

    public static void bruteForce(int[] A, int R, ArrayList<ArrayList<Integer>> totalWays,
                                  ArrayList<Integer> ways, int prev) {
        if (R == 0) {
            totalWays.add(new ArrayList<>(ways));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= R && A[i] >= prev) {
                ways.add(A[i]);
                bruteForce(A, R - A[i], totalWays, ways, A[i]);
                ways.remove(ways.size() - 1);
            }
        }
    }
}
