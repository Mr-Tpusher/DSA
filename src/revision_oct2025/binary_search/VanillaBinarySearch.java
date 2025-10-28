package revision_oct2025.binary_search;

public class VanillaBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 6;
        int index = bs1(arr, 0, arr.length - 1, k);
        System.out.println(k + " is present at index:" + index);
        int index2 = bs2(arr, 0, arr.length - 1, k);
        System.out.println(k + " is present at index:" + index2);
    }

    private static int bs1(int[] arr, int start, int end, int k) {

        int mid = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (k == arr[mid]) {
                return mid;
            }

            if (k < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int bs2(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (k == arr[mid]) {
            return mid;
        } else if (k < arr[mid]) {
            return bs2(arr, start, mid - 1, k);
        } else {
            return bs2(arr, mid + 1, end, k);
        }
    }
}
