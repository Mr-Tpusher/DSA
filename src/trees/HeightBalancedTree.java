package trees;

import linkedlist.Node;

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
        Map<BTNode<Integer>, Integer> heightsMap = new HashMap<>();
        getHeights(root, heightsMap);
        System.out.println(isHeightBalanced(root, heightsMap));


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
}
