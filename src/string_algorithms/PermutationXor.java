package string_algorithms;
/*
* Given a binary string B, find all cyclic permutations of B, such that
* B xor CP[B] = 0, return the count;
* */
public class PermutationXor {
    public static void main(String[] args) {
        String B = "1010";
        System.out.println(xorCount(B));
    }

    public static int xorCount(String B) {
        StringBuilder modifiedB = new StringBuilder(B + B);
        modifiedB.deleteCharAt(modifiedB.length() - 1);
        modifiedB.deleteCharAt(0);
        modifiedB = new StringBuilder(B + '$' + modifiedB);

        int[] z = zAlgo(modifiedB.toString());
        int count = 0;
        for (int i : z) {
            if (i == B.length())
                count++;
        }
        return count;
    }

    public static int[] zAlgo(String s) {
        int length = s.length();
        int left = 0, right = 0;
        int[] z = new int[length];
        z[0] = length;
        for (int i = 1; i < length; i++) {
            if (i > right) {
                left = i;
                right = i;
                while (right < length && s.charAt(right - left) == s.charAt(right)) {
                    right++;
                }
                z[i] = right - left;
                --right;
            } else {
                int j = i - left; // corresponding matching element on left
                if (z[j] < right - i + 1) {
                    z[i] = z[j];
                } else {
                    // here the answer should be rest of the window + manual compare
                    // we would simply change the window
                    // just change the left pointer, right pointer would've already been
                    // outside prev window, and we need to compare this element
                    left = i;
                    while (right < length && s.charAt(right - left) == s.charAt(right)) {
                        right++;
                    }
                    z[i] = right - left;
                    --right;
                }
            }
        }
        return z;
    }
}
