package revison_oct2025.trees;

import java.util.ArrayList;

public class LCABinaryTree {
    public static void main(String[] args) {
        BTNode root = BinaryTree.buildTree(new int[] {1, 2, 3, 4, 5, -1, 6, 7, -1, -1, 8, -1, -1, -1, 9});
        System.out.println(lcaBruteForce(root, 7, 5));
    }

    static int lcaBruteForce(BTNode root, int node1, int node2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        pathFromRoot(root, node1, path1);
        pathFromRoot(root, node2, path2);
        System.out.println(path1);
        System.out.println(path2);
        int lca = -1;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i).equals(path2.get(i))) {
                lca = path1.get(i);
            } else break;
        }
        return lca;
    }

    static boolean pathFromRoot(BTNode root, int val, ArrayList<Integer> path) {
        if (root == null)
            return false;

        path.add(root.val);
        if (root.val == val) {
            return true;
        }

        boolean left = pathFromRoot(root.left, val, path);
        boolean right = pathFromRoot(root.right, val, path);

        if (!left && !right) {
            path.remove(path.size() - 1);
            return false;
        }
        return true;
    }
}
