package dsa_2024_25.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
* We have an array of nuts and bolts, and we have to correctly map nuts to bolts.
* Constraints:
*   1. N[i] = B[i]
*   2. You cannot compare nuts with nuts and bolts with bolts(Sorting is not allowed).
*   3. Hashmap, count array are not allowed.
*
* * */
public class NutsAndBolts {
    public static void main(String[] args) {
        int[] nuts1 = {6, 1, 3};
        int[] bolts1 = {3, 6, 1};
        System.out.println("Test Case 1:");
        System.out.println("Input: ");
        System.out.println("nuts1:" + Arrays.toString(nuts1) + " & " +
                "bolts:" + Arrays.toString(bolts1));
        solve(nuts1, bolts1);
        System.out.println("Got: ");
        System.out.println("nuts1:" + Arrays.toString(nuts1) + " & " +
                "bolts:" + Arrays.toString(bolts1));

    }
    
    public static void solve(int[] nuts, int[] bolts) {
        sortAUsingB(nuts, bolts);
        sortAUsingB(bolts, nuts);
    }
    
    public static void sortAUsingB(int[] A, int[] B) {
        // The sorting can be done in-place
        for (int i = 0; i < B.length; i++) {
            int currB = B[i];
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            int matchingIndexOfA = -1;
            for (int j = 0; j < A.length; j++) {
                int currA = A[j];
                if (currA < currB) {
                    left.add(currA);
                } else if (currA > currB) {
                    right.add(currA);
                } else {
                    matchingIndexOfA = j;
                }
            }
            int k = 0;
            for (int m : left) {
                A[k++] = m;
            }
            A[k++] = A[matchingIndexOfA];
            for (int n : right) {
                A[k++] = n;
            }
        }

    }

    public static void solve1(int[] nuts, int[] bolts) {
        // typical O(N^2)
        for (int i = 0; i < nuts.length; i++) {
            int nut = nuts[i];
            for (int j = 0; j < bolts.length; j++) {
                int bolt = bolts[j];
                if (nut == bolt) {
                    swapNuts(nuts, i, j);
                }
            }
        }
    }

    public static void swapNuts(int[] nuts, int i, int j) {
        int temp = nuts[i];
        nuts[i] = nuts[j];
        nuts[j] = temp;
    }
}
