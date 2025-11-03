package revision_oct2025.dynamic_programming;
/*
* Given 2 strings, convert String A to String B, only 3 operations are allowed:
* 1. insert a char
* 2. deleted a char
* 3. replace a char
*
*
*
* */
public class EditDistance {
    public static void main(String[] args) {
        String A = "anshuman";
        String B = "antihuman";

        System.out.println(bruteForce(A, B));

    }

    static int bruteForce(String A, String B) {
        return bruteForceHelper(A, B, 0, 0);
    }

    static int bruteForceHelper(String A, String B, int indexA, int indexB) {
        if (indexA == A.length()) {
            return B.length() - indexB;
        }
        if (indexB == B.length()) {
            return A.length() - indexA;
        }

        if (A.charAt(indexA) == B.charAt(indexB)) {
            return bruteForceHelper(A, B, indexA + 1, indexB + 1);
        }

        int replace = 1 + bruteForceHelper(A, B, indexA + 1, indexB + 1);
        int insert = 1 + bruteForceHelper(A, B, indexA, indexB + 1);
        int delete = 1 + bruteForceHelper(A, B, indexA + 1, indexB);

        return Math.min(Math.min(replace, insert), delete);
    }
}
