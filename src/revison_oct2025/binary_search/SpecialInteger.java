package revison_oct2025.binary_search;

import java.util.Arrays;

/*
 * Given an array A, and an integer sum, find out max size k where no sub-array of size k
 * has a sum greater than k. all A[i] >= 0.
 * A = {1,20,3,7}, k = 25.
 *
 *
 * */
public class SpecialInteger {
    public static void main(String[] args) {
        System.out.println(solveUsingBinarySearch(new int[]{1,20,3,7}, 25, 1, 4));
    }

    static int bruteForce(int[] A, int k) {
        int answer = 0;

        f1:
        for (int size = 1; size <= A.length; size++) {
            for (int i = 0; i <= A.length - size; i++) {
                int curSubArraySum = 0;
                for (int j = i; j < i + size; j++) {
                    curSubArraySum += A[j];
                    if (curSubArraySum > k) {
                        break f1;
                    }
                }
            }
            answer = size;
        }
        return answer;
    }

    // sliding window for finding the subarray
    static int bruteForce2(int[] A, int k) {
        int answer = 0;

        f1:
        for (int size = 1; size <= A.length; size++) {
            for (int i = 0; i <= A.length - size; i++) {
                int curSubArraySum = 0;
                for (int j = i; j < i + size; j++) {
                    curSubArraySum += A[j];
                    if (curSubArraySum > k) {
                        break f1;
                    }
                }
            }
            answer = size;
        }
        return answer;
    }

    static int solveUsingBinarySearch(int[] arr, int k, int start, int end) {

        int answer = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(arr, mid, k)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    // feasibility check using binary search
    static boolean isFeasible(int[] arr, int size, int k) {

        int subArraySum = 0;
        for (int i = 0; i < size; i++) {
            subArraySum += arr[i];
            if (subArraySum > k)
                return false;
        }
        int i = 1, j = size;
        while (j < arr.length) {
            subArraySum += arr[j];
            subArraySum -= arr[i - 1];
            if (subArraySum > k) {
                return false;
            }
                i++;
                j++;
        }
        return true;
    }
}
