package revision_oct2025.greedy_algo;

import java.util.Arrays;

/*
* N children are standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
    1.  Each child must have at least one candy.
    2.  Children with a higher rating get more candies than their neighbors.

What is the minimum number of candies you must give?
*
 A = [1, 2]     answer = 3
 A = [1, 5, 2, 1]   answer = 7
*
* */
public class CandyShop {
    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1};
        System.out.println(minCandies1(A));
        System.out.println(minCandies2(A));

    }

    private static int minCandies1(int[] A) {
        int[] leftCandies = new int[A.length];

        leftCandies[0] = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                leftCandies[i] = leftCandies[i - 1] + 1;
            } else {
                leftCandies[i] = 1;
            }
        }

        int[] rightCandies = new int[A.length];
        rightCandies[A.length - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) rightCandies[i] = rightCandies[i + 1] + 1;
            else rightCandies[i] = 1;
        }

        int[] candies = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            candies[i] = Math.max(leftCandies[i], rightCandies[i]);
        }
        return Arrays.stream(candies).sum();
    }

    private static int minCandies2(int[] A) {
        int[] leftCandies = new int[A.length];

        leftCandies[0] = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                leftCandies[i] = leftCandies[i - 1] + 1;
            } else {
                leftCandies[i] = 1;
            }
        }

        int prev = 0;
        int ans = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int curr = 0;

            if (i == A.length - 1 || A[i] > A[i+1]) curr = prev + 1;
            else curr = 1;

            ans += Math.max(curr, leftCandies[i]);

            prev = curr;

        }

        return ans;
    }
}
