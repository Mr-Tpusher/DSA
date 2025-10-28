package revision_oct2025.sorting;

public class KthLargest {
    public static void main(String[] args) {
        int[] A = {10, 5, 9, 8, 2, 3, 7, 6, 1, 4};
        int k = 3;
        System.out.println(kthLargest(A, k));
    }

    static int kthLargest(int[] A, int k) {
        if (k > A.length) return 0;
        for (int i = 0; i < k; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > A[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = A[maxIndex];
                A[maxIndex] = A[i];
                A[i] = temp;
            }
        }
        return A[k - 1];
    }
}
