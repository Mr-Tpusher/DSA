package sorting;
/*
* Given an array, provide the inversion count.
* i.e. A[i] > A[j] where i < j
* A = {4, 5, 1, 2, 6, 3}
*
* */
public class InversionCount {
    static final int MOD = 1000000000 + 7;

    public static void main(String[] args) {
        int[] A = {4, 5, 1, 2, 6, 3};
        System.out.println(bruteForce(A));
        System.out.println(inversionCountUsingMergeSort(A));
    }

    public static int inversionCountUsingMergeSort(int[] A) {
        return inversionCount(A, 0, A.length - 1);
    }

    public static int inversionCount(int[] A, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count1 = inversionCount(A, start, mid);
        int count2 = inversionCount(A, mid + 1, end);
        int crossCount = getCrossInversionCountAndMerge(A, start, mid, end);
        return (count1 + count2 + crossCount) % MOD;
    }

    private static int getCrossInversionCountAndMerge(int[] A, int start, int mid, int end) {
        int leftLength = mid - start + 1;
        int rightLength = end - (mid + 1) + 1; // (mid + 1) is the starting point of the right array
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];
        System.arraycopy(A, start, left, 0, leftLength);
        System.arraycopy(A, mid + 1, right, 0, rightLength);

        int i = 0, j = 0, k = start, count = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] > right[j]) {
                count = (count + (leftLength - i)) % MOD;
                A[k++] = right[j++];
            } else {
                A[k++] = left[i++];
            }
        }
        while (i < leftLength) {
            A[k++] = left[i++];
        }
        while (j < rightLength) {
            A[k++] = right[j++];
        }
        return count;
    }

    public static int bruteForce(int[] A) {
        int count = 0;
        for (int j = 1; j < A.length; j++) {
            for (int i = 0; i < j; i++) {
                if (A[i] > A[j]) {
                    //System.out.println("A[i], A[j]: " + A[i] + " " + A[j]);
                    count++;
                }
            }
        }
        return count;
    }
}
