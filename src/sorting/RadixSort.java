package sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        test();
    }

    public static void radixSort(int[] A) {

        int maxDigits = 0;
        for (int i : A) {
            maxDigits = Math.max(maxDigits, Integer.toString(i).length());
        }

        for (int digit = 0; digit < maxDigits; digit++) {
            int[] digits = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                int curr = A[i];
                int tempDigit = (curr / (int) Math.pow(10, digit)) % 10;
                digits[i] = tempDigit;
            }
            int[] sortedA = countingSort(digits, A);
            System.arraycopy(sortedA, 0, A, 0, sortedA.length);
        }
    }

    public static int[] countingSort(int[] digits, int[] A) {

        // Get the frequency count of each element
        int[] counts = new int[10];
        for (int i : digits) {
            counts[i]++;
        }

        // Calculate prefix sum of the frequencies
        int[] cumulativeCounts = new int[counts.length];
        cumulativeCounts[0] = counts[0];
        for (int i = 1; i < counts.length; i++) {
            cumulativeCounts[i] = cumulativeCounts[i - 1] + counts[i];
        }

        int[] output = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            int currEle = digits[i];
            int prefixFreq = cumulativeCounts[currEle];
            output[prefixFreq - 1] = A[i];
            cumulativeCounts[currEle]--;
        }
        return output;
    }


    public static void test() {
        int[][] testCases = {
                {10, 52, 5, 209, 19, 44},    // Mixed values
                {1, 2, 3, 4, 5},              // Already sorted
                {5, 4, 3, 2, 1},              // Reverse sorted
                {5, 1, 4, 1, 2, 1},           // Duplicates
                {100, 200, 300, 400},         // Large values
                {},                           // Empty array
                {7}                           // Single element
        };

        int[][] expectedOutputs = {
                {5, 10, 19, 44, 52, 209},     // Expected output for mixed values
                {1, 2, 3, 4, 5},              // Expected output for sorted
                {1, 2, 3, 4, 5},              // Expected output for reverse sorted
                {1, 1, 1, 2, 4, 5},           // Expected output for duplicates
                {100, 200, 300, 400},         // Expected output for large values
                {},                           // Expected output for empty array
                {7}                           // Expected output for single element
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] original = Arrays.copyOf(testCases[i], testCases[i].length); // Copy original for reference
            radixSort(testCases[i]);

            boolean testPassed = Arrays.equals(testCases[i], expectedOutputs[i]);

            System.out.println("Original: " + Arrays.toString(original));
            System.out.println("Sorted: " + Arrays.toString(testCases[i]));
            System.out.println(testPassed ? "Test Passed!" : "Test Failed!");
            System.out.println();
        }
    }


}
