package string_algorithms;

import java.util.Arrays;

/*
* Given a string, return an array A, where for every index i of the string,
* the A[i] = length of the prefix of string from ith index which is equal to the
* prefix of the whole string.
* */
public class ZAlgorithm {
    public static void main(String[] args) {
        String s = "xxyzxxyzwxxyzxxyzx";
        System.out.println(Arrays.toString(bruteForce(s)));
    }

    public static int[] bruteForce(String s) {
        int length = s.length();
        int[] A = new int[length];

        for (int i = 0; i < length; i++) {
            int j = 0;
            while (j + i < length && s.charAt(j + i) == s.charAt(j)) {
                j++;
            }
            A[i] = j;
        }
        return A;
    }
}
