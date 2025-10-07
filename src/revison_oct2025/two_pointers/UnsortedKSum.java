package revison_oct2025.two_pointers;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/*
* Given an unsorted array of positive numbers, return true if there is some subarray of sum = k, else false.
* arr = {1, 4, 3, 10, 5, 20} , k = 17
* */
public class UnsortedKSum {
    public static void main(String[] args) {
        System.out.println(solve3(new int[]{1, 4, 3, 10, 5, 20}, 17));
        System.out.println(solve3(new int[]{2, -1, 2, -3, 4}, 3));

    }

    static boolean solve(int[] arr, int k) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int i = -1, j = 0;
        while (i < prefixSum.length && j < prefixSum.length) {
            int prevPrefixSum = i == -1 ? 0 : prefixSum[i];
            int subArraySum = prefixSum[j] - prevPrefixSum;
            if (subArraySum == k) {
                return true;
            } else if (subArraySum < k) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }

    static boolean solve2(int[] arr, int k) {
        int i = 0, j = 0;
        int currSum = 0;
        while (i < arr.length & j < arr.length) {
            currSum += arr[j];
            while (currSum > k) {
                currSum -= arr[i];
                i++;
            }
            if (currSum == k) {
                return true;
            }
            j++;
        }
        return false;
    }

    static boolean solve3(int[] arr, int k) {

        HashSet<Integer> prevPrefixSum = new HashSet<>();
        prevPrefixSum.add(0);

        int prefixSum = 0;
        for (int i : arr) {
            prefixSum += i;
            if (prevPrefixSum.contains(prefixSum - k)) {
                return true;
            }
            prevPrefixSum.add(prefixSum);
        }
        return false;
    }
}
