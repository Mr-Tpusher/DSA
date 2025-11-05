package revision_oct2025.dynamic_programming;

import java.util.Arrays;

/*
* Find the count of N digit numbers with digit sum = S.
* N = 2, S = 4
* ans -> 4 i.e. 13, 22, 31, 40
* */
public class NDigits {
    public static void main(String[] args) {
        int N = 2, S = 97;
        System.out.println(bruteForce1(N, S));
        System.out.println(bruteForce2(N, S));
        System.out.println(topDownDp(N, S));
    }

    static int bruteForce2(int N, int S) {
        return bruteForce2Helper(N, S);
    }

    static int topDownDp(int N, int S) {
        if (S > N * 9) return 0;

        int[][] dp = new int[N + 1][9 * N + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return topDownDPHelper(N, S, dp);
    }

    static int topDownDPHelper(int N, int S, int[][] dp) {
        if (N == 1 && (S <= 9 && S > 0)) return 1;
        if (N == 1 && (S > 9 || S < 0)) return 0;
        if (N == 0 && S > 0) return 0;
        if (N < 0 || S < 0) return 0;

        if (dp[N][S] != -1) return dp[N][S];

        int ways = 0;
        for (int i = 0; i <= 9; i++) {
            ways += topDownDPHelper(N - 1, S - i, dp);
        }

        return dp[N][S] = ways;
    }

    static int bruteForce2Helper(int N, int S) {
        if (N == 1 && ( 1 <= S && S <= 9)) return 1;
        if (N == 0 && S > 0) return 0;
        if (N == 1 && (S <= 0 || S > 9)) return 0;

        // check possibilities for all 10 digits
        int ways = 0;
        for (int i = 0; i <= 9; i++) {
            ways += bruteForce2Helper(N - 1, S - i);
        }

        return ways;
    }

    static int bruteForce1(int N, int S) {
        int start = (int) Math.pow(10, N - 1);
        int end = (int) Math.pow(10, N) - 1;
        int count = 0;

        for (int i = start; i <= end; i++) {
            int number = i;
            int currSum = 0;
            while (number != 0) {
                currSum += (number % 10);
                number = number / 10;
                if (currSum > S) break;
            }

            if (currSum == S) count++;
        }

        return count;
    }
}
