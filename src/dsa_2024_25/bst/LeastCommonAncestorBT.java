package dsa_2024_25.bst;

import trees.BTNode;
import java.util.ArrayList;
import java.util.Objects;

public class LeastCommonAncestorBT {
    public static void main(String[] args) {
        BTNode<Integer> root = buildBST();

        System.out.println(getLcaBT(root,7,5));
        System.out.println(getLcaBT2(root,7,5));
    }

    private static Integer getLcaBT2(BTNode<Integer> root, int first, int second) {
        // use postorder traversal
        if (root == null)
            return null;

        if (root.getValue() == first || root.getValue() == second)
            return root.getValue();

        Integer leftLCA = getLcaBT2(root.getLeft(), first, second);
        Integer rightLCA = getLcaBT2(root.getRight(), first, second);

        if (leftLCA != null && rightLCA != null) {
            return root.getValue();
        }
        if (leftLCA == null)
            return rightLCA;
        else
            return leftLCA;
    }



    public static Integer getLcaBT(BTNode<Integer> root, int a, int b) {
        ArrayList<Integer> ancestors1 = getAncestors(root, a);
        ArrayList<Integer> ancestors2 = getAncestors(root, b);

        System.out.println(ancestors1);
        System.out.println(ancestors2);

        for (int i = ancestors1.size() - 1; i >= 0; i--) {
            for (int j = ancestors2.size() - 1; j >= 0; j--) {
                if (Objects.equals(ancestors1.get(i), ancestors2.get(j)))
                    return ancestors1.get(i);
            }
        }
        return null;
    }

    private static ArrayList<Integer> getAncestors(BTNode<Integer> root, int i ) {

        ArrayList<Integer> ancestors = new ArrayList<>();

        getAncestorsRec(root, i, ancestors);

        return ancestors;
    }

    private static boolean getAncestorsRec(BTNode<Integer> root, int i, ArrayList<Integer> ancestors) {
        if (root == null)
            return false;

        ancestors.add(root.getValue());

        if (root.getValue() == i)
            return true;

        boolean left = getAncestorsRec(root.getLeft(), i, ancestors);
        if (left) {
            return true;
        }

        boolean right = getAncestorsRec(root.getRight(), i, ancestors);
        if (right)
            return true;

        ancestors.remove(ancestors.size() - 1);

        return false;
    }

    public static BTNode<Integer> buildBST() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);
        BTNode<Integer> six = new BTNode<>(6);
        BTNode<Integer> seven = new BTNode<>(7);
        BTNode<Integer> eight = new BTNode<>(8);
        BTNode<Integer> nine = new BTNode<>(9);

        one.setLeft(two);
        one.setRight(three);

        two.setLeft(four);
        two.setRight(five);

        three.setRight(six);

        four.setLeft(seven);
        five.setRight(eight);
        seven.setRight(nine);

        return one;
    }
}
