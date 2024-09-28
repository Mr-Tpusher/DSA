package string_algorithms;

/*
 * Given a String text, find if substring pattern exists
 * Do not use in-built functions.
 *
 * */
public class RabinKarp {
    public static void main(String[] args) {
        String text = "iambatman";
        String pattern = "iambatman";
        System.out.println(bruteForce(text, pattern));
        System.out.println(rabinKarp(text, pattern));
    }

    public static boolean bruteForce(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++) {
            for (int j = i, k = 0; j < textLength && k < patternLength; j++, k++) {
                if (text.charAt(j) == pattern.charAt(k)) {
                    if (k == patternLength - 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    // Rabin Karp algo
    public static boolean rabinKarp(String text, String pattern) {
        final int P = 31;
        final int MOD = 1000000007;

        int textLength = text.length();
        int patternLength = pattern.length();

        if (patternLength > textLength) {
            return false;
        }
        // Get the exponents to the prime number
        int[] powers = getPowers(P, patternLength + 1);

        // Calculate the hash for pattern and first substring
        int patternHash = 0;
        int textWindowHash = 0;
        for (int i = 0; i < patternLength; i++) {
            patternHash = ((patternHash % MOD) + (pattern.charAt(i) * powers[i] % MOD)) % MOD;
            textWindowHash = ((textWindowHash % MOD) + (text.charAt(i) * powers[i] % MOD)) % MOD;
        }


        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textWindowHash) {
                for (int j = i, k = 0; k < patternLength; j++, k++) {
                    if (text.charAt(j) == text.charAt(i + k)) {
                        if (k == patternLength - 1) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }

            // get next hash
            int temp = textWindowHash - (text.charAt(i) - 97) +
                    text.charAt(i + patternLength) * powers[patternLength];

            textWindowHash = ((temp % MOD) * ((int) Math.pow(P, MOD - 2))) % MOD;
        }
        return false;
    }


    public static int[] getPowers(int base, int totalExponents) {
        int[] powers = new int[totalExponents];
        for (int i = 0; i < totalExponents; i++) {
            powers[i] = (int) Math.pow(base, i);
        }
        return powers;
    }
}
