package revison_oct2025.recursion;

import java.util.ArrayList;

public class AllSubsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> allSubsets = getAllSubsets(arr, arr.length - 1);
        System.out.println(allSubsets);

    }

    public static ArrayList<ArrayList<Integer>> getAllSubsets(int[] arr, int index) {
        if (index < 0) {
            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<ArrayList<Integer>> ss = new ArrayList<>();
            ss.add(al);
            return ss;
        }

        // get subsets for (index - 1)th element
        ArrayList<ArrayList<Integer>> subsets = getAllSubsets(arr, index - 1);

        // append the current element to all the subsets
        ArrayList<ArrayList<Integer>> currAllSubsets = new ArrayList<>(subsets);

        for (ArrayList<Integer> al : subsets) {
            ArrayList<Integer> curSubset = new ArrayList<>(al);
            al.add(arr[index]);
            currAllSubsets.add(curSubset);
        }

        return currAllSubsets;
    }
}
