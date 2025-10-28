package revision_oct2025.backtracking;

import java.util.ArrayList;

public class AllSubsetsWithSumLessThanK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        // backtrack1
        ArrayList<Integer> subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        backtrack(arr, 0, subset, allSubsets, 5, 0);
        System.out.println(allSubsets);

    }

    public static void backtrack(int[] arr, int index, ArrayList<Integer> subset,
                                 ArrayList<ArrayList<Integer>> allSubsets, int k, int sum) {

        // Pruning
        if (sum > k) {
            return;
        }

        if (index == arr.length) {

            allSubsets.add(new ArrayList<>(subset));
            return;
        }
        backtrack(arr, index + 1, subset, allSubsets, k, sum);
        subset.add(arr[index]);
        backtrack(arr, index + 1, subset, allSubsets, k, sum + arr[index]);
        subset.remove(Integer.valueOf(arr[index]));
    }

}
