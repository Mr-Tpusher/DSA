package dsa_2024_25.permutations;
/*
 * Given a permutation, give it's rank,
 * when duplicates are present
 * */

import dsa_2024_25.util.Number;
import dsa_2024_25.util.ValueFrequency;

import java.util.ArrayList;

public class PermutationRank2 {
    public static void main(String[] args) {
        // Test Case 1: Basic Case with Distinct Elements
        int[] testCase1 = {1, 2, 3};
        System.out.println("Test Case 1 - Expected: 1, Got: " + getRank(testCase1));

        // Test Case 2: Duplicate Elements
        int[] testCase2 = {1, 1, 2};
        System.out.println("Test Case 2 - Expected: 1, Got: " + getRank(testCase2));

        // Test Case 3: All Elements are the Same
        int[] testCase3 = {2, 2, 2};
        System.out.println("Test Case 3 - Expected: 1, Got: " + getRank(testCase3));

        // Test Case 4: Duplicates in the Middle
        int[] testCase4 = {1, 2, 3, 2};
        System.out.println("Test Case 4 - Expected: 2, Got: " + getRank(testCase4));

        // Test Case 5: Larger Array with Mixed Duplicates
        int[] testCase5 = {3, 1, 2, 1};
        System.out.println("Test Case 5 - Expected: 11, Got: " + getRank(testCase5));

        // Test Case 6: Larger Array with Mixed Duplicates
        int[] testCase6 = {4, 1, 3, 5};
        System.out.println("Test Case 5 - Expected: 13, Got: " + getRank(testCase6));

    }

    public static int getRank(int[] A) {
        ArrayList<ValueFrequency> vf = ValueFrequency.generateValueFrequency(A);
        int rank = 1;

        for (int i = 0; i < A.length; i++) {
            int element = A[i];

            for (int j = 0; j < vf.size(); j++) {
                ValueFrequency vfElement = vf.get(j);
                int value = vfElement.getValue();
                int freq = vfElement.getFrequency();

                if (value < element) {

                    if (freq <= 0) {
                        continue;
                    }
                    // temp freq update
                    vfElement.setFrequency(freq - 1);

                    // calculate divisor
                    int divisor = 1;
                    for (int k = 0; k < vf.size(); k++) {
                        ValueFrequency vfk = vf.get(k);
                        int f = vfk.getFrequency();
                        divisor *= Number.factorial(f);
                    }

                    // Rank Contribution
                    int rankContribution = Number.factorial(A.length - i - 1) / divisor;
                    rank += rankContribution;

                    // restore freq
                    vfElement.setFrequency(freq);

                } else if (value == element) {
                    vfElement.setFrequency(freq - 1);
                    break;
                } else {
                    break;
                }
            }
        }
        return rank;
    }
}
