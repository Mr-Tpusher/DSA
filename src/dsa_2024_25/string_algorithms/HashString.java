package dsa_2024_25.string_algorithms;

import java.util.Arrays;

public class HashString {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(hashString(s));

    }
    public static int hashString(String s) {
        final int P = 31;
        final int MOD = 1000000007;
        int length = s.length();
        int[] powers = getPowers(P, length);
        System.out.println(Arrays.toString(powers));

        int hashSum = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int val = c - 97;
            System.out.println(c + ":" + val);
            int contribution = val * powers[i];
            System.out.println(contribution);
            hashSum = ( (hashSum % MOD) + (contribution % MOD) ) % MOD;
        }
        System.out.println("hash for " + s + ":" + hashSum);

        return hashSum ;
    }

    public static int[] getPowers(int base, int totalExponents) {
        int[] powers = new int[totalExponents];
        for (int i = 0; i < totalExponents; i++) {
            powers[i] = (int) Math.pow(base, i);
        }
        return powers;
    }
}
