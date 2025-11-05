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
        System.out.println(topDownDP(s));
        System.out.println(bottomUpDP(s));
    }

    static int bruteForce(String s) {
        return bruteForceHelper(s, 0, s.length() - 1).maxLength;
    }

    static int topDownDP(String s) {
        Result[][] memo = new Result[s.length()][s.length()];

        return topDownHelper(s, 0, s.length() - 1, memo).maxLength;
    }

    static int bottomUpDP(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        int maxLength = 1;

        // pre-populate strings of length 1
        for (int i = 0; i < n; i++) {
            memo[i][i] = true;
        }

        // pre-populate strings of length 2, because they cannot be calculated directly by depending on prev.
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                memo[i][i + 1] = true;
                maxLength = 2;
            }
        }

        // fill the matrix diagonally i.e. length wise for length 3 onwards
        // because substring of length l depends on the dp state of substrings of length (l - 1) and (l - 2).
        for (int l = 3; l <= n; l++) {
            for (int start = 0; start <= n - l; start++) {
                int end = start + l - 1;

                if (s.charAt(start) == s.charAt(end)) {
                    memo[start][end] = memo[start + 1][end - 1];
                    if (memo[start][end]) // if the inner substring is palindrome and current chars match
                        maxLength = l;  // current substring is a palindrome
                }
            }
        }

        return maxLength;
    }


    static Result topDownHelper(String s, int left, int right, Result[][] memo) {

        if (left == right) return memo[left][right] = new Result(true, 1);

        if (left > right) return memo[left][right] = new Result(false, 0);

        if (memo[left][right] != null) return memo[left][right];

        // if current character match
        if (s.charAt(left) == s.charAt(right)) {
            Result result = topDownHelper(s, left + 1, right - 1, memo);

            if (result.isPalindrome) memo[left][right] =  new Result(true, 2 + result.maxLength);
            else memo[left][right] = new Result(false, result.maxLength);
        }

        // if the current chars don't match
        else {
            Result leftResult = topDownHelper(s, left + 1, right, memo);
            Result rightResult = topDownHelper(s, left, right - 1, memo);

            memo[left][right] = new Result(false, Math.max(leftResult.maxLength, rightResult.maxLength));
        }

        return memo[left][right];
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
