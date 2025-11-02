package revision_oct2025.dynamic_programming.recursion_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* For a given array find all increasing subsequences
* */
public class AllIncreasingSubsequences {
    public static void main(String[] args) {
        //int[] A = {1, 7, 3, 7, 8, 5};
        int[] A = {4, 6, 7, 7};
        getAll1(A);
        getAll2(A);
    }

    static void getAll1(int[] A) {
        Set<List<Integer>> results = new HashSet<>();
        findAllUsingBinaryRecursion(A, 0, new ArrayList<>(), results);
        System.out.println(results);

    }

    static void getAll2(int[] A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        findAllUsingForLoopRecursion(A, 0, new ArrayList<>(), results);
        System.out.println(results);

    }

    static void findAllUsingBinaryRecursion(int[] A, int index, ArrayList<Integer> curr, Set<List<Integer>> results) {

        if (index == A.length) {
            results.add(new ArrayList<>(curr));
            return;
        }

        // include current
        if (curr.isEmpty() || curr.get(curr.size() - 1) <= A[index]) {
            curr.add(A[index]);
            findAllUsingBinaryRecursion(A, index + 1, curr, results);
            // backtrack
            curr.remove(curr.size() - 1);
        }

        // exclude current
        findAllUsingBinaryRecursion(A, index + 1, curr, results);

    }


    static void findAllUsingForLoopRecursion(int[] A, int index, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> results) {
        if (!curr.isEmpty()) {
            results.add(new ArrayList<>(curr));
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = index; i < A.length; i++) {
            if (curr.isEmpty() || (curr.get(curr.size() - 1) <= A[i] && !used.contains(A[i]))) {
                curr.add(A[i]);
                findAllUsingForLoopRecursion(A, i + 1, curr, results);
                curr.remove(curr.size() - 1);
                used.add(A[i]);
            }
        }
    }
}
