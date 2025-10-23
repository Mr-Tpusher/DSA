package revison_oct2025.trees;

public class NodeCountCompleteBT {
    public static void main(String[] args) {

    }
    int totalNodes(BTNode node) {
        if (node == null)
            return 0;

        int leftHeight = getLeftHeight(node.left);
        int rightHeight = getRightHeight(node.right);

        if (leftHeight == rightHeight) {
            return ( 1 << leftHeight + 1) - 1;
        } else {
            return 1 + totalNodes(node.left) + totalNodes(node.right);
        }
    }

    int getLeftHeight(BTNode node) {
        if (node == null)
            return 0;

        int height = 1;
        while (node.left != null) {
            ++height;
            node = node.left;
        }
        return height;
    }

    int getRightHeight(BTNode node) {
        if (node == null)
            return 0;

        int height = 1;
        while (node.right != null) {
            ++height;
            node = node.right;
        }
        return height;
    }
}
