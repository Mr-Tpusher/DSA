package revision;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(A, 0));

    }

    public static int binarySearch(int[] A, int k) {
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
}
