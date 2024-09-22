package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers, A of length N denotes N cylindrical empty bottles. The radius of the ith bottle is A[i].
You can put the ith bottle into the jth bottle if the following conditions are met:

The ith bottle is not put into another bottle.
The jth bottle doesn't contain any other bottle.
The radius of bottle i is smaller than bottle j (A[i] < A[j]).
You can put bottles into each other any number of times. You want to MINIMIZE the number of visible bottles. A bottle is visible if it is not put into any other bottle.

Find and return the minimum number of visible bottles.



Problem Constraints
1 <= N <= 100000

1<= A[i] <= 100000000
* */
public class GameOfBottles {
    public static void main(String[] args) {
        int[] A = {4, 1, 2 , 5, 7};
        int[] B = {1, 2, 2, 4, 5, 7, 5};
        int[] C= {7};
        int[] D = {1, 4, 5, 7, 5, 4, 4 ,4, 4, 3, 7, 4};
        System.out.println("Test Case 1:");
        System.out.println("Expected: 1" + ", Got: " + solve(A));

        System.out.println("Test Case 2:");
        System.out.println("Expected: 2" + ", Got: " + solve(B));

        System.out.println("Test Case 3:");
        System.out.println("Expected: 1" + ", Got: " + solve(C));

        System.out.println("Test Case 4:");
        System.out.println("Expected: 6" + ", Got: " + solve(D));

    }

    public static int solve(int[] A) {
        // Use Hashmap : TC:O(N) , SC:O(N)
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int freq = freqMap.getOrDefault(A[i], 0);
            freqMap.put(A[i], ++freq);
        }
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            maxFreq = Math.max(maxFreq, e.getValue());
        }
        return maxFreq;
    }

    public static int solve3(int[] A) {
        // Utilise a count array : TC:O(N) , SC:O(N)
        int[] count = new int[100000000];
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }
        int maxFreq = 0;
        for (int i = 0; i < count.length; i++) {
            maxFreq = Math.max(maxFreq, count[i]);
        }
        return maxFreq;
    }

    public static int solve2(int[] A) {
        // Iterating over the input twice - O(N^2)
        int maxFreq = 0;
        for (int i = 0; i < A.length; i++) {
            int currElement = A[i];
            int currElementFreq = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (currElement == A[j]) {
                    currElementFreq++;
                }
            }
            maxFreq = Math.max(maxFreq, currElementFreq);
        }
        return maxFreq;
    }

    public static int solve1(int[] A) {
        // Sorting and calculating consecutive element frequency : O(N*Log(N))
        Arrays.sort(A);
        int maxFreq = 1;
        int currFreq = 1;
        int prevElement = A[0];
        for (int i = 1; i < A.length; i++) {
            int currElement = A[i];
            if (prevElement == currElement) {
                currFreq++;
            } else {
                maxFreq = Math.max(maxFreq, currFreq);
                prevElement = currElement;
                currFreq = 1;
            }
        }
        return maxFreq;
    }
}
