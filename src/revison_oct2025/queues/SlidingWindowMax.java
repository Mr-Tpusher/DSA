package revison_oct2025.queues;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * Given an array and a number k, find the maximum value in each subarray of the size k.
 * A = {10,9,4,2,13,5,14,2,9,8,7,10}     k = 3
 * O = {10,9,13,13,14,14,14,9,9,10}
 * */
public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] A = {10, 9, 4, 2, 13, 5, 14, 2, 9, 8, 7, 10};
        int k = 3;
        int[] output = solution1(A, k);
        System.out.println(Arrays.toString(output));

        System.out.println(Arrays.toString(solution2(A, k)));

    }

    static int[] solution1(int[] A, int k) {
        int N = A.length;
        int[] output = new int[N - k + 1];

        for (int i = 0; i <= N - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, A[j]);
            }
            output[i] = max;
        }
        return output;
    }

    static int[] solution2(int[] A, int k) {
        int N = A.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] output = new int[N - k + 1];

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && A[deque.peekLast()] < A[i] ) {
                deque.pollLast();
            }
            deque.offerLast(i);

            while (!deque.isEmpty() && deque.peekFirst() <= i - k ) {
                deque.pollFirst();
            }

            if (i >= k - 1)
                output[i - (k - 1)] = A[deque.peekFirst()];
        }
        return output;
    }
}
