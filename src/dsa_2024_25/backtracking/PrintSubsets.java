package dsa_2024_25.backtracking;

import java.util.ArrayList;

/*
 * Given an array, print all the subsets,
 * that have sum < 5.
 */
public class PrintSubsets {
    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 4, 5}; // Regular test case
        int[] A2 = {643, 7, 1008};       // All elements > 5
        int[] A3 = {1, 1, 1, 1};    // Multiple identical elements
        int[] A4 = {};              // Empty array

        System.out.println("Test case 1:");
        printSubsets(A1, 0, new ArrayList<>(), 0);
        System.out.println("Test case 2:");
        printSubsets(A2, 0, new ArrayList<>(), 0);
        System.out.println("Test case 3:");
        printSubsets(A3, 0, new ArrayList<>(), 0);
        System.out.println("Test case 4:");
        printSubsets(A4, 0, new ArrayList<>(), 0);
    }


    public static void printSubsets(int[] A, int index, ArrayList<Integer> subset, int sum) {
        if (index == A.length) {
            if (sum < 5) {
                System.out.println(subset);
                return;
            }
        }

        if (sum >= 5) {
            return;
        }

        // Check all possibilities
        // 1. Do not add current element
        printSubsets(A, index + 1, subset, sum);

        // 2. Add current element
        subset.add(A[index]);
        printSubsets(A, index + 1, subset, sum + A[index]);

        // Backtrack
        subset.remove(subset.size() - 1);
    }
}
