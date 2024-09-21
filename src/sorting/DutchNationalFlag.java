package sorting;

import java.util.Arrays;

import static util.Array.swap;

/*
* Given an array, which contains only 3 elements 0,1,2; sort the array.
* int[] A = {1, 0, 0, 2, 1, 0, 2};
*
* */
public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] A = {1, 0, 0, 2, 1, 0, 2, 2, 0, 1, 1};
        System.out.println(Arrays.toString(A));
        solve(A);
        System.out.println(Arrays.toString(A));

        test();

    }

    public static void solve1(int[] A) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < A.length; i++) {
            int ele = A[i];
            if (ele == 0) count0++;
            else if (ele == 1) count1++;
            else count2++;
        }
        int j = 0, k = 0;
        while (k < count0) A[k++] = 0;
        while (k < count0+count1) A[k++] = 1;
        while (k < count0+count1+count2) A[k++] = 2;
    }

    public static void solve(int[] A) {
        int left = 0, right = A.length - 1;
        int curr = 0;

        while (curr <= right) {
            int currEle = A[curr];
            if (currEle == 0) {
                swap(A, left, curr);
                curr++;
                left++;
            } else if (currEle == 1) {
                curr++;
            } else {
                swap(A, right, curr);
                right--;
            }
        }
    }

    public static void test() {
        int[][] testCases = {
                {2, 0, 1, 2, 0, 1, 0},
                {0, 1, 2, 0, 1, 2, 1},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {0, 0, 0, 0, 0},
                {0, 1, 2},
                {2, 0, 0, 1, 1},
                {1, 0, 2, 1, 0, 2},
                {},
                {1},
                {0},
                {2}
        };

        int[][] expectedResults = {
                {0, 0, 0, 1, 1, 2, 2},
                {0, 0, 1, 1, 1, 2, 2},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {0, 0, 0, 0, 0},
                {0, 1, 2},
                {0, 0, 1, 1, 2},
                {0, 0, 1, 1, 2, 2},
                {},
                {1},
                {0},
                {2}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            solve(testCase);
            System.out.println("Test case " + (i + 1) + ": " + Arrays.toString(testCase) +
                    " | Expected: " + Arrays.toString(expectedResults[i]) +
                    " | Passed: " + Arrays.equals(testCase, expectedResults[i]));
        }
    }
}


