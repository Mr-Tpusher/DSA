package revision_oct2025.heaps;

import java.util.*;

public class RunningMedian {
    public static void main(String[] args) {

        int[] input = {5, 17, 100, 11, 20, 5, 2, 20, 22};
        System.out.println(Arrays.toString(bruteForce(input)));
        System.out.println(Arrays.toString(getMedians(input)));

    }

    static int[] bruteForce(int[] input) {
        int[] medians = new int[input.length];
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            al.add(input[i]);
            Collections.sort(al);
            int size = al.size();
            if ((size & 1) == 0) {
                medians[i] = (al.get(size / 2) + al.get(size / 2 - 1)) / 2;
            } else {
                medians[i] = al.get(size / 2);
            }
        }
        return medians;
    }

    static int[] getMedians(int[] input) {

        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder()); // MaxHeap
        PriorityQueue<Integer> highers = new PriorityQueue<>(); // MinHeap

        int[] medians = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.isEmpty() || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = biggerHeap == lowers ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    static int getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() == smallerHeap.size()) {
            return (biggerHeap.peek() + smallerHeap.peek()) / 2;

        } else {
            return biggerHeap.peek();
        }
    }
}
