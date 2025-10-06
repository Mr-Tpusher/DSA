package revison_oct2025.sorting;

import java.util.Arrays;

public class MergeSort1 {
    public static void main(String[] args) {
        int[] arr = {8, 6, 7, 3, 1, 2, 5, 4, 0, 9};
        System.out.println("input array: " + Arrays.toString(arr));
        int[] mergedArr = mergeSort(arr);
        System.out.println(Arrays.toString(mergedArr));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            System.out.println("Array length is 1, base condition hit, returning");
            System.out.println(Arrays.toString(arr));
            return arr;
        }

        // split the input array into 2 arrays
        int mid = (arr.length - 1) / 2;
        int[] arr1 = new int[mid + 1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        int[] arr2 = new int[(arr.length - 1) - mid];
        for (int i = 0, j = mid + 1; i < arr2.length; i++, j++) {
            arr2[i] = arr[j];
        }
        System.out.println("splitted arrays:");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int[] sortedArr1 = mergeSort(arr1);
        int[] sortedArr2 = mergeSort(arr2);

        System.out.println("Sorted Arrays:");
        System.out.println(Arrays.toString(sortedArr1));
        System.out.println(Arrays.toString(sortedArr2));

        int[] sortedArr = mergeArrays(sortedArr1, sortedArr2);
        System.out.println("merged array: " + Arrays.toString(sortedArr));
        return sortedArr;

    }

    static int[] mergeArrays(int[] arr1, int[] arr2) {
        int i, j, k;
        i = j = k = 0;
        int[] sortedArr = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                sortedArr[k] = arr1[i];
                i++;
            } else {
                sortedArr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            sortedArr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            sortedArr[k] = arr2[j];
            j++;
            k++;
        }

        return sortedArr;
    }


}
