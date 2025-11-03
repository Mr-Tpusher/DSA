package revision_oct2025.dynamic_programming.recursion_backtracking;

import java.util.ArrayList;

/*
* Given a String find all subsequences of it.
* */
public class Subsequence {
    public static void main(String[] args) {
        String s = "abcd";
        getAllSubsequences(s);
    }

    static void getAllSubsequences(String s) {
        ArrayList<String> result = new ArrayList<>();
        helper(s, 0, new StringBuilder(),  result);
        System.out.println(result);
    }

    static void helper(String s, int index, StringBuilder curr,ArrayList<String> all ) {
        if (index == s.length()) {
            all.add(curr.toString());
            return;
        }

        // add current
        curr.append(s.charAt(index));
        helper(s, index + 1, curr, all);

        // remove current
        curr.deleteCharAt(curr.length() - 1);
        helper(s, index + 1, curr, all);
    }
}
