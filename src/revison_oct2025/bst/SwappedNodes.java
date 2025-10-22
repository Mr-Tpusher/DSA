package revison_oct2025.bst;

import java.util.ArrayList;
import java.util.Arrays;

public class SwappedNodes {
    public static void main(String[] args) {
        BSTNode root = new BSTNode(8);
        root.left = new BSTNode(12);
        root.right = new BSTNode(10);
        root.left.left = new BSTNode(3);
        root.left.right = new BSTNode(7);
        root.right.right = new BSTNode(5);

        int[] swapped = getSwappedNodes(root);
        System.out.println(Arrays.toString(swapped));
    }

    static int[] getSwappedNodes(BSTNode node) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(node, inOrder);

        int[] swappedNodes = new int[2];
        Arrays.fill(swappedNodes, -1);
        for (int i = 0; i < inOrder.size() - 1; i++) {
            if (inOrder.get(i) > inOrder.get(i + 1)) {
                if (swappedNodes[0] == -1)
                    swappedNodes[0] = inOrder.get(i);
                swappedNodes[1] = inOrder.get(i+1);
            }
        }
        return swappedNodes;
    }

    private static void inOrderTraversal(BSTNode node, ArrayList<Integer> traversal) {
        if (node == null) return;

        inOrderTraversal(node.left, traversal);
        traversal.add(node.val);
        inOrderTraversal(node.right, traversal);
    }
}
