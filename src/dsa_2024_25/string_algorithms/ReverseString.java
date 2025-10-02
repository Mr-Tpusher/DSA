package dsa_2024_25.string_algorithms;
/*
    Given a string, reverse it word by word.
* */
public class ReverseString {
    public static void main(String[] args) {
        String s = "The Sky is Blue";
        System.out.println(reverseString(s));
    }

    public static String reverseString(String str) {
        StringBuilder s = new StringBuilder(str);
        int length = s.length();

        // Step 1: Reverse the entire string
        reverse(s, 0, length - 1);

        // Step 2: Reverse each word in the reversed string
        int i = 0;
        for (int j = 0; j <= length; j++) {
            if (j == length || s.charAt(j) == ' ' ) {
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }
        return s.toString();
    }

    public static void reverse(StringBuilder sb, int i, int j) {
        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
    }
}
