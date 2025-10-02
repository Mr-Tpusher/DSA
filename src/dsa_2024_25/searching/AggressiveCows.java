package dsa_2024_25.searching;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] A = {4, 8, 11, 15, 18, 24};
        int cows = 3;

        // If the array is not sorted
        Arrays.sort(A);
        System.out.println(minDistance(A, cows, 1, A[A.length - 1] - A[0]));
    }

    public static int minDistance(int[] A, int cows, int start, int end) {
        if (start > end) {
            return end;
        }
        int mid = start + (end - start) / 2;
        if (isDistanceFeasible(A, cows, mid)){
            return minDistance(A, cows, mid + 1, end);
        } else {
            return minDistance(A, cows, start, mid - 1);
        }
    }

    public static boolean isDistanceFeasible(int[] A, int cows, int mid) {
        int prevCowAt = A[0];
        cows--;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - prevCowAt >= mid) {
                prevCowAt = A[i];
                cows--;
            }
            if (cows == 0) {
                return true;
            }
        }
        return false;
    }
}
