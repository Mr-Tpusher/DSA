package trees;

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
 * Inorder: 4,2,1,5,3,6,7
 *
 * */
public class IterativeInOrder {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();
        ArrayList<Integer> inorder = iterativeInorderTraversal(root);
        System.out.println(inorder);
    }

    private static ArrayList<Integer> iterativeInorderTraversal(BTNode<Integer> root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        Stack<BTNode<Integer>> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                BTNode<Integer> temp = stack.pop();
                inorder.add(temp.getValue());
                root = temp.getRight();
            }
        }
        return inorder;
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

