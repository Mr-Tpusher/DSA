package revision_oct2025.dynamic_programming;
/*
* Given a string, find the longest palindromic subsequence present in it.
* String s = "agbdba"
* answer = 5 i.e. abdba
* */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "agbdba";
        System.out.println(bruteForce(s));

    }

    static int bruteForce(String s) {
        return bruteForceHelper(s, 0, s.length() - 1);
    }

    static int bruteForceHelper(String s, int left, int right) {

        if (left == right) return 1;
        if (left > right) return 0;

        if (s.charAt(left) == s.charAt(right)) {
            return 2 + bruteForceHelper(s, left + 1, right - 1);
        } else {
            int first = bruteForceHelper(s, left + 1, right);
            int second = bruteForceHelper(s, left, right - 1);
            return Math.max(first, second);
        }
    }
}
