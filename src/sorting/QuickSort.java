package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {7, 3, 5, 1, 10, 4, 2, 6, 1};

        System.out.println(Arrays.toString(A));
        quickSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));

    }

    public static void quickSort(int[] A, int l, int r) {
        System.out.println("------------------------------");
        System.out.println(Arrays.toString(A));
        System.out.println("l:" + l + ", r=" + r);
        if (l >= r) {
            return;
        }
        int pivot = A[l];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (A[i] <= pivot && i != l) {
                left.add(A[i]);
            } else if (A[i] > pivot){
                right.add(A[i]);
            }
        }

        System.out.println(left);
        System.out.println(right);

        int k = l;
        for (Integer ele : left) {
            A[k++] = ele;
        }
        A[k++] = pivot;
        for (Integer ele : right) {
            A[k++] = ele;
        }
        System.out.println(Arrays.toString(A));

        quickSort(A, l, left.size() - 1);
        quickSort(A, l + left.size() + 1, left.size() + right.size() - 1);


    }
}
