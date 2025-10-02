package dsa_2024_25.bst;

import java.util.ArrayList;

public class BinarySearchTree {

    BSTNode<Integer> root;

    BinarySearchTree() {
        this.root = null;
    }

    public BSTNode<Integer> insert(int value) {
        root = insertRecursively(root, value);
        return root;
    }

    private BSTNode<Integer> insertRecursively(BSTNode<Integer> node, int value) {
        if (node == null) {
            return new BSTNode<>(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insertRecursively(node.getLeft(), value));
        } else {
            node.setRight(insertRecursively(node.getRight(), value));
        }
        return node;
    }

    public BSTNode<Integer> buildBST(int[] input) {
        if (input == null) {
            return root;
        }
        for (int value : input) {
            root = insert(value);
        }
        return root;
    }

    public boolean search(int value) {
        return searchRecursively(root, value);
    }


    private boolean searchRecursively(BSTNode<Integer> root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.getValue()) {
            return true;
        }
        if (value < root.getValue()) {
            return searchRecursively(root.getLeft(), value);
        } else {
            return searchRecursively(root.getRight(), value);
        }
    }

    public ArrayList<Integer> inOrderTraversal() {
        ArrayList<Integer> inorder = new ArrayList<>();
        recursiveInorder(root, inorder);
        return inorder;
    }

    private void recursiveInorder(BSTNode<Integer> root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        recursiveInorder(root.getLeft(), inorder);
        inorder.add(root.getValue());
        recursiveInorder(root.getRight(), inorder);
    }
}

