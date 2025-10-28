package revision_oct2025.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {10, 5, 9, 8, 2, 3, 7, 6, 1, 4};
        System.out.println(Arrays.toString(bubbleSort(A)));

    }
    static int[] bubbleSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return A;
    }
}
