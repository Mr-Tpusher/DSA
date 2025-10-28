package revision_oct2025.bst;

import java.util.ArrayList;

public class ValidBst {
    public static void main(String[] args) {

        BSTNode root = new BSTNode(1);
        root.left = new BSTNode(5);

        // Using inorder output
        System.out.println(isValidBST(root));

        // while recursing itself i.e. without any extra space
        System.out.println(isValid(root, 0, Integer.MAX_VALUE));


    }
    static int isValidBST(BSTNode A) {
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        traverse(A, inorder);
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i) > inorder.get(i+1))
                return 0;
        }
        return 1;
    }

    static void traverse(BSTNode node, ArrayList<Integer> al) {
        if (node == null) return;

        traverse(node.left, al);
        al.add(node.val);
        traverse(node.right, al);
    }

    static boolean isValid(BSTNode node, int rangeStart, int rangeEnd) {
        if (node == null) return true;

        if ((node.val >= rangeStart && node.val <= rangeEnd) &&
                isValid(node.left, rangeStart, node.val - 1) &&
                isValid(node.right, node.val + 1, rangeEnd)) {
            return true;
        }

        return false;
    }
}
