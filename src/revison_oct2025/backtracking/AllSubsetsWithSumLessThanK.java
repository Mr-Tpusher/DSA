package revison_oct2025.backtracking;

import java.util.ArrayList;

public class AllSubsetsWithSumLessThanK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        // backtrack1
        ArrayList<Integer> subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        backtrack(arr, 0, subset, allSubsets, 5);
        System.out.println(allSubsets);

    }

    public static void backtrack(int[] arr, int index, ArrayList<Integer> subset,
                                 ArrayList<ArrayList<Integer>> allSubsets, int k) {

        if (index == arr.length) {
            int sum = 0;
            for (Integer i : subset) {
                sum += i;
                if (sum > k) {
                    return;
                }
            }
            allSubsets.add(new ArrayList<>(subset));
            return;
        }

        backtrack(arr, index + 1, subset, allSubsets, k);
        subset.add(arr[index]);
        backtrack(arr, index + 1, subset, allSubsets, k);
        subset.remove(Integer.valueOf(arr[index]));
    }

}
