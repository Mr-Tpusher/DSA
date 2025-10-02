package dsa_2024_25.string_algorithms;

/*
 * Given an array of strings, find the largest common prefix.
 * */
public class LargestCommonPrefix {
    public static void main(String[] args) {
        String[] s = {"ax", "axdddddc", "axdb"};
        System.out.println(largestCommonPrefix(s));

    }

    public static String largestCommonPrefix(String[] s) {

        if (s == null || s.length == 0) return "";

        int minStringLength = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            minStringLength = Math.min(minStringLength, s[i].length());
        }

        if (minStringLength == 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < minStringLength; c++) {
            Character currChar = s[0].charAt(c);

            for (int i = 1; i < s.length; i++) {
                if (currChar != s[i].charAt(c)) {
                    return sb.toString();
                }
            }
            sb.append(currChar);
        }
        return sb.toString();
    }
}
