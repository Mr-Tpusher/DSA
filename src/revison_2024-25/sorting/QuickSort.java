package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {7, 3, 5, 1, 10, 4, 2, 6, 1};

        System.out.println(Arrays.toString(A));
        quickSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));

        System.out.println("In-Place Quick Sort:");
        test();


    }

    public static void quickSort(int[] A, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = A[l];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (A[i] <= pivot && i != l) {
                left.add(A[i]);
            } else if (A[i] > pivot) {
                right.add(A[i]);
            }
        }

        int k = l;
        for (Integer ele : left) {
            A[k++] = ele;
        }
        A[k++] = pivot;
        for (Integer ele : right) {
            A[k++] = ele;
        }
        quickSort(A, l, left.size() - 1);
        quickSort(A, l + left.size() + 1, left.size() + right.size() - 1);
    }

    public static void inPlaceQuickSort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = left;
        int pivot = A[pivotIndex];
        int i = left + 1, j = left + 1;
        while (j <= right) {
            int currElement = A[j];
            if (currElement < pivot) {
                if (i != j) {
                    swap(A, i, j);
                }
                i++;
                j++;
            } else if (currElement >= pivot) {
                j++;
            }
        }
        // Moving the pivot element at it's correct position
        swap(A, i - 1, pivotIndex);
        inPlaceQuickSort(A, left, i - 2);
        inPlaceQuickSort(A, i, right);
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void test() {
        int[][] testCases = {
                {3, 6, 8, 10, 1, 2, 1},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {3, 3, 2, 1, 4, 5, 3},
                {42},
                {},
                {-3, -1, -4, 2, 0, 1},
                {7, 7, 7, 7, 7}
        };

        int[][] expectedOutputs = {
                {1, 1, 2, 3, 6, 8, 10},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 3, 3, 4, 5},
                {42},
                {},
                {-4, -3, -1, 0, 1, 2},
                {7, 7, 7, 7, 7}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + (i + 1) + ":");
            inPlaceQuickSort(testCases[i], 0, testCases[i].length - 1);
            System.out.println("Sorted   : " + Arrays.toString(testCases[i]));
            System.out.println("Expected : " + Arrays.toString(expectedOutputs[i]));
            System.out.println("Pass: " + Arrays.equals(testCases[i], expectedOutputs[i]));
            System.out.println();
        }
    }

}

