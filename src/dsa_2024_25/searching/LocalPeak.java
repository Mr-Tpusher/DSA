package dsa_2024_25.searching;
/*
* Given an array, find local peak, local peak is an element
* whose neighbours are less than or equal to it.
* */
public class LocalPeak {
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 6, 7, 8, 4, 5, 5};

        System.out.println("local Peak:" + localPeak(A, 0, A.length));


    }

    public static int localPeak(int[] A, int start, int end) {

        if (start == end) {
            return A[start];
        }

        int mid = start + (end - start) / 2;

        if (mid == 0 && A[mid] >= A[mid + 1]) {
            return A[mid];
        }
        if (mid == A.length - 1 && A[mid] >= A[mid - 1]) {
            return A[mid];
        }
        if (A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]) {
            return A[mid];
        }
        if (A[mid - 1] >= A[mid]) {
            return localPeak(A, start, mid - 1);
        }
        if (A[mid + 1] >= A[mid]) {
            return localPeak(A, mid + 1, end);
        }
        return -1;
    }
}
