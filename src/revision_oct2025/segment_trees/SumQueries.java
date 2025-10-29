package revision_oct2025.segment_trees;

public class SumQueries {
    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[] {1, 5, 8, 7, 3, 0});
        System.out.println(segmentTree);

        System.out.println("sum for range (1,5) = " + segmentTree.query(1, 5));
        System.out.println("sum for range (2,4) = " + segmentTree.query(2, 4));
        System.out.println("sum for range (1,3) = " + segmentTree.query(1, 3));

        segmentTree.update(1, 10);
        System.out.println("sum for range (1,3) = " + segmentTree.query(1, 3));

    }


    private static class SegmentTree {
        SegmentTreeNode root;
        int rootRangeStart;
        int rootRangeEnd;

        SegmentTree(int[] A) {
            this.root = new SegmentTreeNode();
            this.rootRangeStart = 0;
            this.rootRangeEnd = A.length - 1;
            build(A, root, rootRangeStart, rootRangeEnd);
        }

        private void build(int[] A, SegmentTreeNode node, int nodeRangeStart, int nodeRangeEnd) {
            if (nodeRangeStart == nodeRangeEnd) {
                node.val = A[nodeRangeStart];
                return;
            }

            int mid = nodeRangeStart + (nodeRangeEnd - nodeRangeStart) / 2;
            node.left = new SegmentTreeNode();
            node.right = new SegmentTreeNode();

            // postorder
            build(A, node.left, nodeRangeStart, mid);
            build(A, node.right, mid + 1, nodeRangeEnd);

            node.val = node.left.val + node.right.val;
        }

        int query(int queryRangeStart, int queryRangeEnd) {
            if (queryRangeStart < 0 || queryRangeEnd > rootRangeEnd || queryRangeStart > queryRangeEnd) {
                throw new IllegalArgumentException("Invalid query range");
            }

            return queryHelper(root, rootRangeStart, rootRangeEnd, queryRangeStart, queryRangeEnd);
        }

        void update(int index, int newVal) {
            if (index < 0 || index > rootRangeEnd)
                throw new IllegalArgumentException("Invalid index for update");

            updateHelper(root, rootRangeStart, rootRangeEnd, index, newVal);
        }

        private int updateHelper(SegmentTreeNode node, int nodeStart, int nodeEnd, int index, int newVal) {

           // we are at the node, update the value, return the difference
            if (nodeStart == nodeEnd) {
                int prevVal = node.val;
                node.val = newVal;
                return newVal - prevVal;
            }

            int mid = nodeStart + (nodeEnd - nodeStart) / 2;
            int diff;
            if (index <= mid)
                diff = updateHelper(node.left, nodeStart, mid, index, newVal);
            else
                diff = updateHelper(node.right, mid + 1, nodeEnd, index, newVal);

            // update the current node's val
            node.val += diff;
            return diff;

        }

        private int queryHelper(SegmentTreeNode node, int nodeRangeStart, int nodeRangeEnd,
                                int queryRangeStart, int queryRangeEnd) {

            // Base case -> No overlap between the node and the query range
            if (queryRangeEnd < nodeRangeStart || queryRangeStart > nodeRangeEnd) {
                return 0;
            }

            // Complete overlap
            if (queryRangeStart <= nodeRangeStart && queryRangeEnd >= nodeRangeEnd) {
                return node.val;
            }

            // Partial overlap -> explore the children
            int mid = nodeRangeStart + (nodeRangeEnd - nodeRangeStart) / 2;
            int leftAnswer = queryHelper(node.left, nodeRangeStart, mid, queryRangeStart, queryRangeEnd);
            int rightAnswer = queryHelper(node.right, mid + 1, nodeRangeEnd, queryRangeStart, queryRangeEnd);

            // val for current node is sum of it's children
            return leftAnswer + rightAnswer;
        }


        private static class SegmentTreeNode {
            int val;
            SegmentTreeNode left;
            SegmentTreeNode right;

            public SegmentTreeNode() {
                left = null;
                right = null;
            }

            @Override
            public String toString() {
                return "SegmentTreeNode{" +
                        "val=" + val +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "SegmentTree{" +
                    "root=" + root +
                    '}';
        }
    }
}