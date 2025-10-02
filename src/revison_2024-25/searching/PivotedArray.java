package searching;
/*
* Given a sorted array no dupes,
* also the array is pivoted at some random point,
* and now the sorting order is also changed.
* Find index of the given number.
* int[] A = {12, 14, 18, 21, 3, 6, 8, 9};
* */
public class PivotedArray {
    public static void main(String[] args) {
        int[] A1 = {12, 14, 18, 21, 3, 6, 8, 9};
        int k1 = 14;
        int[] A2 = {1, 2, 3, 6, 8, 9};
        int k2 = 8;
        int[] A3 = {92, 94, 18, 21, 43, 46, 48, 49};
        int k3 = 49;
        int[] A4 = {112, 14, 18, 21, 23};
        int k4 = 112;

        System.out.println(findElementIndex(A1, k1));
        System.out.println(findElementIndex(A2, k2));
        System.out.println(findElementIndex(A3, k3));
        System.out.println(findElementIndex(A4, k4));
    }

    public static int findElementIndex(int[] A, int k) {
        int pivot = findPivot(A, 0, A.length - 1);
        //System.out.println("pivot:" + pivot);
        if (pivot == -1) {
            return searchElement(A, k, 0, A.length - 1);
        } else if (A[0] <= k && k <= A[pivot - 1]) {
            return searchElement(A, k, 0, pivot - 1);
        } else {
            return searchElement(A, k, pivot, A.length - 1);
        }
    }

    public static int findPivot(int[] A, int start, int end) {

        if (A[start] < A[end] ) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (mid != 0 && A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
            if (A[start] > A[mid - 1]) {
                return findPivot(A, start, mid - 1);
            } else {
                return findPivot(A, mid + 1, end);
            }
        } else if ( mid !=0 && A[mid - 1] > A[mid]) {
            return mid;
        } else if (A[mid] > A[mid + 1]) {
            return mid + 1;
        }
        return -1;
    }

    public static int searchElement(int [] A, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (A[mid] == k) {
            return mid;
        } else if (A[mid] < k ) {
            return searchElement(A, k, mid + 1, end);
        } else {
            return searchElement(A, k ,start, mid - 1);
        }
    }
}
