package dsa_2024_25.bst;

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

        System.out.println(getKthSmallestRecursively(root,2, new int[]{0}));
    }

    public static Integer getKthSmallestUsingInorder(BinarySearchTree bst, int k) {
        if (k <= 0)
            return null;

        ArrayList<Integer> inorder = bst.inOrderTraversal();
        if (k > inorder.size())
            return null;
        return inorder.get(k - 1);
    }

    public static Integer getKthSmallestRecursively(BSTNode<Integer> root, int k, int[] currIndex) {
        if (root == null) {
            return null;
        }

        Integer leftAnswer = getKthSmallestRecursively(root.getLeft(), k, currIndex);
        if (leftAnswer != null)
            return leftAnswer;

        currIndex[0] = currIndex[0] + 1;
        if (k == currIndex[0])
            return root.getValue();

        return getKthSmallestRecursively(root.getRight(), k, currIndex);
    }
}

