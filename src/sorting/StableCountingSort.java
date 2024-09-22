package sorting;

import java.util.Arrays;

public class StableCountingSort {
    public static void main(String[] args) {
        int [] A = {3, 2, 3, 1, 4, 5, 3, 2, 5, 1, 4};
        int[] output = sort(A);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(output));
    }

    public static int[] sort(int[] A) {
        if (A.length == 0) return null;

        // Get the range of values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        // Get the frequency count of each element
        int[] counts = new int[max + 1];
        for (int i : A) {
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
            int currEle = A[i];
            int prefixFreq = cumulativeCounts[currEle];
            output[prefixFreq - 1] = currEle;
            cumulativeCounts[currEle]--;
        }
        return output;
    }

}
