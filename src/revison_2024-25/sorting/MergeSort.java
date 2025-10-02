package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {9, 8, 7, 3, 6, 4, 1, 5};
        System.out.println("Input:" + Arrays.toString(A));
        mergeSort(A, 0, A.length - 1);
        System.out.println("Output:" +Arrays.toString(A));

    }

    public static void mergeSort(int[] A, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, end, mid);
        }
    }

    public static void merge(int[] A, int start, int end, int mid) {
        int leftArrayLength = mid - start + 1;
        int rightArrayLength = end - mid;
        int[] left = new int[leftArrayLength];
        int[] right = new int[rightArrayLength];
        System.arraycopy(A, start, left, 0, leftArrayLength);
        System.arraycopy(A, mid + 1, right, 0, rightArrayLength);
        int i = 0, j = 0, k = start;
        while (i < leftArrayLength && j < rightArrayLength) {
            if (left[i] < right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }
        while (i < leftArrayLength) {
            A[k++] = left[i++];
        }
        while (j < rightArrayLength) {
            A[k++] = right[j++];
        }
    }
}
