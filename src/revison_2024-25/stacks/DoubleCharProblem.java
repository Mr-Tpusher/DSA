package stacks;
/*
* Given a string, keep reducing the string till there are no two similar characters together.
* e.g. abbbcddca => ""
* */
public class DoubleCharProblem {
    public static void main(String[] args) {
        String s = "abbcddcatstsa";
        System.out.println(solve(s));
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
