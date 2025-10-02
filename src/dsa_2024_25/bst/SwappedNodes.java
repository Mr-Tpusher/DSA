package dsa_2024_25.bst;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Given a BST, which has two of its nodes swapped, find the swapped pair.
*                   8
*                 /   \
*               12     10
*             /   \      \
*           3      7      5
*
* ans: 5,12
* */
public class SwappedNodes {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(5);
        bst.insert(10);
        bst.insert(3);
        bst.insert(7);
        BSTNode<Integer> root = bst.insert(12);

        root.getLeft().setValue(12);
        root.getRight().getRight().setValue(5);

        Integer[] swappedNodes = getSwappedNodes(bst);
        System.out.println(Arrays.toString(swappedNodes));
    }

    private static Integer[] getSwappedNodes(BinarySearchTree bst) {
        ArrayList<Integer> inorder = bst.inOrderTraversal();
        System.out.println(inorder);

        Integer first = null, second = null;
        Integer prev = Integer.MIN_VALUE;

        for (int curr : inorder) {
            if (curr < prev) {
                if (first == null) {
                    first = prev;
                }
                second = curr;
            }
            prev = curr;
        }

        return new Integer[] {first, second};
    }
}
