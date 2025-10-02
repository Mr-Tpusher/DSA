package dsa_2024_25.trees;

import java.util.ArrayList;
import java.util.List;

/*
*               1
*              / \
*             2   3
*           /    / \
*          4    5   6
*                    \
*                     7
*
* postorder: 4,2,5,7,6,3,1
*
*
* */
public class PostOrderTraversal {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();
        ArrayList<Integer> postorder = new ArrayList<>();
        postorderTraversal(root, postorder);
        System.out.println(postorder);
    }

    public static void postorderTraversal(BTNode<Integer> root, List<Integer> postorder) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.getLeft(), postorder);
        postorderTraversal(root.getRight(), postorder);
        postorder.add(root.getValue());
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
        three.setLeft(five);
        three.setRight(six);
        six.setRight(seven);

        return one;
    }
}

