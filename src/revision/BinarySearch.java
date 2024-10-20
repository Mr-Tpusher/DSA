package revision;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 5;
        System.out.println(binarySearchIterative(A, k));
        System.out.println(binarySearchRecursive(A, k, 0 , A.length - 1));

    }

    public static int binarySearchIterative(int[] A, int k) {
        int length = A.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid =  left + (right - left) / 2;

            if (A[mid] == k)
                return mid;
            else if (A[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] A, int k, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid =  left + (right - left) / 2;
        if (A[mid] == k) {
            return mid;
        }

        if (A[mid] < k)
            return binarySearchRecursive(A, k, mid + 1, right);
        else
            return binarySearchRecursive(A, k, left, mid - 1);

    }
}
