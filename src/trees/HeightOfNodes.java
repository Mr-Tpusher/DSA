package trees;

import java.util.HashMap;

/*
* Given the root node of a binary tree, find height of every node of the tree.
* */
public class HeightOfNodes {
    public static void main(String[] args) {
        BTNode<Integer> root = populateTree();
        HashMap<BTNode<Integer>, Integer> heights = new HashMap<>();
        getHeightsOfNodes(root, heights);
        System.out.println(heights);

    }

    private static Integer getHeightsOfNodes(
            BTNode<Integer> root, HashMap<BTNode<Integer>, Integer> heights) {

        if (root == null) {
            return -1;
        }

        int leftNodeHeight = getHeightsOfNodes(root.getLeft(),heights);
        int rightNodeHeight = getHeightsOfNodes(root.getRight(),heights);
        int currHeight = Math.max(leftNodeHeight, rightNodeHeight) + 1;
        heights.put(root, currHeight);
        return currHeight;
    }

    public static BTNode<Integer> populateTree() {
        BTNode<Integer> root = new BTNode<>(3);
        root.setLeft(new BTNode<>(2));
        root.setRight(new BTNode<>(1));
        root.getRight().setLeft(new BTNode<>(2));
        root.getRight().setRight(new BTNode<>(4));
        root.getRight().getRight().setLeft(new BTNode<>(4));
        return root;
    }
}
