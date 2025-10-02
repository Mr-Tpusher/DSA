package sorting;

public class KthLargestUsingSelection {
    public static void main(String[] args) {
        int[] A = {9, 4, 0, 5, 6, 8, 10, 1, 7, 3, 2};
        int k = 4;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int maxIndex = 0;
            int maxValue = A[0];
            for (int j = 1; j < A.length - 1 - i; j++) {
                if (A[j] > maxValue) {
                    maxIndex = j;
                    maxValue = A[j];
                }
            }
            A[maxIndex] = A[A.length - 1 - i];
            A[A.length - 1 - i] = maxValue;
            largest = maxValue;
        }
        System.out.println("kth Largest:" + largest);
    }
}
