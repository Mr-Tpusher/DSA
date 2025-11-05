package revision_oct2025.dynamic_programming;

import java.util.Arrays;

/*
 * Given a String s, find the min number of cuts required to make all the partitions palindromes.
 * s = "abccbd", ans = 2 i.e. a | bccb | d
 *
 * */
public class MinCuts {
    public static void main(String[] args) {
        String s = "abccbd";
        bruteForce(s);
        topDownDP(s);
    }

    static void bruteForce(String s) {
        System.out.println(bruteForceHelper(s, 0, s.length() - 1));
        System.out.println(bruteForceHelper2(s, 0, s.length() - 1));
    }

    static void topDownDP(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        topDownHelper(s, 0, s.length() - 1, dp);

        System.out.println(dp[0][s.length() - 1]);
    }

    static int topDownHelper(String s, int start, int end, int[][] dp) {
        if (start >= end) return 0;

        if (isPalindrome(s, start, end)) return dp[start][end] = 0;

        if (dp[start][end] != Integer.MAX_VALUE) return dp[start][end];

        for (int cut = start; cut < end; cut++) {
            if (isPalindrome(s, start, cut)) {
                int rightCuts = topDownHelper(s, cut + 1, end, dp);
                int currCuts = rightCuts + 1;
                dp[start][end] = Math.min(dp[start][end], currCuts);
            }
        }
        return dp[start][end];
    }

    static int bruteForceHelper(String s, int start, int end) {
        if (start >= end) return 0;

        if (isPalindrome(s, start, end)) return 0;


        // make cut at every possible index
        int minCuts = Integer.MAX_VALUE;
        for (int cut = start; cut < end; cut++) {
            int leftCuts = bruteForceHelper(s, start, cut);
            int rightCuts = bruteForceHelper(s, cut + 1, end);
            int currMinCuts = 1 + leftCuts + rightCuts;
            minCuts = Math.min(minCuts, currMinCuts);
        }

        return minCuts;
    }

    static int bruteForceHelper2(String s, int start, int end) {
        if (start >= end) return 0;

        if (isPalindrome(s, start, end)) return 0;

        // make cut at every possible index
        int minCuts = Integer.MAX_VALUE;
        for (int cut = start; cut < end; cut++) {
            // make a cut only if left is palindrome
            // otherwise if left is not a palindrome, there's no meaning going right
            if (isPalindrome(s, start, cut)) {
                int rightCuts = bruteForceHelper(s, cut + 1, end);
                minCuts = Math.min(minCuts, 1 + rightCuts);
            }
        }

        return minCuts;
    }
        private static boolean isPalindrome (String s,int start, int end){
            while (start < end) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
