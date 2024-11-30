package dynamic_programming;
/*
* Given a string S, and a pattern P, find if the string can be represented by the
* given pattern.
* There can be 2 special symbols in the pattern:
*   1. ? ---> can be replaced by 1 character
*   2. * ---> can be replaced by a sequence of characters(0 to n)
*
* S : alanturing
* P : al?n*i*g
* answer: true
*
*
* */
public class PatternMatching {
    public static void main(String[] args) {
        String s = "alanturing";
        String p = "al?n*i*g";
        System.out.println(bruteForce(s, p, 0, 0));
    }

    public static boolean bruteForce(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (i == s.length() || j == p.length()) {
            // out of bounds
            return false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return bruteForce(s, p, i + 1, j + 1);
        }

        if (p.charAt(j) == '*') {
            boolean whenEmptyChar = bruteForce(s, p, i, j + 1);
            boolean whenSeqOfChars = bruteForce(s, p, i + 1, j);
            return whenEmptyChar || whenSeqOfChars;
        }

        else {
            return false;
        }

    }
}
