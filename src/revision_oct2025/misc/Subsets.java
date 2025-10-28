package revision_oct2025.misc;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        ArrayList<ArrayList<Integer>> allSubsets = generateSubsetsUsingRecursion(A, 2);
        //System.out.println(allSubsets);

        printSubsetsUsingBacktracking(A, 0, new ArrayList<>());

    }

    static ArrayList<ArrayList<Integer>> generateSubsetsUsingRecursion(int[] A, int index) {
        if (index < 0) {
            ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
            ArrayList<Integer> al = new ArrayList<>();
            allSubsets.add(al);
            return allSubsets;
        }

        ArrayList<ArrayList<Integer>> subsets = generateSubsetsUsingRecursion(A, index - 1);
        ArrayList<ArrayList<Integer>> subsetWithCurrentElement = new ArrayList<>(subsets);

        for (ArrayList<Integer> subset : subsets) {
            ArrayList<Integer> currSubset = new ArrayList<>(subset);
            currSubset.add(A[index]);
            subsetWithCurrentElement.add(currSubset);
        }

        return subsetWithCurrentElement;

    }

    static void printSubsetsUsingBacktracking(int[] A, int index, ArrayList<Integer> ss) {
        if (index == A.length) {
            System.out.println(ss);
            return;
        }

        printSubsetsUsingBacktracking(A, index + 1, ss);
        ss.add(A[index]);
        printSubsetsUsingBacktracking(A, index + 1, ss);
        ss.remove(ss.size() - 1);
    }

}
