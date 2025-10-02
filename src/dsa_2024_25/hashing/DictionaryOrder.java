package dsa_2024_25.hashing;

import java.util.HashMap;

/*
* Given two strings s and d, the d string represents the dictionary order
* of the characters in s. Arrange s according to d.
* */
public class DictionaryOrder {
    public static void main(String[] args) {
        String s = "aabfcade";
        String d = "cbfade";
        System.out.println(bruteForce(s, d));
        System.out.println(dictionaryOrder(s, d));
    }

    public static String bruteForce(String s, String d) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int swapIndex = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < d.length(); i++) {
            for (int j = swapIndex; j < sb.length(); j++) {
                if (sb.charAt(j) == d.charAt(i)) {
                    char temp = sb.charAt(swapIndex);
                    sb.setCharAt(swapIndex, sb.charAt(j));
                    sb.setCharAt(j, temp);
                    swapIndex++;
                }
            }
        }
        return sb.toString();
    }

    public static String dictionaryOrder(String s, String d) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            int f = freq.getOrDefault(c, 0);
            freq.put(c, ++f);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : d.toCharArray()) {
            int f = freq.getOrDefault(c, 0);
            for (int i = 0; i < f; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
