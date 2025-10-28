package revision_oct2025.binary_search;

/*
 * Given a sorted array, find first occurrence of k.
 * */
public class FirstOccurrenceOfK {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 18, 20, 20, 27};
        int k = 10;

        System.out.println("first occ of " + k + " : " + firstOcc(arr, k));

    }

    public static int firstOcc(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == k) {
                if (start == end) {
                    return mid;
                }
                end = mid;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
