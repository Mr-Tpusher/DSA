package dsa_2024_25.sorting;

import util.Timer;

public class BubbleSort {
    public static void main(String[] args) {
        int [] A = {7, 3, 5, 9, 10, 1, 4, 2};

        Timer timer = new Timer();
        timer.start();
        sort(A);
        timer.stop();

        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();

        timer.printElapsedTime();
    }

    public static void sort(int[] A) {
        boolean swapped = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
