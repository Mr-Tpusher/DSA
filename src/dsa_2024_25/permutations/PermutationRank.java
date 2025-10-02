package dsa_2024_25.permutations;
/*
* Given a permutation, give it's rank.
* */

import util.Number;

import java.util.Arrays;

public class PermutationRank {
    public static void main(String[] args) {
        //int[] A = {4, 5, 1, 3};
        int[] A = {4, 1, 3, 5};

        System.out.println(getRank(A));
    }

    public static int getRank(int[] A) {
        int[] sortedA = Arrays.copyOf(A, A.length);
        Arrays.sort(sortedA);

        int rank = 1;
        for (int i = 0; i < A.length; i++) {
            int element = A[i];
            int count = 0;
            for (int j = 0; j < sortedA.length; j++) {
                if (sortedA[j] < element) {
                    count++;
                } else if (sortedA[j] == element) {
                    sortedA[j] = Integer.MAX_VALUE;
                } else {
                    break;
                }
            }
            int rankContribution = count * Number.factorial(A.length - i - 1);
            rank += rankContribution;
        }
        return rank;
    }

}
