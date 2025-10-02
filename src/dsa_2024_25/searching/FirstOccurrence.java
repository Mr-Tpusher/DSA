package dsa_2024_25.searching;
/*
* Given a sorted array which may contain duplicates,
* find occurrence of k.
* A = {2, 4, 10, 10, 10,18, 20, 20 ,27};
* */
public class FirstOccurrence {
    public static void main(String[] args) {

        test(new int[]{1, 2, 2, 2, 2, 3, 4, 5}, 2, 1);
        test(new int[]{1, 2, 2, 2, 2, 3, 4, 5}, 6, -1);
        test(new int[]{1, 2, 2, 2, 2, 3, 4, 5}, 5, 7);
        test(new int[]{2, 2, 2, 2, 3, 4, 5}, 2, 0);
        test(new int[]{2, 2, 2, 2, 2, 2, 2}, 2, 0);
        test(new int[]{1, 2, 2, 3, 3, 3, 4, 5}, 3, 3);
        test(new int[]{}, 1, -1);
    }

    public static void test(int[] A, int k, int expected) {
        int index = binarySearch(A, k, 0, A.length - 1);
        System.out.println("Searching for " + k + ": Expected " + expected + ", Found " + index);
    }

    public static int binarySearch(int[] A, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (A[mid] == k) {
            if (start == end) {
                return mid;
            } else {
                return binarySearch(A, k, start, mid);
            }
        } else if (A[mid] > k) {
            return binarySearch(A, k, start, end - 1);
        } else {
            return binarySearch(A, k, mid + 1, end);
        }

    }
}
