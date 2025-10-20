package revison_oct2025.sorting;

import java.util.Arrays;

public class UnsortedToSorted {
    public static void main(String[] args) {
        int[] A = {1,3,4,2,5,6};
        //System.out.println(Arrays.toString(bruteForce(A)));
        System.out.println(Arrays.toString(solution(A)));
    }

    /*
    * 1. The idea here is to check first point from left which is not following sorting order
    * 2. and first point from right which is not following the sorting order.
    * 3. Then we have the bare minimum window.
    * 4. Now get min and max value from this window.
    * 5. All the elements on left side of window should be less than the min of the window
    * 6. All the elements on the right side of the window should be greater than the window
    * */
    static int[] solution(int[] A) {
        int probableStartIndex = -1;
        int probableEndIndex = A.length;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                probableStartIndex = i;
                break;
            }
        }
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] < A[i - 1]) {
                probableEndIndex = i;
                break;
            }
        }
        if (probableStartIndex == -1) return new int[] {-1};

        // probable window spans from start to end
        // check left side and right side of window
        int minWindowValue = Integer.MAX_VALUE;
        int maxWindowValue = Integer.MIN_VALUE;
        for (int i = probableStartIndex; i <= probableEndIndex; i++) {
            minWindowValue = Math.min(minWindowValue, A[i]);
            maxWindowValue = Math.max(maxWindowValue, A[i]);
        }
        int start = probableStartIndex;
        for (int i = 0; i < start; i++) {
            if (A[i] > minWindowValue) {
                start = i;
                break;
            }
        }
        int end = probableEndIndex;
        for (int i = A.length - 1; i > probableEndIndex; i--) {
            if (A[i] < maxWindowValue) {
                end = i;
                break;
            }
        }
        return new int[]{start, end};
    }


    static int[] bruteForce(int[] A) {
        int[] B = A.clone();
        Arrays.sort(B);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

        int start = -1, end = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                if (start == -1)
                    start = i;
                end = i;
            }
        }
        if (start == -1)
            return new int[] {-1};
        return new int[]{start, end};
    }
}
