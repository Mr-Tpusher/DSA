package dsa_2024_25.backtracking;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        backtrack(A, 0, result);
    }

    public static void backtrack(int[] A, int index, ArrayList<ArrayList<Integer>> subsets) {

        if (index == A.length) {
            for (ArrayList<Integer> al : subsets) {
                System.out.println(al);
            }
            return;
        }

        backtrack(A, index + 1, subsets);

        for (ArrayList<Integer> al : subsets) {
            al.add(A[index]);
        }
        backtrack(A, index + 1, subsets);

        for (ArrayList<Integer> al : subsets) {
            al.remove(al.size() - 1);
        }
    }
}
