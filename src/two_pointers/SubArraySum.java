package two_pointers;
/*
* Given an unsorted array, return true if there is some sub-array
* of sum equals to k.
* */
public class SubArraySum {
    public static void main(String[] args) {
        int[] A = {1, 4, 3, 10, 5, 20};
        int k = 17;
        System.out.println(bruteForce(A, k));
        System.out.println(solve(A, k));
    }

    public static boolean bruteForce(int[] A, int k) {
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j  < A.length; j++) {
                sum += A[j];
                if (sum == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean solve(int[] A, int k) {
        int sum = 0;
        int[] cumulativeSum = new int[A.length];
        cumulativeSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + A[i];
        }
        int start = 0, end = 0;
        while (start < A.length && end < A.length) {
            int cumSum = cumulativeSum[end];
            while (cumSum > k)  {
                cumSum -= A[start];
                start++;
            }
            if (cumSum == k) return true;
            else if (cumSum < k) end++;
        }
        return false;
    }
}
