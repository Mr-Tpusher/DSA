package revison_oct2025.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] A = {10, 4, 8, 1, 2, 9, 7, 3};
        System.out.println(Arrays.toString(selectionSort(A)));
        System.out.println(Arrays.toString(selectionSort2(A)));
        System.out.println(Arrays.toString(selectionSort3(A)));
    }

    static int[] selectionSort(int[] A) {
        if (A == null || A.length <= 1) return A;

        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = A[i];
                A[i] = A[minIndex];
                A[minIndex] = temp;
            }
        }
        return A;
    }

    static int[] selectionSort2(int[] A) {
        int indexToBeUpdated = A.length - 1;
        for (int i = 0; i <= indexToBeUpdated; i++) {
            int maxIndex = i;
            for (int j = i + 1; j <= indexToBeUpdated; j++) {
                maxIndex = A[j] > A[maxIndex] ? j : i;
            }
            // swap
            int temp = A[indexToBeUpdated];
            A[indexToBeUpdated] = A[maxIndex];
            A[maxIndex] = temp;
            indexToBeUpdated--;
        }
        return A;
    }

    static int[] selectionSort3(int[] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                maxIndex = A[j] > A[maxIndex] ? j : i;
            }
            if (maxIndex != i) {
                int temp = A[maxIndex];
                A[maxIndex] = A[i];
                A[i] = A[temp];
            }
        }
        return A;
    }
}
