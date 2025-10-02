package dsa_2024_25.dynamic_programming;

import util.Array;

import java.util.Arrays;

/*
* Given N stairs, In one step, you can climb either 1 stair or 2 stairs. Find the total # of
* ways to reach the Nth stair.
* e.g. N=3
* 1st way: 0->1->2->3
* 2nd way: 0->1-->3
* 3rd way: 0-->2->3
* Answer: total 3 ways
*
* */
public class Stairs {
    public static void main(String[] args) {
        int n = 5;
        int[] output = new int[n + 1];
        Arrays.fill(output, -1);

        System.out.println(waysRecursive(n, output));
        System.out.println(waysIterative(n));

    }

    // Top Down
    public static int waysRecursive(int n, int[] ways) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (ways[n] > -1) {
            return ways[n];
        }

        ways[n] = waysRecursive(n - 1, ways) + waysRecursive(n - 2, ways);
        return ways[n];
    }

    // Bottom up
    public static int waysIterative(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int waysToReachPrev = 2;
        int waysToReachPrevToPrev = 1;
        for (int i = 3; i <= n; i++) {
            int waysForCurr = waysToReachPrev + waysToReachPrevToPrev;
            waysToReachPrevToPrev = waysToReachPrev;
            waysToReachPrev = waysForCurr;
        }
        return waysToReachPrev;
    }
}
