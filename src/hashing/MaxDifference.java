package hashing;
/*
* Given an array of integers, find Max(abs|i-j|)
* such that A[i]==A[j] and i!=j
* */
public class MaxDifference {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 7, 6, 3, 2, 1};
        System.out.println(bruteForce(A));

    }

    public static int bruteForce(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int currMax = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    currMax = Math.max(currMax, j - i);
                }
            }
            max = Math.max(max, currMax);
        }
        return max;
    }
}
