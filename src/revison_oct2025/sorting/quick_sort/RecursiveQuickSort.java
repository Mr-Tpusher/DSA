package revison_oct2025.sorting.quick_sort;

import java.util.Arrays;

public class RecursiveQuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 5, 1, 6, 3};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));

    }

    static void quickSort(int[] arr) {

        if (arr.length <= 1) {
            return;
        }

        // pick a pivot element
        int pivot = arr[0];

        // create two arrays
        // leftArray -> for all the elements lying on left of the pivot
        // rightArray -> for all the elements lying on right of the pivot
        int leftArraySize = 0;
        int rightArraySize = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pivot) {
                leftArraySize++;
            } else {
                rightArraySize++;
            }
        }

        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];


        for (int i = 1, j = 0, k = 0; i < arr.length; i++) {
            if (arr[i] < pivot) {
                leftArray[j++] = arr[i];
            } else {
                rightArray[k++] = arr[i];
            }
        }

        // recursively sort left and right arrays and then merge
        quickSort(leftArray);
        quickSort(rightArray);

        // merge the arrays now
        int i = 0;
        for (int element : leftArray) {
            arr[i++] = element;
        }
        arr[i++] = pivot;
        for (int element : rightArray) {
            arr[i++] = element;
        }

    }
}
