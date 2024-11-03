package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
*              1
*            /   \
*           2     3
*         /  \   /  \
*        4   5  6    7
* levelOrder: 1,2,3,4,5,6,7
**/
public class LevelOrderTraversing {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();
        ArrayList<Integer> levelOrder = levelOrderTraversal(root);
        System.out.println(levelOrder);
    }

    private static ArrayList<Integer> levelOrderTraversal(BTNode<Integer> root) {
        ArrayList<Integer> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }

        Queue<BTNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BTNode<Integer> curr = queue.poll();
            levelOrder.add(curr.getValue());
            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
        return levelOrder;
    }

    public static BTNode<Integer> constructBT() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);
        BTNode<Integer> six = new BTNode<>(6);
        BTNode<Integer> seven = new BTNode<>(7);

        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        three.setRight(seven);

        return one;
    }
}
