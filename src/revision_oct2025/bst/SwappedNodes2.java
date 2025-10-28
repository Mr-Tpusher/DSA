package revision_oct2025.bst;

import java.util.ArrayList;
import java.util.Collections;

public class SwappedNodes2 {
    BSTNode prev = null, first = null, second = null;

    public static void main(String[] args) {

        BSTNode root = new BSTNode(8);
        root.left = new BSTNode(12);
        root.right = new BSTNode(10);
        root.left.left = new BSTNode(3);
        root.left.right = new BSTNode(7);
        root.right.right = new BSTNode(5);

        SwappedNodes2 swappedNodes = new SwappedNodes2();
        System.out.println(swappedNodes.recoverTree(root));
    }

    ArrayList<Integer> recoverTree(BSTNode A) {
        traverse(A);
        ArrayList<Integer> swapped = new ArrayList<>();
        swapped.add(first.val);
        swapped.add(second.val);
        Collections.sort(swapped);
        return swapped;
    }

    void traverse(BSTNode A) {
        if (A == null) return;

        traverse(A.left);
        if (prev != null && prev.val > A.val) {
            if (first == null) {
                first = prev;
            }
            second = A;
        }

        prev = A;

        traverse(A.right);
    }
}
