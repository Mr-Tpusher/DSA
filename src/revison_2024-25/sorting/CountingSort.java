package sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        test();
    }

    public static void sort(int[] A) {
        if (A.length == 0) return;

        // Get the range of elements
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        //int[] counts = new int[Math.abs(min) + max + 1];
        int[] counts = new int[max - min + 1]; // avoids unnecessary range values
        /*
        * if A is {100, 101, 102} range will have only 3 elements rather than 103.
        * */

        for (int i : A) {
            counts[i - min]++;
        }

        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            int j = 0;
            while (counts[i] > 0) {
                A[k++] = i + min;
                counts[i]--;
            }
        }
    }
    public static void test() {
        // Define test cases and expected results
        int[][] testCases = {
                {5, 3, 8, 6, 2},             // Unsorted
                {-5, 0, 1, 2, -2},           // Mixed
                {0, 0, 0, 0, 0},             // All Zeros
                {-3, -1, -2, -4, -2},        // Negative Only
                {1, 2, 3, 4, 5},             // Already Sorted
                {5, 4, 3, 2, 1},             // Reverse Sorted
                {},                          // Empty Array
                {1}                           // Single Element
        };

        int[][] expectedResults = {
                {2, 3, 5, 6, 8},             // Expected sorted output
                {-5, -2, 0, 1, 2},           // Expected sorted output
                {0, 0, 0, 0, 0},             // Expected sorted output
                {-4, -3, -2, -2, -1},        // Expected sorted output
                {1, 2, 3, 4, 5},             // Expected sorted output
                {1, 2, 3, 4, 5},             // Expected sorted output
                {},                          // Expected sorted output
                {1}                           // Expected sorted output
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = Arrays.copyOf(testCases[i], testCases[i].length); // Copy input for output comparison
            sort(input);

            // Print actual and expected results
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("  Expected: " + Arrays.toString(expectedResults[i]));
            System.out.println("  Actual:   " + Arrays.toString(input));

            // Determine pass/fail
            boolean passed = Arrays.equals(input, expectedResults[i]);
            System.out.println("  Verdict: " + (passed ? "Passed" : "Failed"));
            System.out.println();
        }
    }

}
