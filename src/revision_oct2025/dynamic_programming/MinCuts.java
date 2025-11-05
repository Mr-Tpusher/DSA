package revision_oct2025.dynamic_programming;

/*
 * Given a String s, find the min number of cuts required to make all the partitions palindromes.
 * s = "abccbd", ans = 2 i.e. a | bccb | d
 *
 * */
public class MinCuts {
    public static void main(String[] args) {
        String s = "abccbd";
        bruteForce(s);
    }

    static void bruteForce(String s) {
        System.out.println(bruteForceHelper(s, 0, s.length() - 1));
        System.out.println(bruteForceHelper(s, 0, s.length() - 1));
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
