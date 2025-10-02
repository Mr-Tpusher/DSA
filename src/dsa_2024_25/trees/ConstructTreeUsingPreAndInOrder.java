package dsa_2024_25.trees;

import java.util.Arrays;

/*
* Given preorder and inorder traversal of a tree.
* construct the tree and return the root node.
* preorder = 1,2,3,4,5,6
* inorder  = 2,1,4,3,6,5
* */
public class ConstructTreeUsingPreAndInOrder {

    public static void main(String[] args) {
        
        int[] preorder = {1, 2, 3, 4, 5, 6};
        int[] inorder  = {2, 1, 4, 3, 6, 5};

        BTNode<Integer> root = construct(preorder, inorder);

        printTree(root);
    }

    private static BTNode<Integer> construct(int[] preorder, int[] inorder) {
        
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        BTNode<Integer> rootNode = new BTNode<>(preorder[0]);

        int rootNodeIndex = getRootNodeIndex(inorder, rootNode.getValue());
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootNodeIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootNodeIndex + 1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);

        rootNode.setLeft(construct(leftPreorder, leftInorder));
        rootNode.setRight(construct(rightPreorder, rightInorder));

        return rootNode;
    }

    private static int getRootNodeIndex(int[] inorder, int rootValue) {

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue)
                return i;
        }
        throw new IllegalArgumentException("Value not found in array.");
    }

    private static void printTree(BTNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        printTree(root.getLeft());
        printTree(root.getRight());
    }
}
