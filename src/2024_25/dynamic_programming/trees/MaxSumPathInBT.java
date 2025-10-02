package dynamic_programming.trees;

import trees.BTNode;

/*
Given a binary tree T, find the maximum path sum.
The path may start and end at any node in the tree.
Note: A maximum sum path is any path which has the maximum
sum of the nodes lying on the path.

       20
      /  \
   -10   20
        /  \
      -10  -50

Answer:40
* */
public class MaxSumPathInBT {
    public static void main(String[] args) {
        BTNode<Integer> one = new BTNode<>(20);
        BTNode<Integer> two = new BTNode<>(-10);
        BTNode<Integer> three = new BTNode<>(20);
        BTNode<Integer> four = new BTNode<>(-10);
        BTNode<Integer> five = new BTNode<>(-50);

        one.setLeft(two);
        one.setRight(three);
        three.setLeft(four);
        three.setRight(five);

        int[] answer = {Integer.MIN_VALUE};
        solve(one, answer);
        System.out.println(answer[0]);

    }

    public static int solve(BTNode<Integer> root, int[] answer) {
        if (root == null) {
            return 0;
        }

        // calculate left and right answer
        int l = solve(root.getLeft(), answer);
        int r = solve(root.getRight(), answer);

        // calculate max at current root - 3 possibilities
        int max_single = Math.max(Math.max(l, r) + root.getValue(), root.getValue());

        // Overall max - all 4 possibilities
        int max_tree = Math.max(max_single, l + r + root.getValue());

        // Update global max
        answer[0] = Math.max(answer[0], max_tree);

        return max_single;
    }
}
