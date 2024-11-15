package heaps;
/*
* Given N ropes of random length, tie them together to form a single rope with minimum cost.
* cost means when we tie a knot of  a & b then cost of that know will be a+b
* and the length of the new rope will be a+b.
* ropes = {5, 17, 100, 11}
* Answer(minimum cost) = 198
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
* ropes = {5, 17, 100, 11}
* knot1 = 5+17=22               tc=22
* ropes = {22, 100, 11}
* knot2 = 22+100=122            tc=22+122=144
* ropes = {122,11}
* knot3 = 133                   tc=277
*
* */
public class NRopes {
    public static void main(String[] args) {
        Integer[] ropes = {5, 17, 100, 11};
        System.out.println(bruteForce(ropes));

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
}
