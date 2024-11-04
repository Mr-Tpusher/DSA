package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given a binary tree, return the difference between sum of values of nodes at odd levels
* vs even levels.
*                   2
*                 /   \
*               1       2
*              / \     / \
*             4  3   1     1
*                   / \   / \
*                  5  2   4  3
*
* sum at odd levels: 2+4+3+1+1=11
* sum at even levels:1+2+5+2+4+3=17
* difference=11-17=-6
*
* */
public class OddEvenLevels {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();
        int ans = solve1(root);
        System.out.println(ans);

        // Recursive
        int ans2 = solveRecursively(root, 1);
        System.out.println(ans2);
    }

    // we can achieve this using simple level order traversal, where we also store
    // the level number in the queue.
    public static int solve1(BTNode<Integer> root) {
        Queue<NodeAndLevel> queue = new LinkedList<>();
        queue.offer(new NodeAndLevel(root, 1));
        int difference = 0;

        while (!queue.isEmpty()) {
            NodeAndLevel nodeAndLevel = queue.poll();
            BTNode<Integer> currNode = nodeAndLevel.node;
            Integer currLevel = nodeAndLevel.level;

            if (currLevel % 2 == 0) {
                difference -= currNode.getValue();
            } else {
                difference += currNode.getValue();
            }

            if (currNode.getLeft() != null)
                queue.offer(new NodeAndLevel(currNode.getLeft(), currLevel + 1));

            if (currNode.getRight() != null)
                queue.offer(new NodeAndLevel(currNode.getRight(), currLevel + 1));
        }

        return difference;
    }

    public static int solveRecursively(BTNode<Integer> root, int level) {
        if (root == null) {
            return 0;
        }

        int currentValue = 0;
        if (level % 2 == 0) {
            currentValue -= root.getValue();
        } else {
            currentValue += root.getValue();
        }

        return currentValue +
            solveRecursively(root.getLeft(), level + 1) +
            solveRecursively(root.getRight(), level + 1);
    }


    public static BTNode<Integer> constructBT() {
        BTNode<Integer> firstNode = new BTNode<>(2);
        BTNode<Integer> secondNode = new BTNode<>(1);
        BTNode<Integer> thirdNode = new BTNode<>(2);
        BTNode<Integer> fourthNode = new BTNode<>(4);
        BTNode<Integer> fifthNode = new BTNode<>(3);
        BTNode<Integer> sixthNode = new BTNode<>(1);
        BTNode<Integer> seventhNode = new BTNode<>(1);
        BTNode<Integer> eighthNode = new BTNode<>(5);
        BTNode<Integer> ninthNode = new BTNode<>(2);
        BTNode<Integer> tenthNode = new BTNode<>(4);
        BTNode<Integer> eleventhNode = new BTNode<>(3);

        firstNode.setLeft(secondNode);
        firstNode.setRight(thirdNode);
        secondNode.setLeft(fourthNode);
        secondNode.setRight(fifthNode);
        thirdNode.setLeft(sixthNode);
        thirdNode.setRight(seventhNode);
        sixthNode.setLeft(eighthNode);
        sixthNode.setRight(ninthNode);
        seventhNode.setLeft(tenthNode);
        seventhNode.setRight(eleventhNode);

        return firstNode;
    }
}
class NodeAndLevel {
    BTNode<Integer> node;
    Integer level;

    public NodeAndLevel(BTNode<Integer> node, Integer level) {
        this.node = node;
        this.level = level;
    }
}
