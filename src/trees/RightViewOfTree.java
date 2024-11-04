package trees;
/*
* Given a tree, print the right view of the tree.
*                           1
*                         /   \
*                       2       3
*                             /   \
*                            4      5
*                           /      / \
*                          7      6   8
*                         /
*                        9
*
* Right view: 1,3,5,8,9
* */

import java.util.ArrayDeque;
import java.util.ArrayList;

public class RightViewOfTree {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();

        // Iterative
        ArrayList<Integer> rightView = getRightView(root);
        System.out.println(rightView);

        // Recursive
        ArrayList<Integer> rightView2 = new ArrayList<>();
        getRightViewRecursively(root, new int[]{-1}, 0, rightView2);
        System.out.println(rightView2);

    }
    // right view is basically level order traversal where we are printing the last node.
    public static ArrayList<Integer> getRightView(BTNode<Integer> root) {
        ArrayDeque<BTNode<Integer>> currQueue = new ArrayDeque<>();
        ArrayList<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }

        currQueue.offer(root);

        while (!currQueue.isEmpty()) {

            ArrayDeque<BTNode<Integer>> nextQueue = new ArrayDeque<>();
            rightView.add(currQueue.peekLast().getValue());
            for (BTNode<Integer> node : currQueue) {
                if (node.getLeft() != null) {
                    nextQueue.offer(node.getLeft());
                }

                if (node.getRight() != null) {
                    nextQueue.offer(node.getRight());
                }
            }

            currQueue = nextQueue;
        }
        return rightView;
    }

    public static void getRightViewRecursively(BTNode<Integer> root, int[] globalLevel, int currLevel,
                                               ArrayList<Integer> rightView) {
        if (root == null) {
            return;
        }

        if (currLevel > globalLevel[0]) {
            rightView.add(root.getValue());
            globalLevel[0] = currLevel;
        }
        getRightViewRecursively(root.getRight(), globalLevel, currLevel + 1, rightView);
        getRightViewRecursively(root.getLeft(), globalLevel, currLevel + 1, rightView);
    }


    // Function to construct the binary tree
    public static BTNode<Integer> constructBT() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);
        BTNode<Integer> six = new BTNode<>(6);
        BTNode<Integer> seven = new BTNode<>(7);
        BTNode<Integer> eight = new BTNode<>(8);
        BTNode<Integer> nine = new BTNode<>(9);

        one.setLeft(two);
        one.setRight(three);
        three.setLeft(four);
        three.setRight(five);
        four.setLeft(seven);
        five.setLeft(six);
        five.setRight(eight);
        seven.setLeft(nine);

        return one; // Return the root node
    }
}
