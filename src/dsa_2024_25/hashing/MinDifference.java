package dsa_2024_25.hashing;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;

/*
 * Min(abs|i-j|) where A[i]==A[j] and i!=j
 * */
public class MinDifference {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1, 6, 3, 2, 1};
        //int[] A =  {1, 2};
        System.out.println(minDiffBruteForce(A));
        System.out.println(minDiffUsingMap(A));
        test();
    }

    public static int minDiffBruteForce(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    min = Math.min(min, j - i);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static int minDiffUsingMap(int[] A) {
        HashMap<Integer, Integer> prevOcc = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (prevOcc.containsKey(A[i])) {
                min = Math.min(min, i - prevOcc.get(A[i]));
            }
            prevOcc.put(A[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void test() {
        int[][] A = {
                {},
                {1, 2},
                {1, 2, 2},
                {1, 2, 3, 2, 1, 6, 3, 2, 1},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
        };

        int[] expectedOutput = {
                -1,
                -1,
                1,
                2,
                10
        };

        for (int i = 0; i < A.length; i++) {
            int diff = minDiffUsingMap(A[i]);
            boolean verdict = expectedOutput[i] == diff;
            String result = verdict ? "Passed" : "Failed";

            System.out.print("Input:" + Arrays.toString(A[i]) + ",  ");
            System.out.print("Expected:" + expectedOutput[i] + ",  ");
            System.out.println("got:" + diff);
            System.out.println(result);

        }

    }

}
