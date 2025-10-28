package revision_oct2025.bst;
/*
*                         10
*                       /    \
*                     1        15
*                      \       / \
*                       5     13  20
*                      /  \
*                     3    7
*                   /     /
*                  2     6
*
*
* */
public class LCAInBST {
    public static void main(String[] args) {
        int[] a = {10, 15, 1, 5, 7, 3, 20, 2, 13, 6};
        BSTNode root = BinarySearchTree.constructBST(a);
        System.out.println(BinarySearchTree.inOrderTraversal(root));
        System.out.println(getLca(root, 5, 20));
        System.out.println(getLca(root, 2, 6));
        System.out.println(getLca(root, 15, 13));
        System.out.println(getLca(root, 10, 200));

    }

    static int getLca(BSTNode root, int A, int B) {
        return getLcaHelper(root, A, B);
    }

    static int getLcaHelper(BSTNode root, int A, int B) {
        if (root == null)
            return -1;

        if (A < root.val && B < root.val)
            return getLcaHelper(root.left, A, B);
        if (A > root.val && B > root.val)
            return getLca(root.right, A, B);
        else
            return searchInBst(root, A) && searchInBst(root, B) ? root.val : -1;
    }

    static boolean searchInBst(BSTNode node, int val) {
        if (node == null)
            return false;

        if (val == node.val)
            return true;
        else if (val < node.val)
            return searchInBst(node.left, val);
        else
            return searchInBst(node.right, val);

    }
}
