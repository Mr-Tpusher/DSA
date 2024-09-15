package sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Given an array where
* a. All the odd elements are sorted
* b. All the even elements are sorted
* you have to sort the array.
*
* */
public class OddEvenSorted {
    public static void main(String[] args) {
        int[] A = {3, 7, 2, 9, 11, 4, 15, 10, 22, 19, 21};
        int evenCount = 0, oddCount = 0;

        System.out.println("input:  " + Arrays.toString(A));

        for (int n : A) {
            if ((n & 1) == 0) evenCount++;
            else oddCount++;
        }

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];
        int evenIndex = 0, oddIndex = 0;

        for (int n: A) {
            if ((n & 1) == 0) even[evenIndex++] = n;
            else odd[oddIndex++] = n;
        }
        System.out.println("Even:" + Arrays.toString(even));
        System.out.println("Odd:" + Arrays.toString(odd));

        // Merge
        int i = 0, j = 0, k = 0;
        while (i < even.length && j < odd.length) {
            if (even[i] < odd[j]) A[k++] = even[i++];
            else A[k++] = odd[j++];
        }

        // Copy remaining elements
        while (i < even.length) {
            A[k++] = even[i++];
        }

        while (j < odd.length) {
            A[k++] = odd[j++];
        }

        System.out.println("Output: " + Arrays.toString(A));
    }
}

