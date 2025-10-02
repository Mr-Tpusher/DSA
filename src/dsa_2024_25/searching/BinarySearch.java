package dsa_2024_25.searching;
/*
* Vanilla Binary Search
* */
public class BinarySearch {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 7;
        System.out.println(binarySearch(A,k,0, A.length));
    }

    public static int binarySearch(int[] A, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (mid >= A.length) {
            return -1;
        }

        if (A[mid] == k) {
            return mid;
        } else if (A[mid] > k) {
            return binarySearch(A, k, start, mid - 1);
        } else {
            return binarySearch(A, k, mid + 1, end);
        }
    }
}