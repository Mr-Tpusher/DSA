package revision_oct2025.dynamic_programming.recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsWithoutAdjacent {
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 0, 7, 10};
        getAll(A);
    }

    static void getAll(int[] A) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        getAllHelper(A, 0, new ArrayList<>(), all);
        System.out.println(all);
    }

    static void getAllHelper(int[] A, int index, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> all) {
        //if (index > A.length) return;

        if (index >= A.length) {
            all.add(new ArrayList<>(curr));
            return;
        }


        // add current, skip next
        curr.add(A[index]);
        getAllHelper(A, index + 2, curr, all);

        // backtrack
        curr.remove(curr.size() - 1);

        // call without the current element
        getAllHelper(A, index + 1, curr, all);
    }


}
