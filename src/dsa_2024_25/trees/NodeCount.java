package dsa_2024_25.trees;
/*
* Given a complete Binary Tree, return number of nodes.
*         1
        /   \
       2     3
      / \   / \
     4   5 6   7
    /
   8

   answer = 8

* */
public class NodeCount {
    public static void main(String[] args) {
        BTNode<Integer> root = constructBT();

        System.out.println(getNodeCount1(root));
        System.out.println(getNodeCount2(root));

    }

    public static int getNodeCount1(BTNode<Integer> root) {
        if (root == null)
            return 0;

        return 1 + getNodeCount1(root.getLeft()) + getNodeCount1(root.getRight());
    }

    public static int getNodeCount2(BTNode<Integer> root) {
        if (root == null)
            return 0;

        int leftHeight = getLeftHeight(root.getLeft());
        int rightHeight = getRightHeight(root.getRight());
        if (leftHeight == rightHeight) {
            return ((int) Math.pow(2, leftHeight + 1)) - 1 ;
        }

        return 1 + getNodeCount2(root.getLeft()) + getNodeCount2(root.getRight());
    }

    public static int getLeftHeight(BTNode<Integer> node) {
        if (node == null) return 0;
        int height = 1;
        while (node.getLeft() != null) {
            height += 1;
            node = node.getLeft();
        }
        return height;
    }

    public static int getRightHeight(BTNode<Integer> node) {
        if (node == null) return 0;
        int height = 1;
        while (node.getRight() != null) {
            height += 1;
            node = node.getRight();
        }
        return height;
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
