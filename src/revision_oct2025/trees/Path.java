package revision_oct2025.trees;

import java.util.ArrayList;
import java.util.Collections;

/*
* Given root of the tree and a node, find the path from the root to the node.
*
*                   1
*                 /   \
*                2      3
*              /  \      \
*            4     5      6
*           /       \
*          7         8
*           \
*            9
*
*
* */
public class Path {
    public static void main(String[] args) {
        BTNode root = BinaryTree.buildTree(new int[] {1, 2, 3, 4, 5, -1, 6, 7, -1, -1, 8, -1, -1, -1, 9});

        System.out.println("find path using preorder: " + findPathPreOrder(root, 7));
        System.out.println("find path using postorder: " + findPathPostOrder(root, 7));
        System.out.println("find path using preorder: " + findPathPreOrder(root, 8));
        System.out.println("find path using postorder: " + findPathPostOrder(root, 8));
        System.out.println("find path using preorder: " + findPathPreOrder(root, 6));
        System.out.println("find path using postorder: " + findPathPostOrder(root, 6));
    }

    static ArrayList<Integer> findPathPreOrder(BTNode root, int node) {
        ArrayList<Integer> path = new ArrayList<>();
        findPathPreOrderRec(root, node, path);
        return path;
    }

    private static boolean findPathPreOrderRec(BTNode curr, int node, ArrayList<Integer> path) {
        if (curr == null)
            return false;

        // process current node
        path.add(curr.val);
        if (curr.val == node) {
            return true;
        }

        // recurse left and right children
        boolean left = findPathPreOrderRec(curr.left, node, path);
        boolean right = findPathPreOrderRec(curr.right, node, path);

        if (!left && !right) {
            path.remove(path.size() - 1);
            return false;
        }
        return true;
    }

    static ArrayList<Integer> findPathPostOrder(BTNode root, int node) {
        ArrayList<Integer> path = new ArrayList<>();
        findPathPostOrderRec(root, node, path);
        Collections.reverse(path);
        return path;
    }


    private static boolean findPathPostOrderRec(BTNode curr, int node, ArrayList<Integer> path) {
        if (curr == null)
            return false;

        /*
            base case (pruning)
            when we find the node
                1. add it to the path
                2. stop the recursion from going further down
        *
        * */
        if (curr.val == node) {
            path.add(curr.val);
            return true;
        }

        // recurse left and right children
        boolean left = findPathPostOrderRec(curr.left, node, path);
        boolean right = findPathPostOrderRec(curr.right, node, path);

        if (left || right) {
            path.add(curr.val);
            return true;
        }
        return false;
    }


}
