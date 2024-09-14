package sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int [] A = {7, 3, 5, 9, 10, 1, 4, 2};
        sort(A);

        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] A) {
    for (int i = 0; i < A.length; i++) {
        int minIndex = i;
        for (int j = i + 1; j < A.length; j++) {
            if (A[j] < A[minIndex]) {
                minIndex = j;
            }
        }
        int temp = A[minIndex];
        A[minIndex] = A[i];
        A[i] = temp;
        }
    }

    public static void sort2 (int[] A) {

        for (int i = A.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = 0; j <= i; j++) {
                if (A[j] > A[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = A[i];
            A[i] = A[maxIndex];
            A[maxIndex] = temp;
        }
    }
}
