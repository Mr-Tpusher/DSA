package dsa_2024_25.hashing;

import java.util.HashMap;

/*
* Given an input array and a query array, return frequency of query element in the
* input array.
* */
public class FrequencyQueries {
    public static void main(String[] args) {
        int[] A = {3, 4, 8, 4, 3, 2, 2, 3, 4, 9, 7};
        int[] queries = {4, 3, 8, 9, 7, 11};
       frequencyQueries(A, queries);

    }

    public static void frequencyQueries(int[] A, int[] Q) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int f = freq.getOrDefault(A[i], 0) + 1;
            freq.put(A[i], f);
        }

        for (int i = 0; i < Q.length; i++) {
            int f = 0;
            if (freq.containsKey(Q[i])) {
                f = freq.get(Q[i]);
            }
            System.out.println(Q[i] + ":" + f);
        }
    }
}
