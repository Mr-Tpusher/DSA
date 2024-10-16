package arrays;
/*
* Given an array, find the length of the longest palindrome.
* int[] A = {1, 4, 3, 4, 2, 4, 3, 9}
* */
public class LongestPalindrome {
    public static void main(String[] args) {
        int[] A = {1, 4, 3, 4, 2, 4, 3, 9};
        System.out.println(solve1(A));
        System.out.println(solve2(A));
    }

    public static int solve1(int[] A) {
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

    public static int solve2(int[] A) {
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
        int length = A.length;
        int start = 0;
        int end = length - 1;
        while (start < length) {
            if (A[start] != A[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome2(int[] A, int start, int end) {
        int length = end - start + 1;
        while (start < length) {
            if (A[start] != A[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
