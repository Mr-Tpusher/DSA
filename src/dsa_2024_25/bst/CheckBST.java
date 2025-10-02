package dsa_2024_25.bst;
/*
* Given a BT, check if it is a BST or not.
*
* */
public class CheckBST {
    public static void main(String[] args) {
       BinarySearchTree bst = new BinarySearchTree();
       bst.insert(3);
        bst.insert(2);
        bst.insert(5);
        BSTNode<Integer> root = bst.insert(1);
        root.getLeft().setRight(new BSTNode<>(4));
        System.out.println(isBST(root));

        BinarySearchTree bst2 = new BinarySearchTree();
        BSTNode<Integer> root2 = bst2.buildBST(new int[] {4,5,2,3,10,9,11});
        System.out.println(isBST(root2));

    }

    public static boolean isBST(BSTNode<Integer> root) {
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBstRec(BSTNode<Integer> root, int minValue, int maxValue) {
       if (root == null) {
           return true;
       }

       return  (root.getValue() > minValue && root.getValue() < maxValue) &&
               isBstRec(root.getLeft(), minValue, root.getValue()) &&
               isBstRec(root.getRight(), root.getValue(), maxValue);
    }

}
