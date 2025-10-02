package dsa_2024_25.trees;
/*
* Given two trees(Access to the root nodes), return true if trees are mirror images
* else false.
*
*           1                       1
*          / \                     / \
*         2   3                   3   2
*            / \                 / \
*           4   5               5   4
 *
* */
public class MirrorTrees {

    public static void main(String[] args) {
        BTNode<Integer> root1 = constructBT();
        BTNode<Integer> root2 = constructBT2();
        BTNode<Integer> root3 = constructBT();
        root3.setValue(0);

        System.out.println(areTreesMirrorImages(root1, root2));
        System.out.println(areTreesMirrorImages(root1, root3));

    }

    public static boolean areTreesMirrorImages(BTNode<Integer> root1, BTNode<Integer> root2) {

        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.getValue().equals(root2.getValue()) &&
                areTreesMirrorImages(root1.getLeft(), root2.getRight()) &&
                areTreesMirrorImages(root1.getRight(), root2.getLeft()));
    }


    public static BTNode<Integer> constructBT() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);

        one.setLeft(two);
        one.setRight(three);
        three.setLeft(four);
        three.setRight(five);

        return one;
    }


    public static BTNode<Integer> constructBT2() {
        BTNode<Integer> one = new BTNode<>(1);
        BTNode<Integer> two = new BTNode<>(2);
        BTNode<Integer> three = new BTNode<>(3);
        BTNode<Integer> four = new BTNode<>(4);
        BTNode<Integer> five = new BTNode<>(5);

        one.setLeft(three);
        one.setRight(two);
        three.setLeft(five);
        three.setRight(four);

        return one;
    }
}
