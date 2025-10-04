package dsa_2024_25.stacks;

import dsa_2024_25.util.Pair;

/*
* Given a string s and a number k, everytime we iterate over the string and find k same characters,
* remove those k characters.
* 1. s=abbba, k=3   answer:aa
* 2. s=abbbba k=3   answer:aba
* */
public class KSameCharacters {
    public static void main(String[] args) {
        String s = "saabbbbabbbbata";
        int k = 4;
        System.out.println(solve(s, k));
    }

    public static String solve(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new Pair<>(c, 1));
                continue;
            }
            Pair<Character, Integer> top = stack.peek();
            if (top.getFirst() == c) {
                int currFreq = top.getSecond();
                if (currFreq == k - 1) {
                    stack.pop();
                } else {
                    top.setSecond(++currFreq);
                }
            } else {
                stack.push(new Pair<>(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop().getFirst());
        }
        return sb.toString();
    }
}
