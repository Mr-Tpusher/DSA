package string_algorithms;
/*
 * Given a String text, find if substring pattern exists
 * Do not use in-built functions.
 * */
public class RabinKarp {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] texts = {"", "a", "", "iamironman", "iamironman", "iamironman", "iamironman"};
        String[] patterns = {"", "", "a", "ironm", "iamironman", "iamironmana", "am"};
        boolean[] outputs = {true, true, false, true, true, false, true};

        int totalPassed = 0, totalFailed = 0;
        for (int i = 0; i < texts.length; i++) {
            String text = texts[i];
            String pattern = patterns[i];
            boolean result = bruteForce(text, pattern);
            String verdict = null;
            if (result == outputs[i]) {
                verdict = "Passed";
                totalPassed++;
            } else {
                verdict = "Failed";
                totalFailed++;
            }
            System.out.println("text:" + text + " , pattern:" + pattern);
            System.out.println("Expected:" + outputs[i] + ", Got:" + result);
            System.out.println("Test " + (i + 1) + " =>>> " + verdict);
        }
        System.out.println("Total Test cases:" + texts.length + ", Passed:" + totalPassed +
                ", Failed:" + totalFailed);
    }

    public static boolean bruteForce(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        if (pattern.isEmpty()) {
            return true;
        }

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

        if (textLength < patternLength) {
            return false;
        } else if (patternLength == 0) {
            return true;
        }

        // Get the exponents to the prime number
        int[] powers = getPowers(P, patternLength + 1);

        // Calculate the hash for pattern and first substring
        int patternHash = 0;
        int textWindowHash = 0;
        for (int i = 0; i < patternLength; i++) {
            patternHash = (patternHash + (pattern.charAt(i) - 'a' + 1) * powers[i]) % MOD;
            textWindowHash = (textWindowHash + (text.charAt(i) - 'a' + 1)  * powers[i]) % MOD;
        }
        System.out.println("initial patternHash=" + patternHash);
        System.out.println("initial textWindowHash=" + textWindowHash);


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
            if (i < textLength - patternLength) {
                // Remove 1st char
                textWindowHash = textWindowHash - (text.charAt(i) - 'a' + 1) ;
                System.out.println("textWindowHash after removing first char "+ text.charAt(i) +
                        "=" + textWindowHash);

                // Add last char
                int newChar = text.charAt(i + patternLength) - 'a' + 1;
                System.out.println("newChar=" + newChar);
                int polynomialOfNewChar = (newChar * powers[patternLength]) % MOD;
                System.out.println("polynomialOfNewChar=" + polynomialOfNewChar);
                textWindowHash = textWindowHash + polynomialOfNewChar;
                System.out.println("textWindowHash=" + textWindowHash);

                // Calculate Mod
                textWindowHash = (int) (((textWindowHash * (long) pow(P, MOD - 2) ) % MOD));
                System.out.println("textWindowHash after adding last char: "+ newChar +
                        "=" + textWindowHash);
            }
        }
        return false;
    }


    public static int[] getPowers(int base, int totalExponents) {
        final int P = 31;
        final int MOD = 1000000007;
        int[] powers = new int[totalExponents];
        powers[0] = 1;
        for (int i = 1; i < totalExponents; i++) {
            powers[i] = (powers[i - 1] * P) % MOD;
        }
        return powers;
    }

    public static int pow(int base, int exponent) {
        final int MOD = 1000000007;

        if (exponent == 0) {
            return 1;
        }

        int pow = pow(base, exponent / 2);
        int pow2 = (int)(((long)(pow % MOD) * (long)(pow % MOD)) % MOD);

        if ((exponent & 1) == 1) { // exponent is odd
            return (int)(((pow2 % MOD) * (long)(base % MOD)) % MOD);
        } else {
            return pow2;
        }
    }
}
