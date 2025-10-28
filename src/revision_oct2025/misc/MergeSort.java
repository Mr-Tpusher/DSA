package revision_oct2025.misc;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {5, 7, 10, 1, 6, 8, 2, 9, 3, 4};
        System.out.println("original array -> " + Arrays.toString(A));
        mergeSort(A, 0, A.length - 1);
        System.out.println("After sorting -> " + Arrays.toString(A));

    }

    static void mergeSort(int[] A, int start, int end) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        merge(A, start, mid, end);
    }

    static void merge(int[] A, int start, int mid, int end) {
        if (start == end) return;

        int[] first = new int[mid - start + 1];
        int[] second = new int[end - mid];
        for (int i = start, k = 0; i <= mid; i++, k++) {
            first[k] = A[i];
        }
        for (int i = mid + 1, k = 0; i <= end; i++, k++) {
            second[k] = A[i];
        }

        int i = 0, j = 0, k = start;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                A[k++] = first[i++];
            } else {
                A[k++] = second[j++];
            }
        }

        while (i < first.length) {
            A[k++] = first[i++];
        }
        while (j < second.length) {
            A[k++] = second[j++];
        }
    }
}
