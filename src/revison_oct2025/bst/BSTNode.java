package revison_oct2025.bst;

public class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;
    public BSTNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "val=" + val +
                ", left=" + left.val +
                ", right=" + right.val +
                '}';
    }
}
