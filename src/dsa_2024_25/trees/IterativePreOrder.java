package dsa_2024_25.trees;

import java.util.ArrayList;
import java.util.Stack;

/*
 *               1
 *              / \
 *             2   3
 *           /    / \
 *          4    5   6
 *                    \
 *                     7
 *
 * preorder: 1,2,4,3,5,6,7
 *
 *
 * */
public class IterativePreOrder {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();
        ArrayList<Integer> preorder = iterativePreorderTraversal(root);
        System.out.println(preorder);
    }

    private static ArrayList<Integer> iterativePreorderTraversal(BTNode<Integer> root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        Stack<BTNode<Integer>> stack = new Stack<>();
        BTNode<Integer> currNode = root;

        while (currNode != null || !stack.isEmpty()) {
            if (currNode != null) {
                preorder.add(currNode.getValue());
                stack.push(currNode);
                currNode = currNode.getLeft();
            } else {
                currNode = stack.pop().getRight();
            }
        }
        return preorder;
    }

    public static BTNode<Integer> constructBT() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);
        BTNode<Integer> six = new BTNode<>(6);
        BTNode<Integer> seven = new BTNode<>(7);

        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        three.setLeft(five);
        three.setRight(six);
        six.setRight(seven);

        return one;
    }

}
