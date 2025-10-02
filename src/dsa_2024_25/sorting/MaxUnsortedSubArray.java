package dsa_2024_25.sorting;

import java.util.Arrays;

/*
* Given an array A of non-negative integers of size N. Find the minimum sub-array
* Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array,
* then the whole array should get sorted. If A is already sorted, output -1
* int[] A = {1, 3, 2, 4, 5};
 * */
public class MaxUnsortedSubArray {
    public static void main(String[] args) {
        // int[] A = {1, 3, 2, 4, 5, 8, 6};
        // int[] A = {1,3,2,4,5};
        // int[] A = {1 ,2, 3};
        // int[] A = {1,1,10,10,15,10,15,10,10,15,10,15};
        //int[] A = {3,3,4,5,5,9,11,13,14,15,15,16,15,20,16};
        int[] A = {1,2,3,5,6,13,15,16,17,13,13,15,17,17,17,17,17,19,19};
        System.out.println(Arrays.toString(bruteForce(A)));
        System.out.println(Arrays.toString(minSubArray(A)));

    }

    public static int[] bruteForce(int[] A) {
        int length = A.length;
        int[] temp = Arrays.copyOf(A, length);
        Arrays.sort(temp);
        int startIndex = -1, endIndex = -1;
        for (int i = 0; i < length; i++) {
            if (A[i] != temp[i]) {
                if (startIndex == -1) {
                    startIndex = i;
                } else {
                    endIndex = i;
                }
            }
        }
        return startIndex == -1 ? new int[] {-1} : new int[] {startIndex, endIndex};
    }

    public static int[] minSubArray(int[] A) {
        int length = A.length;
        int probableStartIndex = 0, probableEndIndex = length - 1;
        // probable starting point of the sub-array
        while (probableStartIndex < length - 1) {
            if (A[probableStartIndex] <= A[probableStartIndex + 1]) {
                probableStartIndex++;
            } else {
                break;
            }
        }
        // probable ending point of the sub-array
        while (probableEndIndex > 0) {
            if (A[probableEndIndex] >= A[probableEndIndex - 1]) {
                probableEndIndex--;
            } else {
                break;
            }
        }
        // the sub-array could span from probableStartIndex to probableEndIndex
        if (probableStartIndex == length - 1) {
            return new int[] {-1};
        }

        /*
        * all the elements on the left of sub-array should be less than the min of the sub-array
        * and the elements on the right should be greater than max of the sub-array
        *
        */
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = probableStartIndex; k <= probableEndIndex; k++) {
            if (A[k] < min) {
                min = A[k];
            }
            if (A[k] > max) {
                max = A[k];
            }
        }
        int startIndex = 0;
        //int endIndex = probableEndIndex + 1;
        int endIndex = (probableEndIndex == length - 1 ? probableEndIndex : probableEndIndex + 1);
        while (startIndex < probableStartIndex) {
            if (A[startIndex] <= min) {
                startIndex++;
            } else {
                break;
            }
        }
        while (endIndex < length) {
            if (A[endIndex] < max) {
                endIndex++;
            } else {
                break;
            }
        }

        return endIndex == 0 ? new int[] {-1} : new int[] {startIndex, endIndex - 1};
    }
}
