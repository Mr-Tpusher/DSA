package dsa_2024_25.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
* Given an array consisting of height of people. Arrange them in sorted order.
* Note that people are not standing at totally random positions. Each person can be
* at most k distance away form its sorted order position.
*
* A = {10,40,20,30}         k = 2
* Answer = {10, 20, 30, 40}
*
* */
public class AdjustHeights {
    public static void main(String[] args) {
        int[] heights = {10, 12, 5, 2, 30, 27, 22, 67, 70, 70, 99};
        int k = 5;

        int[] output = sortHeights(heights, k);
        System.out.println(Arrays.toString(output));
    }

    private static int[] sortHeights(int[] heights, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i <=k; i++) {
            heap.add(heights[i]);

        }
        int[] output = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            output[i] = heap.remove();
            if (k + 1 + i < heights.length)
                heap.add(heights[k + 1 + i]);
        }

        return output;
    }
}
