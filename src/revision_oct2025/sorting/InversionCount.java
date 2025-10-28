package revision_oct2025.sorting;

public class InversionCount {
    static int MOD = 1000000007;

    public static void main(String[] args) {
        int[] A = {45, 10, 15, 25, 50};
        System.out.println(solve(A));
    }

    static int solve(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    static int mergeSort(int[] A, int start, int end) {

        if (start == end) return 0;

        int mid = start + (end - start) / 2;
        int a = mergeSort(A, start, mid);
        int b = mergeSort(A, mid + 1, end);
        int c = merge(A, start, mid, end);

        return (a + b + c) % MOD;

    }

    static int merge(int[] A, int start, int mid, int end) {
        int leftArraySize = mid - start + 1;
        int[] left = new int[leftArraySize];
        System.arraycopy(A, start, left, 0, leftArraySize);
        int rightArraySize = end - mid;
        int[] right = new int[rightArraySize];
        System.arraycopy(A, mid + 1, right, 0, rightArraySize);

        int count = 0;
        int i = 0, j = 0, k = start;
        while (i < leftArraySize && j < rightArraySize) {
            if (left[i] <= right[j]) {
                A[k++] = left[i++];
            } else {
                int currCount = leftArraySize - i;
                count = ((count % MOD) + (currCount % MOD)) % MOD;
                A[k++] = right[j++];
            }
        }

        while (i < leftArraySize) A[k++] = left[i++];
        while (j < rightArraySize) A[k++] = right[j++];
        return count;
    }

}

