package dsa_2024_25.segment_trees;

public class SumQueries {
    public static void main(String[] args) {
        int[] A = {1, 5, 8, 7, 6, 3, 2};
        SegTreeNode root = new SegTreeNode();

        buildSegTree(A, root);

        System.out.println(queryRec(root, 0, A.length - 1, 1, 3));

    }

    public static void buildSegTree(int[] A, SegTreeNode root) {
        buildSegTreeRec(root, A, 0, A.length - 1);
    }

    private static void buildSegTreeRec(SegTreeNode node, int[] A, int nodeStart, int nodeEnd) {
        // Base condition - when we reach the leaf node
        if (nodeStart == nodeEnd) {
            node.setValue(A[nodeStart]);
            return;
        }

        int mid = (nodeStart + nodeEnd) / 2;

        node.setLeftNode(new SegTreeNode());
        node.setRightNode(new SegTreeNode());

        buildSegTreeRec(node.getLeftNode(), A, nodeStart, mid);
        buildSegTreeRec(node.getRightNode(), A, mid + 1, nodeEnd);

        node.setValue(node.getLeftNode().getValue() + node.getRightNode().getValue());
    }


    private static int queryRec(SegTreeNode root, int nodeStart, int nodeEnd, int queryStart, int queryEnd) {
        // Base condition - No overlap
        if (queryEnd < nodeStart || queryStart > nodeEnd) {
            return 0;
        }

        // Complete overlap
        if (queryStart <= nodeStart &&  nodeEnd <= queryEnd) {
            return root.getValue();
        }

        // Partial overlap
        int mid = (nodeStart + nodeEnd) / 2;

        int leftAnswer = queryRec(root.getLeftNode(), nodeStart, mid, queryStart, queryEnd);
        int rightAnswer = queryRec(root.getRightNode(), mid + 1, nodeEnd, queryStart, queryEnd);

        return leftAnswer + rightAnswer;
    }
}
