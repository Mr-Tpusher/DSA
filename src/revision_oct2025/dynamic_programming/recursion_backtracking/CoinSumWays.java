package revision_oct2025.dynamic_programming.recursion_backtracking;

import java.util.ArrayList;

/*
* Given an integer R and an array of coins, find all the ways to make the sum R.
* R = 5 , coins = [1,2,4]
*
* */
public class CoinSumWays {
    public static void main(String[] args) {
        int R = 5;
        int[] coins = {1,3,4};

        getAllUniqueWays1(coins, R);
        getAllUniqueWays2(coins, R);
        getAllWays1(coins, R);

    }

    static void getAllUniqueWays1(int[] coins, int R) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        uniqueWayBinaryRecursionHelper(coins, R, 0, new ArrayList<>(), result);
        System.out.println(result);
    }


    static void getAllUniqueWays2(int[] coins, int R) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        uniqueWaysLoopRecursionHelper(coins, R, 0, new ArrayList<>(), result);
        System.out.println(result);
    }


    static void getAllWays1(int[] coins, int R) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getAllWays1Helper(coins, R, new ArrayList<>(), result);
        System.out.println(result);
    }

    static void getAllWays1Helper(int[] coins, int R, ArrayList<Integer> way, ArrayList<ArrayList<Integer>> result) {
        if (R == 0) {
            result.add(new ArrayList<>(way));
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if (R - coins[i] >= 0) {
                way.add(coins[i]);
                getAllWays1Helper(coins, R - coins[i], way, result);
                way.remove(way.size() - 1);
            }
        }
    }

    static void uniqueWayBinaryRecursionHelper(int[] coins, int R, int index, ArrayList<Integer> way, ArrayList<ArrayList<Integer>> result) {
        if (R == 0) {
            result.add(new ArrayList<>(way));
            return;
        }

        if (R < 0 || index == coins.length) return; // no valid way found

        // choose this coin
        if (R - coins[index] >= 0) {
            way.add(coins[index]);
            uniqueWayBinaryRecursionHelper(coins, R - coins[index], index, way, result);
            way.remove(way.size() - 1); // backtrack
        }

        // do not choose this coin
        uniqueWayBinaryRecursionHelper(coins, R, index + 1, way, result);

    }

    static void uniqueWaysLoopRecursionHelper(int[] coins, int R, int index, ArrayList<Integer> way, ArrayList<ArrayList<Integer>> result) {
        if (R == 0) {
            result.add(new ArrayList<>(way));
            return;
        }

        if (R < 0 || coins.length == index) return;

        for (int i = index; i < coins.length; i++) {
            if (R - coins[index] >= 0) {
                way.add(coins[i]);
                uniqueWaysLoopRecursionHelper(coins, R - coins[i], i, way, result);
                way.remove(way.size() - 1);
            }

            //uniqueWaysLoopRecursionHelper(coins, R, index + 1, way, result);

        }
    }
}
