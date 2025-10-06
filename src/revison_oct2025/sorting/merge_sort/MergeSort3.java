package revison_oct2025.sorting.merge_sort;

import java.util.Arrays;

public class MergeSort3 {
    public static void main(String[] args) {
        int[] arr = {8, 6, 7, 3, 1, 2, 5, 4, 0, 9};
        System.out.println("Before array: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After merge sort: " + Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int left, int right) {

        while (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            mergeArrays(arr, left, right, mid);
        }
    }

    static void mergeArrays(int[] arr, int start, int end, int mid) {
        int[] leftArr = new int[mid -start + 1];
        int[] rightArr = new int[end - mid];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[start + i];
        }

        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
}
