package revision_oct2025.strings;
/*
Given a string s which consists of lowercase or uppercase letters, return the length of
the longest palindrome that can be built with those letters.
Letters are case-sensitive, for example, "Aa" is not considered a palindrome.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:
    1 <= s.length <= 2000
    s consists of lowercase and/or uppercase English letters only

*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestPalindromicString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome1("abccccdd"));
        System.out.println(longestPalindrome2("abccccdd"));

    }

    static int longestPalindrome1(String s) {
        if (s == null) return 0;

        HashSet<Character> seen = new HashSet<Character>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            if (seen.contains(s.charAt(i)))
                continue;
            else
                seen.add(s.charAt(i));

            int tempCount = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    tempCount++;
                }
            }
            if (tempCount > 0 && tempCount % 2 != 0) {
                tempCount++;
            }
            count += tempCount;
        }

        if (count < s.length())
            return count+1;
        return count;

    }

    static int longestPalindrome2(String s) {
        if (s == null) return 0;

        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int count = charMap.getOrDefault(s.charAt(i), 0);
            charMap.put(s.charAt(i), ++count);
        }

        int answer = 0;
        for (Map.Entry<Character, Integer> e: charMap.entrySet()) {
            if ((e.getValue() & 1) == 1) {
                answer += (e.getValue() - 1);
            } else {
                answer += e.getValue();
            }
        }

        if (answer < s.length())
            return answer+1;
        return answer;
    }
}
