package revison_oct2025.sorting;

import java.util.Arrays;

public class GameOfBottles {
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 2, 3, 3}));
    }
    static int solve(int[] A) {
        Arrays.sort(A);
        int maxFreq = 0;
        int i = 0;
        while (i < A.length - 1) {
            int currFreq = 1;
            while (i < A.length - 1 && A[i] == A[i+1]) {
                currFreq++;
                i++;
            }
            i++;
            maxFreq = Math.max(maxFreq, currFreq);
        }
        return maxFreq;
    }
}
