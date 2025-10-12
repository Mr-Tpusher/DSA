package revison_oct2025.string_algo;
/*
* Rabin Karp is used to find if a pattern exists in a String.
* */
public class RabinKarp {
    public static void main(String[] args) {
        String s = "I am Alan Turing.";
        String pattern = "lan";
        System.out.println(bruteForce(s, pattern));


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

        for (int i = 0; i < stringLength - patternLength; i++) {
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
}
