package revision_oct2025.trees;

public class BTNode {
    int val;
    BTNode left;
    BTNode right;
    public BTNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "BTNode{" +
                 val +
                '}';
    }
}
