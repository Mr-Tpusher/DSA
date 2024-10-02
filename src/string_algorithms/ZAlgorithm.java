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
        System.out.println(Arrays.toString(zAlgo(s)));
    }

    public static int[] bruteForce(String s) {
        int length = s.length();
        int[] A = new int[length];

        for (int i = 0; i < length; i++) {
            int j = 0;
            while (i + j < length && s.charAt(i + j) == s.charAt(j)) {
                j++;
            }
            A[i] = j;
        }
        return A;
    }

    public static int[] zAlgo(String s) {
        int length = s.length();
        int left = 0, right = 0;
        int[] z = new int[length];
        z[0] = length;
        for (int i = 1; i < length; i++) {
            if (i > right) {
                left = i;
                right = i;
                while (right < length && s.charAt(right - left) == s.charAt(right)) {
                    right++;
                }
                z[i] = right - left;
                --right;
            } else {
                int j = i - left; // corresponding matching element on left
                if (z[j] < right - i + 1) {
                    z[i] = z[j];
                } else {
                    // here the answer should be rest of the window + manual compare
                    // we would simply change the window
                    // just change the left pointer, right pointer would've already been
                    // outside prev window, and we need to compare this element
                    left = i;
                    while (right < length && s.charAt(right - left) == s.charAt(right)) {
                        right++;
                    }
                    z[i] = right - left;
                    --right;
                }
            }
        }
        return z;
    }
}
