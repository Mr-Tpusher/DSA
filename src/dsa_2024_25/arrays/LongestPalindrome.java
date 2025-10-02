package dsa_2024_25.arrays;
/*
* Given an array, find the length of the longest palindrome.
* int[] A = {1, 4, 3, 4, 2, 4, 3, 9}
* */
public class LongestPalindrome {
    public static void main(String[] args) {
        int[] A = {1, 4, 3, 4, 2, 3, 4, 10, 2, 4, 3, 9};
        System.out.println(longestPalindromeUsingBruteForce(A));
        System.out.println(longestPalindromeUsingTwoPointers(A));
        System.out.println(solveByExpandingAcrossCenter(A));
    }

    public static int longestPalindromeUsingBruteForce(int[] A) {
        int length = A.length;
        if (length == 0) return 0;

        int max = 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int[] subArray = new int[j - i + 1];
                for (int x = i, y = 0; x <= j; x++, y++) {
                    subArray[y] = A[x];
                }
                if (isPalindrome(subArray)) {
                    max = Math.max(max, subArray.length);
                }
            }
        }
        return max;
    }

    public static int longestPalindromeUsingTwoPointers(int[] A) {
        int length = A.length;
        if (length == 0) return 0;

        int max = 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isPalindrome2(A, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static boolean isPalindrome(int[] A) {
        int start = 0;
        int end = A.length - 1;

        while (start < end) {
            if (A[start] != A[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome2(int[] A, int start, int end) {
        while (start < end) {
            if (A[start] != A[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int solveByExpandingAcrossCenter(int[] A) {
        int length = A.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int length1 = getPalindromeLength(A, i - 1, i + 1);
            int length2  = getPalindromeLength(A, i, i + 1);
            max = Math.max(max,Math.max(length1,length2));
        }
        return max;
    }

    public static int getPalindromeLength(int[] A, int left, int right) {

        while (left >= 0 && right < A.length) {
            if (A[left] != A[right])
                break;
            left--;
            right++;
        }
        return right - left - 1;
        // -1 because the pointers would've gone extra step towards left and right
        // before exiting the loop
    }
}
