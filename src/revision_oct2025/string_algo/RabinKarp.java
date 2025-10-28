package revision_oct2025.string_algo;
/*
* Rabin Karp is used to find if a pattern exists in a String.
* */
public class RabinKarp {
    public static void main(String[] args) {
        String s = "I am Alan Turing";
        String pattern = "ing";
        System.out.println(bruteForce(s, pattern));
        System.out.println(rabinKarp(s, pattern));


    }

    static boolean bruteForce(String string, String pattern) {
        int stringLength = string.length();
        int patternLength = pattern.length();

        if (patternLength == 0) {
            return true;
        }
        if (patternLength > stringLength) {
            return false;
        }

        for (int i = 0; i <= stringLength - patternLength; i++) {
            int j = 0;
            while (j < patternLength && string.charAt(i+j) == pattern.charAt(j)) {
                j++;
            }
            if (j == patternLength) {
                return true;
            }
        }
        return false;
    }

    static boolean rabinKarp(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        if (patternLength == 0)
            return true;
        if (patternLength > textLength)
            return false;

        int base = 31;
        int MOD = 1_000_000_007;

        int highestPower = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            highestPower = (highestPower * base) % MOD;
        }

        int patternHash = 0;
        int windowHash = 0;
        for (int i = 0; i < patternLength; i++) {
            patternHash = (patternHash * base + pattern.charAt(i)) % MOD;
            windowHash = (windowHash * base + text.charAt(i)) % MOD;
        }


        for (int i = 0; i <= textLength - patternLength; i++) {
            // check equality of the hashes, if matched check actual substring
            if (patternHash == windowHash) {
                if (text.substring(i, i + patternLength).equals(pattern))
                    return true;
            }

            // roll the hash
            if (i < textLength - patternLength) {
                windowHash = (windowHash - text.charAt(i) * highestPower) % MOD;
                if (windowHash < 0) windowHash += MOD;
                windowHash = ((windowHash * base) + text.charAt(i + patternLength)) % MOD;
            }
        }

        return false;
    }

}
