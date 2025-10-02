package dsa_2024_25.stacks;
/*
* There's a football game with 20 players.
* the game allows 2 types of operations:
* 1) Pass forward to a player
* 2) Return to the player who passed me
*
* Initially the ball is with the player1.
* The input is given as a series of operations.
* Return the player number having the ball at the end, return -1 if the input is wrong.
* e.g. PF(2), PF(5), RP, PF(11), RP             answer:2
* */
public class FootballGame {
    public static void main(String[] args) {
        int[] input = {2, 5, 0, 11, 0};
        System.out.println(play(input));
    }

    public static int play(int[] input) {
        if (input == null || input.length == 0) return 1;
        Stack<Integer> passes = new Stack<>();
        for (int player : input) {
            if (player == 0) {
                if (passes.isEmpty()) return -1;
                passes.pop();
            } else {
                passes.push(player);
            }
        }
        return passes.isEmpty() ? 1 : passes.peek();
    }
}
