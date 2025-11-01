package revision_oct2025;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciBruteForce(7));
        System.out.println(fiboDp(7));
        System.out.println(fiboDpIterative1(7));
        System.out.println(fiboDpIterative2(7));
    }

    public static int fibonacciBruteForce(int x) {
        if (x <= 1) return x;

        return fibonacciBruteForce(x - 1) + fibonacciBruteForce(x - 2);
    }

    public static int fiboDp(int x) {
        int[] dp = new int[x + 1];
        Arrays.fill(dp, 0);
        return fiboDpHelper(x, dp);
    }

    private static int fiboDpHelper(int x, int[] dp) {
        if (x <= 1) return x;

        if (dp[x] > 0) return dp[x];

        dp[x] = fiboDpHelper(x - 1, dp) + fiboDpHelper(x - 2, dp);

        return dp[x];

    }

    static int fiboDpIterative1(int x) {
        int[] dp = new int[x + 1];
        dp[1] = 1;
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[x];
    }

    static int fiboDpIterative2(int x) {
        int first = 0, second = 1;
        for (int i = 2; i <= x; i++) {
            int curr = first + second;
            first = second;
            second = curr;
        }
        return second;
    }
}
