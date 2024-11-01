package trees;

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
* preorder: 1,2,4,3,5,6,7
*
*
* */
public class PreOrderTraversal {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();
        ArrayList<Integer> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        System.out.println(preorder);
    }

    public static void preorderTraversal(BTNode<Integer> root, List<Integer> preorder) {
        if (root == null) {
            return;
        }

        preorder.add(root.getValue());
        preorderTraversal(root.getLeft(), preorder);
        preorderTraversal(root.getRight(), preorder);
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

