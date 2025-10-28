package revision_oct2025.heaps;

import java.util.PriorityQueue;

public class NRopes {
    public static void main(String[] args) {
        int[] ropes = new int[] {16,7,3,5,9,8,6,15};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : ropes)
            pq.offer(i);

        int cost = 0;
        while (pq.size() != 1) {
            int first = pq.poll();
            int second = pq.poll();
            int knot = first + second;
            cost += knot;
            pq.offer(knot);
        }

        System.out.println(cost);
    }
}
