package revision_oct2025.binary_search;

public class PivotArray {

    public static void main(String[] args) {
        int[] A = { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196,
                201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23,
                26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53,
                54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91,
                92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115,
                116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139,
                143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169,
                170, 171, 172, 173, 174, 175, 176, 177};

        int B = 42;
        // ans = 43

        System.out.println(search(A, B));
    }

    public static int search(final int[] A, int B) {
        int start = 0;
        int end = A.length - 1;

        // let's find the pivot element first
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;

            // if the mid and it's neighbours are in ascending order, then mid is not the pivot
            if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                // pivot lies either on left or right
                // if the first element is larger than the last, then this array is pivoted.
                if (A[start] > A[mid - 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {

                //find pivot
                int pivot;
                if (A[mid - 1] < A[mid]) {
                    pivot = mid + 1;
                } else {
                    pivot = mid;
                }
                System.out.println("pivot = " + pivot);
                // binary search in one of the two arrays
                if (B >= A[pivot] && B <= A[A.length - 1]) {
                    return binarySearch(A, pivot, A.length - 1, B);
                } else {
                    return binarySearch(A, 0, pivot - 1, B);
                }
            }
        }

        return -1;
    }

    public static int binarySearch(int[] A, int start, int end, int B) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (A[mid] == B)
                return mid;
            else if (A[mid] < B) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

