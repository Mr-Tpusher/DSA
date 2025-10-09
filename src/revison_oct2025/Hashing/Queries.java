package revison_oct2025.Hashing;

import java.util.Arrays;
import java.util.HashMap;

/*
* Given a array and Q queries, answer those queries.
* */
public class Queries {
    public static void main(String[] args) {

        int[] A = {2, 3, 5, 3, 3, 1, 5};
        int[] queries = {1, 2, 3};

        // brute force
        int[] answer = bruteForce(A, queries);
        System.out.println(Arrays.toString(answer));

        // count sort
        int[] answer2 = countSort(A, queries);
        System.out.println(Arrays.toString(answer2));

        // Hashing
        int[] answer3 = hashing(A, queries);
        System.out.println(Arrays.toString(answer3));

    }

    static int[] bruteForce(int[] A, int[] queries) {
        int[] answer = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == queries[q]) {
                    count++;
                }
            }
            answer[q] = count;
        }
        return answer;
    }

    static int[] countSort(int[] A, int[] queries) {
        // get the range
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(A[i], max);
        }

        int[] countArray = new int[max + 1];
        for (int i = 0; i < A.length; i++) {
            countArray[A[i]]++;
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = countArray[queries[i]];
        }
        return answer;
    }

    static int[] hashing(int[] A, int[] queries) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int frequency = frequencyMap.getOrDefault(A[i], 0);
            frequencyMap.put(A[i], ++frequency);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = frequencyMap.getOrDefault(queries[i], 0);
        }
        return answer;
    }
}
