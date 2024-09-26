package hashing;

import java.util.Arrays;
import java.util.HashMap;

/*
* Given an array and multiple queries, in each query you are given a number,
* you have to tell how many times that number exists in the input array.
*
*
* */
public class ElementFrequency {
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 3, 3, 1, 5};
        int[] queries = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(bruteForce1(A, queries)));
        System.out.println(Arrays.toString(bruteForce2(A, queries)));
        System.out.println(Arrays.toString(freqUsingHashing1(A, queries)));
    }

    public static int[] bruteForce1(int[] A, int[] queries) {
        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int frequency = 0;
            for (int j = 0; j < A.length; j++) {
                if (queries[i] == A[j]) {
                    frequency++;
                }
            }
            output[i] = frequency;
        }
        return output;
    }

    public static int[] bruteForce2(int[] A, int[] queries) {
        Arrays.sort(A);
        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryElement = queries[i];
            int firstOcc = getFirstOccurrence(A, queryElement);
            int lastOcc = getLastOccurrence(A, queryElement);
            int freq = firstOcc == -1 ? 0 : lastOcc - firstOcc + 1;
            output[i] = freq;
        }
        return output;
    }

    public static int getFirstOccurrence(int[] A, int element) {
        int firstOccurence = -1;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = A[mid];
            if (midElement == element) {
                firstOccurence = mid;
                right = mid - 1;
            } else if (midElement < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstOccurence;
    }

    public static int getLastOccurrence(int[] A, int element) {
        int lastOccurrence = -1;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = A[mid];
            if (midElement == element) {
                lastOccurrence = mid;
                left = mid + 1;
            } else if (midElement < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastOccurrence;
    }

    public static int[] freqUsingHashing1(int[] A, int[] queries) {
        HashMap<Integer, Integer> firstOcc = new HashMap<>();
        HashMap<Integer, Integer> lastOcc = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int currElement = A[i];
            if (!firstOcc.containsKey(currElement)) {
                firstOcc.put(currElement, i);
            }
            lastOcc.put(currElement, i);
        }

        int[] output = new int[queries.length];
        int i = 0;
        for (int q : queries) {
            int first = firstOcc.getOrDefault(q, -1);
            int last = lastOcc.getOrDefault(q, -1);
            int freq = first == -1 ? 0 : last - first + 1;
            output[i++] = freq;
        }
        return output;
    }

}
