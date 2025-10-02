package dsa_2024_25.trees;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a tree, find the longest path between any two nodes of the tree.
 *
 *                     1
 *                   /   \
 *                 2      3
 *                       /  \
 *                      4     5
 *                     /       \
 *                    6         7
 * ans:4
 * */
public class DiameterOfTree {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();

        System.out.println(getDiameter(root).diameter);
    }

    private static HeightAndDiameter getDiameter(BTNode<Integer> root) {

        if (root == null) {
            return new HeightAndDiameter(-1, 0);
        }

        HeightAndDiameter left = getDiameter(root.getLeft());
        HeightAndDiameter right = getDiameter(root.getRight());

        int currHeight = Math.max(left.height, right.height) + 1;
        int currDiameter = left.height + right.height + 2;

        return new HeightAndDiameter(currHeight, currDiameter);
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
        three.setLeft(four);
        three.setRight(five);
        four.setLeft(six);
        five.setRight(seven);

        return one;
    }

    static class HeightAndDiameter {
        int height;
        int diameter;

        public HeightAndDiameter(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }

    }
}
