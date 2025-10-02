package dsa_2024_25.dynamic_programming;

import java.util.ArrayList;

/*
* Given an integer array, find the largest increasing subsequence.
* A = {0, 8, 4, 12, 10, 6, 14, 1, 9, 5, 13}
* Answer: {0, 4, 6, 9, 13} = 5
*
* */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A = {0, 8, 4, 12, 10, 6, 14, 1, 9, 5, 13, 14, 15 ,16, 17};
        System.out.println(bruteForce(A));
        System.out.println(solve(A));

    }

    public static int solve(int[] A) {
        int[] LIS = new int[A.length];
        LIS[0] = 1;

        for (int i = 1; i < A.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    int currMax = 1 + LIS[j];
                    max = Math.max(max, currMax);
                }
            }
            LIS[i] = max;
        }

        int ans = 0;
        for (int i = 0; i < LIS.length; i++) {
            ans = Math.max(ans, LIS[i]);
        }
        return ans;
    }

    public static int bruteForce(int[] A) {
        ArrayList<ArrayList<Integer>> subSequences = new ArrayList<>();
        bruteForce(A, 0, new ArrayList<>(), subSequences);

        int max = Integer.MIN_VALUE;
        for (ArrayList<Integer> sub : subSequences) {
            if (isIncreasing(sub)) {
                max = Math.max(max, sub.size());
                //System.out.println(sub);
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
            return;
        }

        subSeq.add(A[index]);
        bruteForce(A, index + 1, subSeq, subSequences);
        subSeq.remove(subSeq.size() - 1);
        bruteForce(A, index + 1, subSeq, subSequences);
    }
}
