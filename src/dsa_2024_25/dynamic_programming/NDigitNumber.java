package dsa_2024_25.dynamic_programming;

import java.util.Arrays;

/*
* Find the count of N digit numbers, with digit sum = S
* e.g. N = 2, S = 4
*
* */
public class NDigitNumber {
    public static void main(String[] args) {
        int N = 4;
        int S = 4;
        System.out.println(bruteForce(N, S));
        System.out.println(recursiveBruteForce(N, S));
        System.out.println(dpSolution(N, S));
    }


    /*
    * consider N = 2
    * N digit numbers 10 to 99 i.e. 10^(N-1) to 10^N - 1
    * total number = (10^N - 1 - 10^(N-1) + 1)
    *              = 10^(N-1) [10 - 1]
    *              = 9 * 10^(N-1)
    *
    *
    * */

    public static int bruteForce(int N, int S) {
        int count = 0;
        for (int i = (int) Math.pow(10, N - 1); i < Math.pow(10, N); i++) {
            int sum = 0;
            int number = i;
            while (number != 0) {
                sum += number % 10;
                number = number / 10;
            }
            if (sum == S) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }


    public static int recursiveBruteForce(int N, int S) {
        // Base cases
        if (N <= 0) return 0;
        if (N == 1 && S > 9) return 0;
        if (N == 1 && S > 0 && S <= 9) return 1;

        int count = 0;
        for (int i = 0; i <= 9; i++) {
            count += recursiveBruteForce(N - 1, S - i);
        }
        return count;
    }

    public static int dpSolution(int N, int S) {
        int[][] dp = new int[N + 1][S + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dpSolution(N, S, dp);
    }

    public static int dpSolution(int N, int S, int[][] dp) {
        if (N == 1 && 1 <= S && S <= 9) return 1;
        if (N == 1 && S > 9) return 0;
        if (N <= 0 || S <= 0) return 0;

        if (dp[N][S] != -1) {
            return dp[N][S];
        }

        int count = 0;
        for (int i = 0; i <= 9; i ++) {
            count += dpSolution(N - 1, S - i, dp);
        }
        dp[N][S] = count;
        return count;
    }


}
