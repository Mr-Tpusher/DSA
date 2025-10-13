package revison_oct2025.stack;

import java.util.Stack;

/*
There is a football event going on in your city. In this event,
you are given A passes and players having ids between 1 and 10^6.

Initially, some player with a given id had the ball in his possession.
You have to make a program to display the id of the player who possessed the ball after exactly A passes.

There are two kinds of passes:
    1) ID
    2) 0

For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.
For the second kind of pass, the player in possession of the ball passes the ball back to
the player who had forwarded the ball to him.

In the second kind of pass "0" just means Back Pass.

Return the ID of the player who currently possesses the ball.

*/
public class PassingGame {
    public static void main(String[] args) {
        int A = 10;
        int B = 23;
        int[] C = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};

        System.out.println(solve(A, B, C));
    }

    static int solve(int A, int B, int[] C) {
        Stack<Integer> passes = new Stack<>();
        for (int i = 0; i < A; i++) {
            if (C[i] == 0) {
                passes.pop();
            } else {
                passes.push(C[i]);
            }
        }

        if (passes.isEmpty())
            return B;
        else
            return passes.peek();
    }
}
