package revision_oct2025.string_algo;
/*
* Given a String, find the smallest period k of the String.
* Period K is defined as S[i % k] = s[i]
* e.g. abca abca abca
* ans: k = 4
*
* */
public class PeriodOfAString {
    public static void main(String[] args) {
        String s1 = "abcaabcaabca";
        System.out.println(findSmallestPeriodWithZAlgo(s1));

        String s2 = "abcabcabcabc";
        System.out.println(findSmallestPeriodWithZAlgo(s2));

        String s3 = "abcdsedfdfdjjakjkdjfd";
        System.out.println(findSmallestPeriodWithZAlgo(s3));

    }

    static int findSmallestPeriodWithZAlgo(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // find z array of the string
        int[] z = new int[s.length()];
        z[0] = s.length();
        int left = 0, right = 0;
        for (int i = 1; i < s.length(); i++) {
            if (right < i) {
                // do brute force to find prefix match
                right = i;
                left = i;
                while (right < s.length() && s.charAt(right - left) == s.charAt(right)) {
                    right++;
                }
                z[i] = right - left;
                right--;
            } else {
                // j is the matching index for i from the prefix of window
                int j = i - left;
                // when the answer is well within the boundary
                if (z[j] < right - i + 1) {
                    z[i] = z[j];
                } else {
                    // start a new window
                    left = i;
                    while (right < s.length() && s.charAt(right - left) == s.charAt(right)) {
                        right++;
                    }
                    z[i] = right - left;
                    right--;
                }
            }
        }

        for (int i = 1; i < z.length; i++) {
            if (i + z[i] == z.length)
                return i;
        }
        return s.length();
    }

    static int solution1(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(0)) {
                int patternLength = i;
                if (isPeriodOfString(s, patternLength)) {
                    return patternLength;
                }
            }
        }
        return s.length();
    }

    static boolean isPeriodOfString(String s, int patternLength) {
        for (int i = patternLength; i < s.length(); i++) {
            if (s.charAt(i % patternLength) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
