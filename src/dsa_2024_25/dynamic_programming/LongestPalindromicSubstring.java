package dsa_2024_25.dynamic_programming;

import java.util.Arrays;

/*
* Given a string, find the length of longest Palindromic substring.
* s = "agbdba"
* ans: 3 ---> bdb
* */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "abdba";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        int length = s.length();

        // dp state : whether the substring(i,j) is a palindrome or not
        boolean[][] dp = new boolean[length][length];
        for (boolean[] arr : dp) {
            Arrays.fill(arr, false);
        }

        // pre-populate substring of length 1
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        // Iterate substring lengthwise i.e. diagonally
        for (int substringLength = 2; substringLength <= length; substringLength++) {
            for (int i = 0; i <= length - substringLength; i++) {
                int j = i + substringLength - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    // if current characters are matching then the substring between i,j
                    // will be a palindrome only if substring (i+1),(j-1) is.
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // To get the longest palindromic substring, we can iterate over the dp array
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (dp[i][j]) {
                    // length of the substring = j - 1 + 1;
                    max = Math.max(max, (j - i + 1) );
                }
            }
        }
        return max;
    }
}
