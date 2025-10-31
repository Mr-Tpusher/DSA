package revision_oct2025.misc;

public class PatternMatching {

    static final int BASE = 31;
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        String text = "iamalanturing";
        String pattern = "alan";

        //System.out.println(getPower(5,4));
        long start = System.nanoTime();
        System.out.println(isPatternPresent(text, pattern));
        long end = System.nanoTime();
        System.out.println("total duration = " + (end - start));

    }


    private static boolean isPatternPresent(String text, String pattern) {

        if (pattern == null || text == null || pattern.length() > text.length())
            return false;

        if (pattern.isEmpty())
            return true;


        // we will be using Rabin Karp -> Rolling polynomial hash function

        int highestPower = pattern.length() - 1;

        long[] powers = getPowers(highestPower);

        long patternHash = 0;
        long windowHash = 0;
        for (int i = 0; i < pattern.length(); i++) {
            patternHash = (patternHash + (pattern.charAt(i) * powers[highestPower - i]) % MOD) % MOD;
            windowHash = (windowHash + (text.charAt(i) * powers[highestPower - i]) % MOD) % MOD;
        }

        if (windowHash == patternHash)
            return true;

        // slide the window
        int i = 1, j = pattern.length();

        while (j < text.length()) {
            // roll the window

            // subtract the first character from last window
            windowHash = (windowHash - (text.charAt(i - 1) * powers[highestPower]) % MOD + MOD) % MOD;

            // multiply by base
            windowHash = (windowHash * BASE) % MOD;

            // add the new char which is last char of the new window
            windowHash = (windowHash + text.charAt(j)) % MOD;

            // if hash matches, do check actual string because two different strings could produce same hash i.e. collision
            if (windowHash == patternHash && text.substring(i, j + 1).equals(pattern))
                return true;

            i++;
            j++;
        }

        return false;
    }


    static long[] getPowers(int maxPower) {
        long[] powers = new long[maxPower + 1];
        powers[0] = 1;

        for (int i = 1; i < powers.length; i++) {
            powers[i] = (powers[i - 1] * BASE) % MOD;
        }

        return powers;
    }
}
