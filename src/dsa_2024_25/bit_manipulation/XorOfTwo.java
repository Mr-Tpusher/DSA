package dsa_2024_25.bit_manipulation;
/*
 * Given an array, Find two such elements
 * whose XOR is K
 */

import java.util.*;
public class XorOfTwo {
    public static void main(String[] args) {
        int[] A = {1, 5, 8, 3, 11};
        int k = 11;

        // A ^ B = k i.e. A ^ A ^ B = A ^ K
        // B = A ^ K

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            hs.add(A[i]);
        }

        int first, second;
        first = second = 0;
        for (int i = 0; i < A.length; i++) {
            int B = A[i] ^ k;
            if (hs.contains(B)) {
                break;
            }
            first = A[i];
            second = B;
        }

        System.out.println( first + "," + second);
    }
}
