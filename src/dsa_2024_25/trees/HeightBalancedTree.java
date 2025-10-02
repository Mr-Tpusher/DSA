package dsa_2024_25.trees;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a tree, return true if every node of the tree is height balanced.
 *
 *                     1
 *                   /   \
 *                 2      3
 *               /  \    /
 *             4     5  6
 *                 /  \
 *               7     8
 * ans: true
 * */
public class HeightBalancedTree {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();

        System.out.println(checkBalance1(root));
        System.out.println(checkBalance2(root).isBalanced);
    }

    private static HeightAndIsBalanced checkBalance2(BTNode<Integer> root) {

        if (root == null) {
            return new HeightAndIsBalanced(-1, true);
        }

        HeightAndIsBalanced left = checkBalance2(root.getLeft());
        HeightAndIsBalanced right = checkBalance2(root.getRight());

        boolean currIsBalanced = (Math.abs(left.height - right.height) <= 1) &&
                left.isBalanced && right.isBalanced;
        int currHeight = Math.max(left.height, right.height) + 1;

        return new HeightAndIsBalanced(currHeight, currIsBalanced);
    }

    public static boolean checkBalance1(BTNode<Integer> root) {

        Map<BTNode<Integer>, Integer> heightsMap = new HashMap<>();
        getHeights(root, heightsMap);
        return isHeightBalanced(root, heightsMap);

    }

    private static boolean isHeightBalanced(BTNode<Integer> root, Map<BTNode<Integer>, Integer> heightsMap) {

        if (root == null)
            return true;

        int leftHeight = -1;
        if (root.getLeft() != null)
            leftHeight = heightsMap.get(root.getLeft());

        int rightHeight = -1;
        if (root.getRight() != null)
            rightHeight = heightsMap.get(root.getRight());

        return (Math.abs(leftHeight - rightHeight) <= 1) &&
                isHeightBalanced(root.getLeft(), heightsMap) &&
                isHeightBalanced(root.getRight(), heightsMap);

    }

    private static int getHeights(BTNode<Integer> root, Map<BTNode<Integer>, Integer> heightsMap) {
        if (root == null) {
            return -1;
        }

        int leftHeight = getHeights(root.getLeft(), heightsMap);
        int rightHeight = getHeights(root.getRight(), heightsMap);
        int rootHeight = Math.max(leftHeight, rightHeight) + 1;
        heightsMap.put(root, rootHeight);
        return rootHeight;
    }

    public static BTNode<Integer> constructBT() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);
        BTNode<Integer> six = new BTNode<>(6);
        BTNode<Integer> seven = new BTNode<>(7);
        BTNode<Integer> eight = new BTNode<>(8);

        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        five.setLeft(seven);
        five.setRight(eight);

        return one;
    }

    static class HeightAndIsBalanced {
        int height;
        boolean isBalanced;

        public HeightAndIsBalanced(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

    }
}
