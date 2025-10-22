package revison_oct2025.bst;

import java.util.ArrayList;

public class BinarySearchTree {

    public static void main(String[] args) {
        int[] a = {10, 15, 1, 5, 7, 3, 20, 2, 13, 6};
        BSTNode root = null;
        for (int i : a) {
            root = insert(root, i);
        }
        printBST(root);

        root = delete(root, 7);
        printBST(root);

    }

    static BSTNode constructBST(int[] arr) {
        BSTNode root = null;
        for (int i : arr) {
            root = insert(root, i);
        }
        return root;
    }

    static void printBST(BSTNode root) {
        System.out.println(inOrderTraversal(root, new ArrayList<Integer>()));
    }

    static ArrayList<Integer> inOrderTraversal(BSTNode root, ArrayList<Integer> bst) {
        if (root == null)
            return bst;

        inOrderTraversal(root.left, bst);
        bst.add(root.val);
        inOrderTraversal(root.right, bst);
        return bst;

    }

    static BSTNode insert(BSTNode root, int val) {
        if (root == null)
            return new BSTNode(val);

        if (val <= root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static BSTNode delete(BSTNode node, int val) {
        if (node == null) return null;

        if (val == node.val) {
            // node to be deleted is found, check all 3 possible scenarios

            // 1. nodeToBeDeleted is a leaf node
            if (node.left == null && node.right == null)
                return null;

            // 2. nodeToBeDeleted has a single child
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            // 3. nodeToBeDeleted has 2 children
            BSTNode successor = inOrderSuccessor(node);
            node.val = successor.val;
            node.right = delete(node.right, successor.val);

            return node;

        } else if (val < node.val) {
            node.left = delete(node.left, val);
        } else {
            node.right = delete(node.right, val);
        }

        return node;
    }

    static BSTNode inOrderSuccessor(BSTNode node) {
        BSTNode temp = node.right;
        while (temp.left != null)
            temp = temp.left;
        return temp;
    }

}
