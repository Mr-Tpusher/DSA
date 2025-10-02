package dsa_2024_25.sorting;
/*
* The Insertion Sort algorithm uses one part of the array to hold the sorted values,
* and the other part of the array to hold values that are not sorted yet.

* The algorithm takes one value at a time from the unsorted part of the array
* and puts it into the right place in the sorted part of the array, until the array is sorted.

* How it works:
    1. Take the first value from the unsorted part of the array.
    2. Move the value into the correct place in the sorted part of the array.
    3. Go through the unsorted part of the array again as many times as there are values.

*
* */
import util.Timer;

import java.util.ArrayList;
import java.util.Arrays;


public class InsertionSort {
    public static void main(String[] args) {
        // Consider we are receiving elements one by one
        int[] A = {64, 34, 25, 12, 22, 11, 90, 5};

        Timer timer = new Timer();
        timer.start();
        sort(A);
        timer.stop();
        System.out.println("Time elapsed(Insertion sort using Linear Search):" + timer.getElapsedTime());
        System.out.println(Arrays.toString(A));


    }

    public static void sort(int[] A) {
        int length = A.length;
        // If there's only one element, it will be automatically sorted, hence we start from the second.
        for (int i = 1; i < length; i++) {
            int currValue = A[i];

            // Find right position for current element in the sorted/left part using linear search
            int j = i - 1;
            while (j >= 0 && A[j] > currValue) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = currValue;
        }
    }
}
