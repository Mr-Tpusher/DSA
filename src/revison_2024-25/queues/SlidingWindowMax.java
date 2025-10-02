package queues;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
* Given an array and a number k, find the max value in each sub-array of the size k.
* Arr = {10, 9, 4, 2, 13, 5, 14, 2, 9, 8, 7, 10}      k = 3
* Ans = {10, 9, 13, 13, 14, 14, 9, 9, 10}
* */
public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] Arr = {10, 9, 4, 2, 13, 5, 14, 2, 9, 8, 7, 10};
        int k = 3;

        System.out.println(Arrays.toString(solveUsingLoops(Arr, k)));
        System.out.println(Arrays.toString(solveUsingDequeue(Arr, k)));
    }

    public static int[] solveUsingLoops(int[] Arr, int k) {
        int length = Arr.length;
        int totalSubArrays = length - k + 1;
        int[] windowMax = new int[totalSubArrays];
        for (int i = 0; i < totalSubArrays; i++) {
            int currentMax = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                currentMax = Math.max(currentMax, Arr[i + j]);
            }
            windowMax[i] = currentMax;
        }
        return windowMax;
    }

    public static int[] solveUsingDequeue(int[] Arr, int k) {
        // {10, 9, 4, 2, 13, 5, 14, 2, 9, 8, 7, 10}
        int length = Arr.length;
        int totalSubArrays = length - k + 1;
        int[] windowMax = new int[totalSubArrays];
        ArrayDeque<Integer> windowMaxCandidates = new ArrayDeque<>();

        for (int i = 0, j = 0; i < length; i++) {
            while (!windowMaxCandidates.isEmpty() && Arr[windowMaxCandidates.peekLast()] < Arr[i]) {
                windowMaxCandidates.pollLast();
            }
            while (!windowMaxCandidates.isEmpty() && windowMaxCandidates.peekFirst() <= i - k) {
                windowMaxCandidates.pollFirst();
            }
            windowMaxCandidates.addLast(i);

            if (i >= k - 1) {
                windowMax[j++] = Arr[windowMaxCandidates.peekFirst()];
            }
        }
        return windowMax;
    }
}
