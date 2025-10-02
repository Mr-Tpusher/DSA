package dsa_2024_25.dynamic_programming;
/*
Given an array of integers A representing chain of 2-D matrices such that
the dimensions of ith matrix is A[i-1] x A[i].
Find the most efficient way to multiply these matrices together.
The problem is not actually to perform the multiplications,
but merely to decide in which order to perform the multiplications.
Return the minimum number of multiplications needed to multiply the chain.

 A = [40, 20, 30, 10, 30]    Answer = 26000
  A = [10, 20, 30]           Answer = 6000

*
* */
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] A = {40, 20, 30, 10, 30};

        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int totalMatrices = A.length - 1;

        // dp[i][j] stores minimum number of multiplications
        int[][] dp = new int[totalMatrices][totalMatrices];

        // cost would be zero for a single matrix
        for (int i = 0; i < totalMatrices; i++) {
            dp[i][i] = 0;
        }

        // l here is the matrix chain length
        for (int l = 2; l <= totalMatrices; l++) {
            for (int i = 0; i <= totalMatrices - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible split point k between i and j
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + A[i] * A[k + 1] * A[j + 1];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        return dp[0][totalMatrices - 1];
    }
}
