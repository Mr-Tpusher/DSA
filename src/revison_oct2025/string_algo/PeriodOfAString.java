package revison_oct2025.string_algo;
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
        System.out.println(solution1(s1));

        String s2 = "abcabcabcabc";
        System.out.println(solution1(s2));

        String s3 = "abcdsedfdfdjjakjkdjfd";
        System.out.println(solution1(s3));

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
        return 0;
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
