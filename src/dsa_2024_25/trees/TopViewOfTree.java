package dsa_2024_25.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
* Given a tree, return the top view of it.
*
*                   1
*                  / \
*                 2    3
*                / \    \
*              7    4    8
*                  /    /
*                 5    7
*                /
*              6
*
* Top view: 7,2,1,3,8
*
* */
public class TopViewOfTree {
    public static void main(String[] args) {

        BTNode<Integer> root = constructBT();

        ArrayList<Integer> topView = getTopView(root);
        System.out.println(topView);
    }

    public static ArrayList<Integer> getTopView(BTNode<Integer> root) {
        Map<Integer, BTNode<Integer>> levelNodeMap = new HashMap<>();
        int[] minMax = new int[2];
        minMax[0] = Integer.MAX_VALUE;
        minMax[1] = Integer.MIN_VALUE;

        getTopViewMap(root, 0, minMax, levelNodeMap);

        ArrayList<Integer> topView = new ArrayList<>();
        for (int i = minMax[0]; i <= minMax[1]; i++) {
            topView.add(levelNodeMap.get(i).getValue());
        }

        return topView;
    }

    public static void getTopViewMap(BTNode<Integer> root, int level,int[] minMax,
                               Map<Integer, BTNode<Integer>> levelNodeMap ) {

        if (root == null)
            return;

        if (!levelNodeMap.containsKey(level)) {
            levelNodeMap.put(level, root);
        }

        minMax[0] = Math.min(minMax[0], level);
        minMax[1] = Math.max(minMax[1], level);

        getTopViewMap(root.getLeft(), level - 1, minMax, levelNodeMap);
        getTopViewMap(root.getRight(), level + 1, minMax, levelNodeMap);

    }

    public static BTNode<Integer> constructBT() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);
        BTNode<Integer> six = new BTNode<>(6);
        BTNode<Integer> seven1 = new BTNode<>(7);
        BTNode<Integer> seven2 = new BTNode<>(7);
        BTNode<Integer> eight = new BTNode<>(8);

        one.setLeft(two);
        one.setRight(three);

        two.setLeft(seven1);
        two.setRight(four);

        three.setRight(eight);

        four.setLeft(five);
        five.setLeft(six);

        eight.setLeft(seven2);

        return one;                // Return the root node
    }

}
