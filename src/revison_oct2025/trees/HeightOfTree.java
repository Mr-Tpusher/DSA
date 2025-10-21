package revison_oct2025.trees;

import java.util.HashMap;

/*
* Given the root of the tree, find height of every node of the tree.
*
* */
public class HeightOfTree {
    public static void main(String[] args) {
        BTNode root = new BTNode(3);
        root.left = new BTNode(2);
        root.right = new BTNode(1);
        root.right.left  = new BTNode(2);
        root.right.right = new BTNode(4);
        root.right.right.left = new BTNode(4);

        HashMap<BTNode, Integer> heightOfNodes = new HashMap<>();
        heightOfNodes(root, heightOfNodes);
        System.out.println(heightOfNodes);
    }

    private static int heightOfNodes(BTNode root, HashMap<BTNode, Integer> heightOfNodes) {
        if (root == null) return -1;

        int leftHeight = heightOfNodes(root.left, heightOfNodes);
        int rightHeight = heightOfNodes(root.right, heightOfNodes);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        heightOfNodes.put(root, currHeight);
        return currHeight;

    }
}
