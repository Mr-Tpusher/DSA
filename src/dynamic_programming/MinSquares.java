package dynamic_programming;

import java.util.Arrays;

/*
* Given a number N, find the min number of squares required to make N.
* e.g. N=6  ---> 2^2 + 1^2 + 1^2    ---> answer=3
*      N=9  ---> 3^2                ---> answer=1
*
*
* */
public class MinSquares {
    public static void main(String[] args) {
        int N = 6;
        int[] minSquares = new int[N + 1];
        Arrays.fill(minSquares, -1);
        minSquares[0] = 0;
        System.out.println(getMinSquares(N, minSquares));
        System.out.println(getMinSquaresIterative(N));
    }

    // Top-down dp -> Recursive approach
    public static int getMinSquares(int N, int[] minSquares) {
        // Base case
        if (minSquares[N] != -1) {
            return minSquares[N];
        }

        int min = N;
        for (int j = 1; j * j <= N; j++) {
            int curr = getMinSquares(N - (j * j), minSquares) + 1;
            min = Math.min(min, curr);
        }
        minSquares[N] = min;
        return min;
    }

    // Bottom-up DP ---> Iterative approach
    public static int getMinSquaresIterative(int N) {
        int[] minSquares = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            minSquares[i] = i;
            for (int j = 1; j * j <= i; j++) {
                minSquares[i] = Math.min(minSquares[i], 1 + minSquares[i - (j * j)]);
            }
        }
        return minSquares[N];
    }
}
