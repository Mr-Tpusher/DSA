package dsa_2024_25.recursion;

import java.util.ArrayList;

/*
* Find all subsets of a given array
* */
public class AllSubsets {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        ArrayList<ArrayList<Integer>> subsets = subsets1(A, A.length);

        System.out.print("{");
        for (ArrayList<Integer> al : subsets) {
            System.out.print("{");
            for (Integer i : al) {
                System.out.print(i);
                if (i != al.get(al.size() - 1)) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
            if (!al.equals(subsets.get(subsets.size() - 1))) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }


    public static ArrayList<ArrayList<Integer>> subsets1(int[] A, int N) {

        if (N == 0) {
            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<ArrayList<Integer>> ss = new ArrayList<ArrayList<Integer>>();
            ss.add(al);
            return ss;
        }
        ArrayList<ArrayList<Integer>> allSubsets = subsets1(A, N - 1);

        ArrayList<ArrayList<Integer>> currSubsets = new ArrayList<>(allSubsets);
        for (ArrayList<Integer> ss : allSubsets) {
            //currSubsets.add(ss);
            ArrayList<Integer> ss2 = new ArrayList<>(ss);
            ss2.add(A[N - 1]);
            currSubsets.add(ss2);
        }

        return currSubsets;
    }
}

