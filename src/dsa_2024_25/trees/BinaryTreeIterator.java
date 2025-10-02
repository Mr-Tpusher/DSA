package dsa_2024_25.trees;

import java.util.NoSuchElementException;
import java.util.Stack;

/*
* Write an iterator for Binary Tree.
* Implement 2 functions: 1) hasNext() 2) getNext() in an inorder way.
*                       1
*                     /   \
*                   2       3
*                 /   \
*               4       5
*             /   \
*           6       7
*
* In order array = {6, 4, 7, 2, 5, 1, 3}
*
*
* */
public class BinaryTreeIterator {
    private Stack<BTNode<Integer>> stack;

    BinaryTreeIterator(BTNode<Integer> root) {
        stack = new Stack<>();
        if (root != null) {
            pushLeftNodes(root);
        }
    }

    private void pushLeftNodes(BTNode<Integer> node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public Integer getNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        BTNode<Integer> currNode = stack.pop();
        Integer result = currNode.getValue();

        if (currNode.getRight() != null) {
            pushLeftNodes(currNode.getRight());
        }

        return result;
    }

    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();

        BinaryTreeIterator itr = new BinaryTreeIterator(root);

        while (itr.hasNext()) {
            System.out.print(itr.getNext());
            System.out.print(" ");
        }
    }

    public static BTNode<Integer> constructBT() {
        // Create nodes
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);
        BTNode<Integer> six = new BTNode<>(6);
        BTNode<Integer> seven = new BTNode<>(7);

        // Set up the left and right children
        one.setLeft(two);
        one.setRight(three);

        two.setLeft(four);
        two.setRight(five);

        four.setLeft(six);
        four.setRight(seven);

        // Return the root of the tree
        return one;
    }
}
