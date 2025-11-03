package revision_oct2025.dynamic_programming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String a = "zacbdf";
        String b = "dazcd";
        System.out.println(bruteForceBackward(a, b));
        System.out.println(bruteForce2Forward(a, b));

    }

    static int bruteForceBackward(String a, String b) {
        return backwardHelper(a, b, a.length() - 1, b.length() - 1);
    }


    static int bruteForce2Forward(String a, String b) {
        return forwardHelper(a, b, 0, 0);
    }

    static int backwardHelper(String a, String b, int aIndex, int bIndex) {
        if (aIndex < 0 || bIndex < 0) return 0;

        // when char match
        if (a.charAt(aIndex) == b.charAt(bIndex)) {
            return 1 + backwardHelper(a, b, aIndex - 1, bIndex - 1);
        }

        // when chars don't match, we explore both possibilities
        int first = backwardHelper(a, b, aIndex, bIndex - 1);
        int second = backwardHelper(a, b, aIndex - 1, bIndex);

        return Math.max(first, second);
    }

    static int forwardHelper(String a, String b, int indexA, int indexB) {
        if (indexA == a.length() || indexB == b.length()) return 0;

        if (a.charAt(indexA) == b.charAt(indexB)) {
            return 1 + forwardHelper(a, b, indexA + 1, indexB + 1);
        }

        int first = forwardHelper(a, b, indexA, indexB + 1);
        int second = forwardHelper(a, b, indexA + 1, indexB);

        return Math.max(first, second);
    }

}
