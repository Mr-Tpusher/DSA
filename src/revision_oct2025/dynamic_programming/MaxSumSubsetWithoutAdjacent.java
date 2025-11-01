package revision_oct2025.dynamic_programming;

public class MaxSumSubsetWithoutAdjacent {
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 0, 7, 10};
        bruteForce(A);
    }

    static void bruteForce(int[] A) {
        System.out.println(bruteForceHelper(A, A.length - 1));
    }

    static int bruteForceHelper(int[] A, int index) {
        if (index < 0) return 0;

        int sumWithCurrent = A[index] + bruteForceHelper(A, index - 2);
        int sumWithoutCurrent = bruteForceHelper(A, index - 1);
        return Math.max(sumWithCurrent, sumWithoutCurrent);
    }

}
