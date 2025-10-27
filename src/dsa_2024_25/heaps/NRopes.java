package dsa_2024_25.heaps;
/*
* Given N ropes of random length, tie them together to form a single rope with minimum cost.
* cost means when we tie a knot of  a & b then cost of that know will be a+b
* and the length of the new rope will be a+b.
* ropes = {5, 17, 100, 11}
* Answer(minimum cost) = 182
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NRopes {
    public static void main(String[] args) {
        Integer[] ropes = {5, 17, 100, 11};
        System.out.println(bruteForce(ropes));
        System.out.println(solve(new int[] {5, 17, 100, 11}));

    }

    public static int bruteForce(Integer[] ropes) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(ropes));

        int cost = 0;
        while (al.size() > 1) {
            Collections.sort(al);
            int tempCost = al.get(0) + al.get(1);
            cost += tempCost;
            al.remove(1);
            al.remove(0);
            al.add(tempCost);

        }

        System.out.println(al);
        return cost;
    }


    public static int solve(int[] ropes) {
        MinHeap minHeap = new MinHeap(ropes);

        int totalCost = 0;
        while (minHeap.getSize() > 1) {
            int currentKnotCost = minHeap.deleteMin() + minHeap.deleteMin();
            totalCost += currentKnotCost;
            minHeap.insert(currentKnotCost);
        }
        return totalCost;
    }
}
