package revision_oct2025.strings;
/*
* Given a string reverse it word by word
* */
public class StringReversal {
    public static void main(String[] args) {
        String s = "The Sky Is Blue";
        System.out.println(reverseString(s));

    }

    static String reverseString(String s) {
        s = reverse(s);

        int left = 0, right = 0;
        while (right < s.length()) {
            if (s.charAt(right) == ' ' && left != right) {
                s = reverse(s, left, right - 1);
                left = right + 1;
                right = right + 1;
            } else {
                right++;
            }
        }
        if (right != left) {
            s = swap(s, left, right - 1);
        }


        return s;
    }

    static String reverse(String s, int left, int right) {
        while (left < right) {
            s = swap(s, left, right);
            left++;
            right--;
        }
        return s;
    }

    static String reverse(String s) {
       return reverse(s,0, s.length() - 1);
    }

    static String swap(String s, int left, int right) {
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(left);
        sb.setCharAt(left,sb.charAt(right));
        sb.setCharAt(right, temp);
        return sb.toString();
    }
}
