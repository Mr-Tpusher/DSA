package trees;

import linkedlist.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*               1
*              /
*             2
*           /   \
*         3       4
*               /
*             5
*           /
*         6
*
* Vertical Order : 3,6,2,5,1,4
* */
public class VerticalOrderTraversal {
    static Integer MIN = Integer.MAX_VALUE;
    static Integer MAX = Integer.MIN_VALUE;
    public static void main(String[] args) {

        BTNode<Integer> root = constructBT();
        List<Integer> verticalOrderTraversal = verticalOrder(root);

        System.out.println(verticalOrderTraversal);


    }

    public static List<Integer> verticalOrder(BTNode<Integer> root) {
        Map<Integer, List<Integer>> verticalOrder = new HashMap<>();

        getVerticalOrder(root, 0, verticalOrder);

        List<Integer> out = new ArrayList<>();
        for (Integer i = MIN; i <= MAX; i++) {
            out.addAll(verticalOrder.get(i));
        }

        return out;
    }

    public static void getVerticalOrder(BTNode<Integer> root, Integer level,
                                                 Map<Integer, List<Integer>> verticalOrder) {

        if (root == null)
            return;

        List<Integer> currLevelNodes = verticalOrder.getOrDefault(level, new ArrayList<>());
        currLevelNodes.add(root.getValue());
        verticalOrder.put(level, currLevelNodes);

        MIN = Math.min(MIN, level);
        MAX = Math.max(MAX, level);

        getVerticalOrder(root.getLeft(), level - 1, verticalOrder);
        getVerticalOrder(root.getRight(), level + 1, verticalOrder);
    }

    public static BTNode<Integer> constructBT() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);
        BTNode<Integer> six = new BTNode<>(6);

        one.setLeft(two);
        two.setLeft(three);
        two.setRight(four);
        four.setLeft(five);
        five.setLeft(six);

        return one;
    }
}
