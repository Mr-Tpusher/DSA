package segment_trees;

/*
 * Given an array and two types of queries
 *
 * */
public class SubArraySumSegTree {
    private SegTreeNode root;
    private int rangeStart;
    private int rangeEnd;

    public SubArraySumSegTree() {
        this.root = new SegTreeNode();
        rangeStart = 0;
        rangeEnd = 0;
    }

    public static void main(String[] args) {
        SubArraySumSegTree segTree = new SubArraySumSegTree();
        segTree.build(new int[]{1, 5, 8, 7, 6, 3, 2});
        segTree.print();
        int query1 = segTree.query(0, 4);
        System.out.println(query1);

        segTree.update(0, 4);
        segTree.print();

        int query2 = segTree.query(0, 4);
        System.out.println(query2);
    }

    public void build(int[] A) {
        this.rangeStart = 0;
        this.rangeEnd = A.length - 1;
        buildRec(A, root, rangeStart, rangeEnd);
    }

    public int query(int queryStart, int queryEnd) {
        return queryRec(root, rangeStart, rangeEnd, queryStart, queryEnd);
    }

    public void update(int updateIndex, int newValue) {
        if (updateIndex < rangeStart || updateIndex > rangeEnd) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        update(root, rangeStart, rangeEnd, updateIndex, newValue);
    }

    private int update(SegTreeNode node, int nodeStart, int nodeEnd, int updateIndex, int newValue) {
        // Base condition - Leaf node
        if (nodeStart == nodeEnd) {
            // This leaf shouldn't be updated
            if (nodeStart != updateIndex) {
                return 0;
            }

            int currVal = node.getValue();
            node.setValue(newValue);

            // difference to propagate
            return newValue - currVal;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;
        int leftDifference = update(node.getLeftNode(), nodeStart, mid, updateIndex, newValue);
        int rightDifference = update(node.getRightNode(), mid + 1, nodeEnd, updateIndex, newValue);

        int propagatedDifference = leftDifference + rightDifference;
        node.setValue(node.getValue() + propagatedDifference);
        return propagatedDifference;
    }

    private int queryRec(SegTreeNode node, int nodeStart, int nodeEnd, int queryStart, int queryEnd) {

        // Base condition - No overlap
        if (queryEnd < nodeStart || queryStart > nodeEnd) {
            return 0;
        }

        // Complete overlap
        if (queryStart <= nodeStart && nodeEnd <= queryEnd) {
            return node.getValue();
        }

        // Partial overlap
        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        int leftSum = queryRec(node.getLeftNode(), nodeStart, mid, queryStart, queryEnd);
        int rightSum = queryRec(node.getRightNode(), mid + 1, nodeEnd, queryStart, queryEnd);

        return leftSum + rightSum;
    }

    private void buildRec(int[] A, SegTreeNode node, int nodeStart, int nodeEnd) {
        // Base case - Leaf node
        if (nodeStart == nodeEnd) {
            node.setValue(A[nodeStart]);
            return;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;
        node.setLeftNode(new SegTreeNode());
        node.setRightNode(new SegTreeNode());

        buildRec(A, node.getLeftNode(), nodeStart, mid);
        buildRec(A, node.getRightNode(), mid + 1, nodeEnd);
        node.setValue(node.getLeftNode().getValue() + node.getRightNode().getValue());
    }

    public void print() {
        printRec(root);
        System.out.println();
    }

    private void printRec(SegTreeNode root) {
        if (root.getLeftNode() == null || root.getRightNode() == null) {
            System.out.print(root.getValue() + " ");
            return;
        }

        printRec(root.getLeftNode());
        printRec(root.getRightNode());
        System.out.print(root.getValue() + " ");
    }
}
