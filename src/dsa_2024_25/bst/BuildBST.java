package dsa_2024_25.bst;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class BuildBST {
    public static void main(String[] args) {
        int[] bstInput = {11, 2, 9, 13, 57, 25, 1, 1, 12, 90, 3};
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode<Integer> root = bst.buildBST(bstInput);

        System.out.println(bst.search(11));
        System.out.println(bst.search(56));
        System.out.println(bst.search(57));


        bst.insert(33);

        ArrayList<Integer> inorder = bst.inOrderTraversal();
        System.out.println(inorder);

    }
}
