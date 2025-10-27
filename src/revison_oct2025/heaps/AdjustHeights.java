package revison_oct2025.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
*
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

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i <= k; i++)
            heap.offer(heights[i]);

        int[] output = new int[heights.length];

        int i = 0, j = k + 1;
        while (!heap.isEmpty()) {
            output[i++] = heap.poll();

            if (j < heights.length)
                heap.offer(heights[j++]);
        }

        System.out.println(Arrays.toString(output));
    }
}
