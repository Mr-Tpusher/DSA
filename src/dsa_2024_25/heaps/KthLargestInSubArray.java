package dsa_2024_25.heaps;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
* Given an array of N elements, find the Kth largest number for all of its sub-arrays.
*
* A = {100, 10, 7, 8, 9, 10, 11, 12, 15}        k = 4
*
* */
public class KthLargestInSubArray {
    public static void main(String[] args) {
        Integer[] A = {100, 10, 7, 8, 9, 10, 11, 12, 15};
        int k = 4;
        int[] output = solve(A, k);
        System.out.println(Arrays.toString(output));

    }
    public static int[] solve(Integer[] A, int k) {

        int[] output = new int[A.length];
        int i = 0;
        for (; i < k - 1; i++) {
            output[i] = -1;
        }

        List<Integer> l = Arrays.asList(Arrays.copyOf(A, k));
        PriorityQueue<Integer> heap = new PriorityQueue<>(l);
        output[i++] = heap.peek();

        for (int j = k; j < A.length; j++) {
            System.out.println(heap);
            if (A[j] > heap.peek()) {
                heap.remove();
                heap.add(A[j]);
            }
            output[i++] = heap.peek();
        }
        return output;
    }
}
