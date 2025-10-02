package dsa_2024_25.bst;
/*
*        20
       /  \
      10   30
     /  \  /  \
    5   15 25  35
*
* */
public class LCAInBST {

    public static void main(String[] args) {
        BSTNode<Integer> root = buildBST();

        BSTNode<Integer> lca = findLCA(root, 5, 15);
        System.out.println("LCA of 5 and 15: " + (lca != null ? lca.getValue() : "Not found"));

        lca = findLCA(root, 25, 35);
        System.out.println("LCA of 25 and 35: " + (lca != null ? lca.getValue() : "Not found"));

        lca = findLCA(root, 5, 30);
        System.out.println("LCA of 5 and 30: " + (lca != null ? lca.getValue() : "Not found"));
    }


    // Function to find the LCA of two nodes in a BST
    public static BSTNode<Integer> findLCA(BSTNode<Integer> root, int n1, int n2) {
        // Base case
        if (root == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, LCA lies in left subtree
        if (n1 < root.getValue() && n2 < root.getValue()) {
            return findLCA(root.getLeft(), n1, n2);
        }

        // If both n1 and n2 are greater than root, LCA lies in right subtree
        if (n1 > root.getValue() && n2 > root.getValue()) {
            return findLCA(root.getRight(), n1, n2);
        }

        // If one node is on the left and the other is on the right, root is the LCA
        return root;
    }

    public static BSTNode<Integer> buildBST() {
        BSTNode<Integer> root = new BSTNode<>(20);
        root.setLeft(new BSTNode<>(10));
        root.setRight(new BSTNode<>(30));
        root.getLeft().setLeft(new BSTNode<>(5));
        root.getLeft().setRight(new BSTNode<>(15));
        root.getRight().setLeft(new BSTNode<>(25));
        root.getRight().setRight(new BSTNode<>(35));

        return root;
    }

}
