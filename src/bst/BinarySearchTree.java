package bst;

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
}
