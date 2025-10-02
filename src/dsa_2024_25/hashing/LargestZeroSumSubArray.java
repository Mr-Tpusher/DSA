package dsa_2024_25.hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LargestZeroSumSubArray {
    public static void main(String[] args) {
        test();
        //int[] A = {1, 2, 3, 2, 1, 6, 3, -3, -6};
        //System.out.println(largestZeroSumSubArray(A));

    }

    public static int largestZeroSumSubArray(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        int max = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        for (int i = 0; i < prefixSum.length; i++) {
            int curr = prefixSum[i];
            if (prefixSumMap.containsKey(curr)) {
                int firstOcc = prefixSumMap.get(curr);
                max = Math.max(max, i - firstOcc);
            } else {
                prefixSumMap.put(curr, i);
            }
        }
        return max;
    }


    public static int bruteForce1(int[] A) {
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int[] subArray = new int[j - i + 1];
                int sum = 0;
                for (int k = i, x=0; k <= j ; k++, x++) {
                    sum += A[k];
                    subArray[x] = A[k];
                }
                if (sum == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
                //System.out.print("subArray:" + Arrays.toString(subArray) + ",  ");
                //System.out.println("sum=" + sum);
            }
        }
        return ans;

    }

    public static int bruteForce2(int[] A) {
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i, k = 0; j < A.length; j++, k++) {
                sum += A[j];
                if (sum == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
                //System.out.println("sum=" + sum);
            }
        }
        return ans;

    }


    public static void test() {
        int[][] A = {
                {},
                {1, 2},
                {1, 2, 2},
                {1, 2, 3, 2, 1, 6, 3, -3, -6},
                {1, -2, 0, 2, 1, 6, 3, 2, 6},
                {1, -2, 0, -3, 1, 6, 3, 1, -6},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -55}
        };

        int[] expectedOutput = {
                0,
                0,
                0,
                4,
                3,
                8,
                11
        };

        for (int i = 0; i < A.length; i++) {
            //int diff = bruteForce1(A[i]);
            //int diff = bruteForce2(A[i]);
            int diff = largestZeroSumSubArray(A[i]);
            boolean verdict = expectedOutput[i] == diff;
            String result = verdict ? "Passed" : "Failed";

            System.out.print("Input:" + Arrays.toString(A[i]) + ",  ");
            System.out.print("Expected:" + expectedOutput[i] + ",  ");
            System.out.println("got:" + diff);
            System.out.println(result);
        }
    }
}
