package bst;

import java.util.ArrayList;

/*
* Given a BST, find the Kth smallest element(1 based indexed).
*                   3
*                 /   \
*               1       4
*                 \
*                   2
* k=2, answer:2
*
* */
public class KthSmallest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode<Integer> root = bst.buildBST(new int[] {3,1,4,2});
        System.out.println(getKthSmallestUsingInorder(bst,2));

    }

    public static Integer getKthSmallestUsingInorder(BinarySearchTree bst, int k) {
        if (k <= 0)
            return null;

        ArrayList<Integer> inorder = bst.inOrderTraversal();
        if (k > inorder.size())
            return null;
        return inorder.get(k - 1);
    }
}

