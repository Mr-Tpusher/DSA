package revision_oct2025.dynamic_programming;
/*
* Find length of the longest palindromic substring.
* S = "agbdba"
* ans = 3 i.e. bdb
* */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "agbdba";
        System.out.println(bruteForce(s));
    }

    static int bruteForce(String s) {
        return bruteForceHelper(s, 0, s.length() - 1).maxLength;
    }

    static Result bruteForceHelper(String s, int left, int right) {
        if (left == right) return new Result(true, 1);

        if (left > right) return new Result(false, 0);

        // if the characters match
        if (s.charAt(left) == s.charAt(right)) {
            Result result = bruteForceHelper(s, left + 1, right - 1);
            if (result.isPalindrome) {
                return new Result(true, result.maxLength + 2);
            } else {
                return result;
            }
        }

        // characters are not matching
        else {
            Result leftResult = bruteForceHelper(s, left + 1, right);
            Result rightResult = bruteForceHelper(s, left, right - 1);

            return new Result(false, Math.max(leftResult.maxLength, rightResult.maxLength));
        }
    }

    private static class Result {
        boolean isPalindrome;
        int maxLength;
        Result(boolean isPalindrome, int maxLength) {
            this.isPalindrome = isPalindrome;
            this.maxLength = maxLength;
        }
    }
}
