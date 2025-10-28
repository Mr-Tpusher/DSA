package revision_oct2025.two_pointers;

import java.util.Arrays;

/*
* Given a sorted array of distinct positive numbers and given a number k,
* return all pairs such that A[i] - A[j] = k.
* arr = {1, 4, 9, 15, 20, 21, 24, 27} , k = 3
*
* pairs = {1,4} {21,24}, {24,27}
*
* */
public class KDifference {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 15, 20, 21, 24, 27};
        int k = 3;

        test(arr, k, 3);

        test(new int[] {}, 10, 0);

        test(new int[]{0, 5, 10, 15, 20, 25}, 5, 5);
    }

    static int bruteForce(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == k) {
                    count++;
                }

            }
        }
        return count;
    }

    static int solve(int[] arr, int k) {
        int count = 0;
        int i = 0, j = 1;
        while (j < arr.length) {
            int diff = arr[j] - arr[i];
            if (diff == k) {
                count++;
                i++;
                j++;
            }
            if (diff < k) {
                j++;
            }
            if (diff > k) {
                i++;
            }
        }
        return count;
    }

    static void test(int[] arr, int k, int expectedOutput) {
        System.out.println("Input array:" + Arrays.toString(arr) + ", k = " + k);
        System.out.println("expected output = " + expectedOutput);
        //int count = bruteForce(arr, k);
        int count = solve(arr, k);
        System.out.println("Actual   output = " + count);
        System.out.println("-------------------------");

    }
}
