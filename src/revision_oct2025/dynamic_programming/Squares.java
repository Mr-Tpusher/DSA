package revision_oct2025.dynamic_programming;

/*
 * Given a number N, find min number of perfect squares required to make N.
 *
 * */
public class Squares {
    public static void main(String[] args) {
        System.out.println(minSquaresBruteForce(14));
        System.out.println(minSquaresDp(14));
        System.out.println(minSquaresIterativeDp(14));
    }

    static int minSquaresBruteForce(int N) {
        Minimums minimums = new Minimums();
        bruteForceHelper(N, 1, minimums);
        return minimums.min;
    }

    static int minSquaresDp(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        minSquaresDpHelper(N, dp);
        return dp[N];
    }

    static int minSquaresIterativeDp(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[N];
    }


    static int minSquaresDpHelper(int N, int[] dp) {

        // return memoized result
        if (dp[N] != 0) return dp[N];

        // min number of squares when formed with all 1s
        dp[N] = N;

        for (int i = 1; i * i <= N; i++) {
            int ans = minSquaresDpHelper(N - i * i, dp);
            dp[N] = Math.min(dp[N], ans + 1);
        }

        return dp[N];
    }


    static void bruteForceHelper(int N, int start, Minimums mins) {
        if (N < 0) return;

        if (N == 0) {
            mins.min = Math.min(mins.currMin, mins.min);
            return;
        }

        for (int i = start; i * i <= N; i++) {
            mins.currMin++;
            bruteForceHelper(N - i * i, start, mins);
            mins.currMin--;
        }
    }

    private static class Minimums {
        int currMin;
        int min;

        Minimums() {
            currMin = 0;
            min = Integer.MAX_VALUE;
        }
    }
}
