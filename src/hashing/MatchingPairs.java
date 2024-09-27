package hashing;

import java.util.Arrays;

/*
* Given an array A, find no of pairs in A,
* such that A[i]=A[j] and i!=j
* */
public class MatchingPairs {
    public static void main(String[] args) {
        test();

    }

    public static int bruteForce(int[] A) {
        int pairs = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void test() {
        int[][] input = {
                {},
                {1},
                {1, 2, 3, 4, 5},
                {2, 2},
                {1, 1, 1, 2, 4},
                {1, 2, 3, 2, 1, 6, 3, 2, 1}

        };
        int[] expected = {
                0,
                0,
                0,
                1,
                3,
                7
        };

        for (int i = 0; i < input.length; i++) {
            int pairs = bruteForce(input[i]);
            String verdict = expected[i] == pairs ? "Passed" : "Failed";
            System.out.println("Input:" + Arrays.toString(input[i]));
            System.out.println("Expected:" + expected[i] + ", Got:" + pairs);
            System.out.println(verdict);
        }
    }
}
