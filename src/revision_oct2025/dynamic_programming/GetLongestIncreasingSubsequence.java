package revision_oct2025.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GetLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A = {6, 1, 5, 2, 7, 8, 3, 0, 4};
        System.out.println(getLIS(A));
    }

    static ArrayList<Integer> getLIS(int[] A) {
        if (A == null || A.length == 0) return null;

        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);

        // dp[i] = length of lis ending at i
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answerIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (dp[i] > dp[answerIndex])
                answerIndex = i;
        }

        // get the lis
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(A[answerIndex]);

        int lisLength = dp[answerIndex] - 1;
        int lastValue = A[answerIndex];
        for (int i = answerIndex - 1; i >= 0 ; i--) {
            if (dp[i] == lisLength && A[i] < lastValue) {
                lis.add(A[i]);
                lisLength--;
                lastValue = A[i];
            }

        }
        Collections.reverse(lis);
        return lis;
    }
}
