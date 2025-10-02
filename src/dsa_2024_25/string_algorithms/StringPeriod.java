package dsa_2024_25.string_algorithms;

import java.util.Arrays;

/*
* Given a string, find the smallest period k of it.
* period k is defined as S[i % k] = S[i]
* e.g. for abcdabcdabcd , k = 4
*
* Basically find the size of the minimum substring which is
* repeating over the entire string.
* e
* */
public class StringPeriod {
    public static void main(String[] args) {
        String s = "abcdabcdabcd";
        System.out.println(findPeriod(s));
    }

    public static int findPeriod(String s) {
        /*
            index: 0 1 2 3 4 5 6 7 8 9 10 11
            char:  a b c d a b c d a b c  d
            z:    12 0 0 0 8 0 0 0 4 0 0  0
         */
        // the first element in z where i + Z[i] = N  is the answer

        int[] z = zAlgo(s);
        System.out.println(Arrays.toString(z));
        for (int i = 1; i < z.length; i++) {
            if (i + z[i] == z.length)
                return i;
        }
        return 0;
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
