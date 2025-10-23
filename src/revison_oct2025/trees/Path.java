package revison_oct2025.trees;

import java.util.ArrayList;

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

        System.out.println(findPathPreOrder(root, 7));
        System.out.println(findPathPreOrder(root, 8));
        System.out.println(findPathPreOrder(root, 6));
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

}
