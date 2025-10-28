package revision_oct2025.Hashing;

import java.util.HashMap;

/*
* Given an array, find the length of largest subarray with sum = 0
*
*
* */
public class LargestSubArrayWithSumZero {
    public static void main(String[] args) {
        System.out.println(bruteForce(new int[] {1,-2,2,-4,0,4}));
        System.out.println(bruteForce(new int[] {-2,2,4,0,-4}));
        System.out.println(hashingSolution(new int[] {1,-2,2,-4,0,4}));
        System.out.println(hashingSolution(new int[] {-2,2,4,0,-4}));
    }

    static int bruteForce(int[] A) {
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
           int sum = 0;
            for (int j = i; j <A.length; j++) {
               sum += A[j];
               if (sum == 0) {
                   answer = Math.max(answer, j - i + 1);
               }
            }
        }
        return  answer;
    }

    // use prefix sum
    // A =  {1,-2,2,-4,0,4}
    // ps = {1,-1,1,-3,-3,1}
    static int hashingSolution(int[] A) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        // an empty array also has sum = 0
        prefixSumMap.put(-0, -1);

        int answer = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < A.length; i++) {
            currSum += A[i];
            if (prefixSumMap.containsKey(currSum)) {
                answer = Math.max(answer, i - prefixSumMap.get(currSum));
            } else {
                prefixSumMap.put(currSum, i);
            }
        }
        return answer;
    }
}
