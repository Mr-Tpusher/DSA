package revision_oct2025.heaps;
/*
* Given an array of n elements, find the kth largest number for all of its subarrays.
* here subarray at index i is the subarray formed from the starting of the array till ith index.
* A=[1,2,3,4,5,6]   k=4
* Output: [-1,-1,-1,1,2,3]
*
* */
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestForSubArrays {
    public static void main(String[] args) {
        int[] arr = {100, 10, 7, 8, 9, 10, 11, 12, 15};
        int k = 4;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            heap.offer(arr[i]);

        int[] output = new int[arr.length];
        for (int i = 0; i < k - 1; i++)
            output[i] = -1;

        int i = k - 1;

        while (i < arr.length) {
            output[i] = heap.peek();
            if (i + 1 < arr.length && arr[i + 1] > heap.peek()) {
                heap.poll();
                heap.offer(arr[i + 1]);
            }
            i++;
        }
        System.out.println(Arrays.toString(output));
    }
}
