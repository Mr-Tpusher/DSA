package dsa_2024_25.stacks;
/*
* Evaluate given postfix expressions.
* 1. {7,5,+,4,*}    answer:48
* */
public class PostfixExpressions {
    public static void main(String[] args) {
        String s= "7,5,+,4,*,12,/,2,-";
        System.out.println(solve(s));
    }
    public static int solve(String s) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = s.split(",");

        for (String token : tokens) {

            try {
                int n = Integer.parseInt(token);
                stack.push(n);
            } catch (NumberFormatException e) {
                int second = stack.pop();
                int first = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
