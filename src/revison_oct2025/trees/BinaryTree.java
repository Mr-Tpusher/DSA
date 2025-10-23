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

    static void inOrder(BTNode root, ArrayList<Integer> inOrderTraversal) {
        if (root == null)
            return;

        inOrder(root.left, inOrderTraversal);
        inOrderTraversal.add(root.val);
        inOrder(root.right, inOrderTraversal);
    }
}
