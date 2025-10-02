package dsa_2024_25.two_pointers;

/*
 * Given a sorted array, return number of pairs having sum equals to k.
 *
 *
 * */
public class KSumPairs {
    public static void main(String[] args) {
        int[] A = {1, 4, 4, 5, 5, 5, 6, 6, 11};
        int k = 10;
        int[] A2 = {1, 2, 6, 6, 7, 9, 9};
        int k2 = 13;
        System.out.println(bruteForce(A2, k2));
        System.out.println(numberOfPairs(A2, k2));
    }

    public static int bruteForce(int[] A, int k) {
        int pairs = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == k) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static int numberOfPairs(int[] A, int k) {
        int length = A.length;
        long totalPairs = 0;
        int left = 0, right = length - 1;
        final int MOD = 1000000007;

        while (left < right) {
            int sum = A[left] + A[right];

            if (sum == k) {
                int leftElement = A[left];
                int rightElement = A[right];
                long leftFreq = 0, rightFreq = 0;

                while (left < length && A[left] == leftElement) {
                    leftFreq++;
                    left++;
                }
                while (right >= 0 && A[right] == rightElement) {
                    rightFreq++;
                    right--;
                }
                if (leftElement == rightElement) {
                    totalPairs +=  leftFreq * (leftFreq - 1) / 2;
                } else {
                    totalPairs +=  (leftFreq * rightFreq);
                }
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return (int)(totalPairs % MOD);
    }
}
