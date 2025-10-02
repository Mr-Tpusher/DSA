package searching;

/*
 * Given an array, every element occurs twice,
 * except one, find that element.
 * int[] A = {11, 11, 22, 22, 43, 43, 44, 44, 45, 45, 56, 56, 67}
 * */
public class SingleElement {
    public static void main(String[] args) {
        int[] A1 = {111, 111, 22, 22, 343, 343, 44, 44, 45, 45, 56, 67, 67};
        int[] A2 = {1, 22, 22, 343, 343, 44, 44, 45, 45, 67, 67};
        int[] A3 = {1, 1, 2, 2, 3, 3};
        int[] A4 = {};
        System.out.println(findSingleElementIterative(A1, 0, A1.length - 1));
        System.out.println(findSingleElementIterative(A2, 0, A2.length - 1));
        System.out.println(findSingleElementIterative(A3, 0, A3.length - 1));
        System.out.println(findSingleElementIterative(A4, 0, A4.length - 1));

        System.out.println(findSingleElementRecursively(A1, 0, A1.length - 1));
        System.out.println(findSingleElementRecursively(A2, 0, A2.length - 1));
        System.out.println(findSingleElementRecursively(A3, 0, A3.length - 1));
        System.out.println(findSingleElementRecursively(A4, 0, A4.length - 1));
    }

    public static int findSingleElementIterative(int[] A, int start, int end) {
        while (start <= end) {
            if (start == end) {
                return A[start];
            }

            int mid = start + (end - start) / 2;

            // If the mid is even, mid and right should be equal
            if ((mid & 1) == 0) {
                if (A[mid] == A[mid + 1]) {
                    start = mid + 2;
                } else {
                    end = mid;
                }
            } else {
                // If the mid is odd, left and mid should be equal
                if (A[mid - 1] == A[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return -1;
    }

    public static int findSingleElementRecursively(int[] A, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return A[start];
        }

        int mid = start + (end - start) / 2;

        // If the mid is even, mid and right should be equal
        if ((mid & 1) == 0) {
            if (A[mid] == A[mid + 1]) {
                return findSingleElementRecursively(A, mid + 2, end);
            } else {
                return findSingleElementRecursively(A, start, mid);
            }
        } else {
            // If the mid is odd, left and mid should be equal
            if (A[mid - 1] == A[mid]) {
                return findSingleElementRecursively(A, mid + 1, end);
            } else {
                return findSingleElementRecursively(A, start, mid);
            }
        }
    }
}

