package revison_oct2025.trees;

import javax.swing.tree.TreeNode;

public class DiameterOfTree {

    public static void main(String[] args) {

    }

    static HeightAndMaxDiameter getDiameter(BTNode node) {
        if (node == null)
            return new HeightAndMaxDiameter(-1, 0);

        HeightAndMaxDiameter left = getDiameter(node.left);
        HeightAndMaxDiameter right = getDiameter(node.right);

        int nodeHeight = 1 + Math.max(left.height, right.height);
        int nodeDiameter = 2 + left.height + right.height;
        int maxDiameter = Math.max(nodeDiameter,Math.max(left.maxDiameter, right.maxDiameter));
        return new HeightAndMaxDiameter(nodeHeight, maxDiameter);
    }


    static class HeightAndMaxDiameter {
        int height;
        int maxDiameter;
        public HeightAndMaxDiameter(int height, int maxDiameter) {
            this.height = height;
            this.maxDiameter = maxDiameter;
        }
    }
}
