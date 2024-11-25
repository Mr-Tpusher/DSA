package dynamic_programming;

import java.util.ArrayList;

/*
* Given an integer array, find the largest increasing subsequence.
* A = {0, 8, 4, 12, 10, 6, 14, 1, 9, 5, 13}
* Answer: {0, 4, 6, 9, 13} = 5
*
* */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A = {0, 8, 4, 12, 10, 6, 14, 1, 9, 5, 13};
        System.out.println(bruteForce(A));

    }

    public static int bruteForce(int[] A) {
        ArrayList<ArrayList<Integer>> subSequences = new ArrayList<>();
        bruteForce(A, 0, new ArrayList<>(), subSequences);

        int max = Integer.MIN_VALUE;
        for (ArrayList<Integer> sub : subSequences) {
            if (isIncreasing(sub)) {
                max = Math.max(max, sub.size());
                System.out.println(sub);
            }
        }
        return max;
    }

    private static boolean isIncreasing(ArrayList<Integer> sub) {
        for (int i = 1; i < sub.size(); i++) {
            if (sub.get(i - 1) > sub.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void bruteForce(int[] A, int index, ArrayList<Integer> subSeq,
                                  ArrayList<ArrayList<Integer>> subSequences) {
        if (index == A.length) {
            subSequences.add(new ArrayList<>(subSeq));
            //subSeq = new ArrayList<>();
            return;
        }

        subSeq.add(A[index]);
        bruteForce(A, index + 1, subSeq, subSequences);
        subSeq.remove(subSeq.size() - 1);
        bruteForce(A, index + 1, subSeq, subSequences);
    }
}
