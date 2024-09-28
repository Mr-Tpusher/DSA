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

        for (int i = 0; i < texts.length; i++) {
            String text = texts[i];
            String pattern = patterns[i];
            boolean result = bruteForce(text, pattern);
            String verdict = result == outputs[i] ? "Passed" : "Failed";
            System.out.println("text:" + text + " , pattern:" + pattern);
            System.out.println("Expected:" + outputs[i] + ", Got:" + result);
            System.out.println("Test " + (i + 1) + " =>>> " + verdict);
        }
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
}
