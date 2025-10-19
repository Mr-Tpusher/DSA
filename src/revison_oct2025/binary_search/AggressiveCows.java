package revison_oct2025.binary_search;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] A = {4, 8, 11, 25, 37, 50};
        int cows = 3;
        System.out.println(maximizeMinDistance(A, cows));


    }

    static int maximizeMinDistance(int[] A, int cows) {

        // answer space = 0 to A[N-1]
        int answer = 0;

        int length = A.length;
        int start = A[0], end = A[length - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // if (feasibilityUsingBinarySearch(A, cows, mid)) {
            if (feasibilityUsingBinarySearch(A, cows, mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    static boolean feasibilityUsingBinarySearch(int[] A, int cows, int distance) {
        // A = {4, 8, 11, 15, 18, 24};
        // cows = 3

        int prevCowIndex = 0;
        cows--;
        while (cows > 0) {
            int nextCowShouldBeAt = A[prevCowIndex] + distance;
            int nextCowActualIndex = -1;

            int left = prevCowIndex, right = A.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (A[mid] >= nextCowShouldBeAt) {
                    nextCowActualIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (nextCowActualIndex == -1) {
                return false;
            } else {
                cows--;
                prevCowIndex = nextCowActualIndex;
            }
        }

        return cows == 0;
    }

    static boolean feasibilityUsingLinearSearch(int[] A, int cows, int distance) {
        int prevCowAtIndex = 0;
        cows--;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[prevCowAtIndex] >= distance) {
                cows--;
                prevCowAtIndex = i;
            }
            if (cows == 0)
                return true;
        }
        return false;
    }

}
