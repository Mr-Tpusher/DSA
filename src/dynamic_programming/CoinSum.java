package dynamic_programming;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.ArrayList;
import java.util.Arrays;

/*
* Given an array A of distinct elements, which denotes the denomination of currency, and
* we have unlimited supply of this currency.
* Given an integer R, find total number of ways to sum R.
* A = {1, 3, 4}     R = 5
* ways:
*       1,1,1,1,1
*       1,1,3
*       1,3,1
*       3,1,1
*       1,4
*       4,1
* Answer:6
*
*
* */
public class CoinSum {
    public static void main(String[] args) {
        int[] A = {1, 3, 4};
        int R = 5;
        System.out.println(bruteForce(A, R));
    }

    public static int bruteForce(int[] A, int R) {
        ArrayList<ArrayList<Integer>> totalWays = new ArrayList<>();
        ArrayList<Integer> way = new ArrayList<>();
        bruteForce(A, R, totalWays, way);

        int count = 0;
        for (ArrayList<Integer> al : totalWays) {
            System.out.println(al);
            count++;
        }
        return count;
    }

    public static void bruteForce(int[] A, int R, ArrayList<ArrayList<Integer>> totalWays,
                                  ArrayList<Integer> ways) {
        if (R == 0) {
            totalWays.add(new ArrayList<>(ways));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= R) {
                ways.add(A[i]);
                bruteForce(A, R - A[i], totalWays, ways);
                ways.remove(ways.size() - 1);
            }
        }
    }
}
