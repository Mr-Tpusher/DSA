package revison_oct2025.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        BTNode root = buildTree(new int[] {1, 2, 3, 4, 5, -1, 6, 7, -1, -1, 8, -1, -1, -1, 9});
        System.out.println("InOrder traversal:" + inOrder(root));
    }

    static BTNode buildTree(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        BTNode root = new BTNode(arr[0]);
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length && !queue.isEmpty()) {
            BTNode curr = queue.poll();

            if (arr[i] != -1) {
                curr.left = new BTNode(arr[i]);
                queue.offer(curr.left);
            }
            if (i + 1 < arr.length && arr[i+1] != -1) {
                curr.right = new BTNode(arr[i + 1]);
                queue.offer(curr.right);
            }
            i+=2;
        }
        return root;
    }

    static ArrayList<Integer> inOrder(BTNode root) {
        ArrayList<Integer> inOrderTraversal = new ArrayList<>();
        inOrder(root, inOrderTraversal);
        return inOrderTraversal;
    }

    static void inOrder(BTNode node, ArrayList<Integer> inOrderTraversal) {
        if (node == null)
            return;

        inOrder(node.left, inOrderTraversal);
        inOrderTraversal.add(node.val);
        inOrder(node.right, inOrderTraversal);
    }

    static ArrayList<Integer> preOrder(BTNode root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        preOrderHelper(root, preorder);
        return preorder;
    }

    private static void preOrderHelper(BTNode node, ArrayList<Integer> preorder) {
        if (node == null)
            return;

        preorder.add(node.val);
        preOrderHelper(node.left, preorder);
        preOrderHelper(node.right, preorder);
    }


    static ArrayList<Integer> postOrder(BTNode root) {
        ArrayList<Integer> postorder = new ArrayList<>();
        postOrderHelper(root, postorder);
        return postorder;
    }

    private static void postOrderHelper(BTNode node, ArrayList<Integer> postorder) {
        if (node == null)
            return;

        postOrderHelper(node.left, postorder);
        postOrderHelper(node.right, postorder);
        postorder.add(node.val);
    }

    static void printTree(BTNode root) {
        printTreeHelper(root, 0);
    }

    // Helper function to print the tree with indentation
    private static void printTreeHelper(BTNode node, int level) {
        if (node == null) {
            return;
        }
        // Print right subtree first (will appear on top)
        printTreeHelper(node.right, level + 1);

        // Print current node after spaces proportional to level
        for (int i = 0; i < level; i++) {
            System.out.print("    "); // 4 spaces per level
        }
        System.out.println(node.val);

        // Print left subtree (will appear at bottom)
        printTreeHelper(node.left, level + 1);
    }
}
