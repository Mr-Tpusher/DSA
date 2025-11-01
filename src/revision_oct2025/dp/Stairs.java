package revision_oct2025.dp;

/*
 * Given N stairs, In one step you can climb either one or two stairs.
 * Find the total number of ways to reach the Nth stair.
 * */
public class Stairs {
    public static void main(String[] args) {
        System.out.println(totalWaysBruteForce(5));
        System.out.println(totalWaysDp(5));
        System.out.println(totalWaysBottomUpDp(5));
    }

    static int totalWaysBruteForce(int N) {
        if (N < 0) return 0;

        if (N == 0) {
            return 1;
        }

        return totalWaysBruteForce(N - 1) + totalWaysBruteForce(N - 2);
    }


    static int totalWaysDp(int N) {
        if (N <= 2) return N;

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        totalWaysDpHelper(N, dp);
        return dp[N];
    }

    static int totalWaysDpHelper(int N, int[] dp) {
        if (N <= 2) return N;

        if (dp[N] == 0) {
            dp[N] = totalWaysDpHelper(N - 1, dp) + totalWaysDpHelper(N - 2, dp);
        }
        return dp[N];
    }


    static int totalWaysBottomUpDp(int N) {
        if (N <= 2) return N;

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

}
