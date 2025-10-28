package revision_oct2025.sorting.quick_sort;

import java.util.Arrays;

public class InplaceQuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 5, 1, 6, 3};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sorting: " + Arrays.toString(arr));

    }

    static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        // pick a pivot element
        int pivot = arr[start];

        // logically create two partitions using 2 variables
        // i -> to find the correct position of the pivot in the array
        //      -> all the elements < pivot , lie on the left side of the array
        //      -> all the elements >= pivot , lie on the right side of the array
        // j -> just to iterate over the array and process the element

        // let's start both i and j at (start + 1) since our pivot index is 0th
        int i = start + 1;
        for (int j = start + 1; j <= end; j++) {
            if (arr[j] < pivot) {
                // swap the element first
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                // then increment
                i++;
            }
        }

        // put pivot in itxs correct position
        // swap the pivot with (i-1)th element, since elements on right are greater than or equals to pivot
        int temp = arr[i - 1];
        arr[i - 1] = arr[start];
        arr[start] = temp;

        // recursively sort left and right arrays and then merge
        quickSort(arr, start, i - 2);
        quickSort(arr, i , end);

    }
}
