package heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
* We have running stream of numbers. After every new number return median till that point.
* */
public class RunningMedian {
    public static void main(String[] args) {
        Integer[] numbers = {5, 17, 100, 11, 20, 5, 2, 20, 22};

        Integer[] output = getRunningMedian(numbers);
        System.out.println(Arrays.toString(output));
    }

    private static Integer[] getRunningMedian(Integer[] numbers) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Integer[] output = new Integer[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (maxHeap.isEmpty() || number < maxHeap.peek()) {
                maxHeap.offer(number);
            } else {
                minHeap.offer(number);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size()) {
                output[i] = maxHeap.peek();
            } else {
                output[i] = (maxHeap.peek() + minHeap.peek()) / 2;
            }
        }
        return output;
    }
}
