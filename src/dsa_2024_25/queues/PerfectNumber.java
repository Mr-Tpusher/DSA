package dsa_2024_25.queues;

import java.util.ArrayDeque;
import java.util.LinkedList;

/*
 * Perfect number:
 *   1. has only 1's and 2's an
 *   2. Even number of digits
 *   3. Number is symmetrical/ Palindrome
 *
 * Find Nth perfect number.
 *
 * */
public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(solve(9));
    }

    public static String solve(int N) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("11");
        queue.offer("22");

        int count = 2;
        while (count < N) {
            ArrayDeque<String> newQueue = new ArrayDeque<>();
            ArrayDeque<String> tempQueue = new ArrayDeque<>();

            while (!queue.isEmpty()) {
                String curr = queue.poll();
                StringBuilder sb1 = new StringBuilder("1" + curr + "1");
                newQueue.offer(sb1.toString());
                tempQueue.offer(curr);
            }

            while (!tempQueue.isEmpty()) {
                String curr = tempQueue.poll();
                StringBuilder sb2 = new StringBuilder("2" + curr + "2");
                newQueue.offer(sb2.toString());
            }
            queue = newQueue;
            count += newQueue.size();
        }

        System.out.println(queue);
        count = count / 2;
        for (int i = count; i < N; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}

