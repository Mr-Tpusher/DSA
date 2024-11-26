package dynamic_programming;

import java.util.Arrays;

/*
* Given an integer array, find the largest increasing subsequence.
* A = {0, 8, 4, 12, 10, 6, 14, 1, 9, 5, 13}
* Answer: {0, 4, 6, 9, 13}
*
* */
public class PrintLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A = {0, 8, 4, 12, 10, 6, 14, 1, 9, 5, 13};
        System.out.println(Arrays.toString(solve(A)));

    }

    public static int[] solve(int[] A) {
        int[] LIS = new int[A.length];
        LIS[0] = 1;

        for (int i = 1; i < A.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    int currMax = 1 + LIS[j];
                    max = Math.max(max, currMax);
                }
            }
            LIS[i] = max;
        }

        int ans = 0;
        int maxLisIndex = 0;
        for (int i = 0; i < LIS.length; i++) {
            if (LIS[i] > ans) {
                ans = LIS[i];
                maxLisIndex = i;
            }
        }

        int[] output = new int[ans];
        output[output.length - 1] = A[maxLisIndex];
        int prev = A[maxLisIndex];
        int outputIndex = output.length - 2, lis = ans - 1;
        for (int i = maxLisIndex - 1; i >= 0; i--) {
            if (A[i] < prev && LIS[i] == lis)  {
                output[outputIndex] = A[i];
                outputIndex--;
                lis--;
            }
        }
        return output;
    }
}
