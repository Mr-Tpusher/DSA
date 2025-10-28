package revision_oct2025.backtracking;

import java.util.ArrayList;

public class AllSubsets {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2};

        // backtrack1
        ArrayList<Integer> subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        backtrack(arr, 0, subset, allSubsets);
        System.out.println(allSubsets);

        // backtrack1
        ArrayList<Integer> subset2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allSubsets2 =  backtrack2(arr, 0, subset2, new ArrayList<>());
        System.out.println(allSubsets2);

    }

    public static void backtrack(int[] arr, int index, ArrayList<Integer> subset,
                                 ArrayList<ArrayList<Integer>> allSubsets) {

        if (index == arr.length) {
            allSubsets.add(new ArrayList<>(subset));
            return;
        }

        backtrack(arr, index + 1, subset, allSubsets);
        subset.add(arr[index]);
        backtrack(arr, index + 1, subset, allSubsets);
        subset.remove(Integer.valueOf(arr[index]));
    }

    public static ArrayList<ArrayList<Integer>> backtrack2(int[] arr, int index, ArrayList<Integer> subset,
                                 ArrayList<ArrayList<Integer>> allSubsets) {

        if (index == arr.length) {
            allSubsets.add(subset);
            return allSubsets;
        }

        backtrack2(arr, index + 1, new ArrayList<>(subset), allSubsets);

        ArrayList<Integer> al = new ArrayList<>(subset);
        al.add(arr[index]);

        backtrack2(arr, index + 1, al, allSubsets);

        return allSubsets;
    }
}
