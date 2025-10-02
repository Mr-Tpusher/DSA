package backtracking;

import java.util.ArrayList;

public class GenerateSubsets {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};

        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();

        backtrack(A, 0, new ArrayList<>(), allSubsets);

        for (ArrayList<Integer> al : allSubsets) {
            System.out.println(al);
        }
    }

    public static void backtrack(int[] A, int index, ArrayList<Integer> currentSubset,
                                 ArrayList<ArrayList<Integer>> allSubsets) {

        if (index == A.length) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        backtrack(A, index + 1, currentSubset, allSubsets);

        currentSubset.add(A[index]);

        backtrack(A, index + 1, currentSubset, allSubsets);

        currentSubset.remove(currentSubset.size() - 1);
    }
}

