package dsa_2024_25.revision;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {3, 2, 8, 4, 1, 6};
        bubbleSort(A);
        System.out.println(Arrays.toString(A));
    }

    public static void bubbleSort(int[] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
}
