package hashing;

import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers, find Max(abs|i-j|)
* such that A[i]==A[j] and i!=j
* */
public class MaxDifference {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 7, 6, 3, 2, 1};
        System.out.println(bruteForce(A));
        System.out.println(maxDiffUsingTwoHashmaps(A));

    }

    public static int bruteForce(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int currMax = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    currMax = Math.max(currMax, j - i);
                }
            }
            max = Math.max(max, currMax);
        }
        return max;
    }

    public static int maxDiffUsingTwoHashmaps(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        HashMap<Integer, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int curr = A[i];
            if (! firstOccurrence.containsKey(A[i])) {
                firstOccurrence.put(curr, i);
            }
            lastOccurrence.put(curr, i);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> e: firstOccurrence.entrySet()) {
            int first = e.getValue();
            int last = lastOccurrence.get(e.getKey());
            max = Math.max(max, last - first);
        }
        return max;
    }
}
