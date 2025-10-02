package dsa_2024_25.string_algorithms;

import java.util.Arrays;

/*
 * Find if B is a substring of A.
 *
 * */
public class CheckSubString {
    public static void main(String[] args) {
        String A = "iamironman";
        String B = "iron";
        System.out.println(bruteForce(A, B));
        System.out.println(checkSubstringUsingZAlgo(A, B));
    }

    public static boolean bruteForce(String A, String B) {
        for (int i = 0; i <= A.length() - B.length(); i++) {
            int j = 0;
            while (j < B.length() && A.charAt(i + j) == B.charAt(j)) {
                j++;
            }
            if (j == B.length()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSubstringUsingZAlgo(String A, String B) {
        char delimiter = '$';
        String combinedString = B + delimiter + A;
        int length = combinedString.length();
        int left = 0, right = 0;
        int[] z = new int[length];
        z[0] = length;
        for (int i = 1; i < length; i++) {
            if (i > right) {
                left = i;
                right = i;

                while (right < length && combinedString.charAt(right) == combinedString.charAt(right - left)) {
                    right++;
                }
                z[i] = right - left;
                right--;
            } else {
                int j = i - left; // corresponding matching substring element
                if (z[j] < right - i + 1) {
                    z[i] = z[j];
                } else {
                    // start a new window
                    left  = i;
                    while (right < length && combinedString.charAt(right) == combinedString.charAt(right - left)) {
                        right++;
                    }
                    z[i] = right - left;
                    right--;
                }
            }
        }
        System.out.println(Arrays.toString(z));

        for (int i : z) {
            if (i == B.length()) {
                return true;
            }
        }
        return false;
    }
}
