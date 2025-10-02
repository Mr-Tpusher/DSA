package dsa_2024_25.searching;
/*
* Find total occurrences of a given element
* in a sorted array, which may contain duplicates
* int[] A = {12, 12, 14 ,18, 21, 21, 21, 27, 27}
* int k = 21
* */
public class TotalOccurrences {
    public static void main(String[] args) {
        int[] A = {12, 12, 14 ,18, 21, 21, 21, 27, 27} ;
        int k = 14;
        System.out.println(totalOcc(A, k));

    }

    public static int totalOcc(int[] A, int k) {
        int x = firstOccurrence(A, k, 0, A.length - 1);
        int y = lastOccurrence(A, k, 0, A.length - 1);
        System.out.println("firstOccurrence:" + x);
        System.out.println("lastOccurrence:" + y);
        if (x == -1 || y == -1) {
            return 0;
        } else {
            return y - x + 1;
        }
    }

    public static int firstOccurrence(int[] A, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (A[mid] == k) {
            if (start == end) {
                return mid;
            } else {
                return firstOccurrence(A, k, start, mid);
            }
        } else if (A[mid] > k) {
            return firstOccurrence(A, k, start, mid - 1);
        } else {
            return firstOccurrence(A, k, mid + 1, end);
        }
    }

    public static int lastOccurrence(int[] A, int k, int start, int end) {
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == k) {
                result = mid;
                start = mid + 1;
            } else if (A[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

}
