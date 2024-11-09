package trees;
/*
* Given a complete Binary Tree, return number of nodes.
*
*
* */
public class NodeCount {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();

        System.out.println(getNodeCount1(root));

    }

    private static int getNodeCount1(BTNode<Integer> root) {
        if (root == null)
            return 0;

        return 1 + getNodeCount1(root.getLeft()) + getNodeCount1(root.getRight());
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
        three.setRight(seven);
        four.setLeft(eight);

        return one;
    }
}
