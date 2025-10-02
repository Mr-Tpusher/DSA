package hashing;

import java.util.Arrays;
import java.util.HashSet;
/*
* Given an array, find the largest sequence of the numbers
* such that the numbers are contiguous.
* int[] A = {100, 4, 3, 6, 10, 12, 11, 5, 101}
*
*
* */
public class LargestContiguousSequence {
    public static void main(String[] args) {
        test();
    }

    public static int bruteForce(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int largestSequenceLength = 1;
        int currSequenceLength = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1] - 1) {
                currSequenceLength++;
            } else {
                currSequenceLength = 1;
            }
            largestSequenceLength = Math.max(largestSequenceLength, currSequenceLength);
        }
        return largestSequenceLength;
    }

    public static int largestContiguousSequence(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : A) {
            hs.add(i);
        }
        int largestContiguousSequenceLength = 0;
        for (int i : A) {
            if (!hs.contains(i - 1)) {
                int n = i;
                int currLen = 0;
                while (hs.contains(n)) {
                    currLen++;
                    n = n + 1;
                }
                largestContiguousSequenceLength = Math.max(largestContiguousSequenceLength, currLen);
            }
        }
        return largestContiguousSequenceLength;
    }

    public static void test() {
        int[][] input = {
                {},
                {1},
                {1, 2, 3, 4, 5},
                {2, 3},
                {10, 5, 2, 4, 11, 3},
                {100, 4, 3, 6, 10, 12, 11, 5, 101, 103, 104, 105, 106, 102}
        };
        int[] expected = {
                0,
                1,
                5,
                2,
                4,
                7
        };

        for (int i = 0; i < input.length; i++) {
            int pairs = largestContiguousSequence(input[i]);
            String verdict = expected[i] == pairs ? "Passed" : "Failed";
            System.out.println("Input:" + Arrays.toString(input[i]));
            System.out.println("Expected:" + expected[i] + ", Got:" + pairs);
            System.out.println(verdict);
        }
    }
}
