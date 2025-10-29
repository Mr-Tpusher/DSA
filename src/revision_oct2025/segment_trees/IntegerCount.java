package revision_oct2025.segment_trees;
/*
* Given an array and given two types of queries:
* Q1:(R1,R2) -> Find how many integers lie between R1 and R2.
* Q2:(i, x)  -> Update the ith index value to x
*
* A = {1,100,510,225,900,8,91}
*
* */
public class IntegerCount {
    public static void main(String[] args) {
        int[] A = {1,100,510,225,900,8,91};
        SegmentTree segmentTree = new SegmentTree(A, 1, 10000);
        //System.out.println(segmentTree);

        System.out.println(segmentTree.query(1,1000));
        System.out.println(segmentTree.query(900,1000));
        System.out.println(segmentTree.query(100,900));
        segmentTree.update(4, 9000);
        System.out.println(segmentTree.query(100,900));
        segmentTree.update(5, 800);
        System.out.println(segmentTree.query(100,900));
    }

    private static class SegmentTree {
        Node root;
        int rootRangeStart;
        int rootRangeEnd;
        int[] A;

        SegmentTree(int[] A, int rangeStart, int rangeEnd) {
            this.root = new Node();
            this.rootRangeStart = rangeStart;
            this.rootRangeEnd = rangeEnd;
            this.A = A;
            build(A);
        }

        private void build(int[] A) {

            for (int j : A) {
                insert(j, root, rootRangeStart, rootRangeEnd);
            }
        }

        private int query(int queryRangeStart, int queryRangeEnd) {
            return queryHelper(queryRangeStart, queryRangeEnd, root, rootRangeStart, rootRangeEnd);
        }

        private void update(int index, int newValue) {
            delete(A[index]);
            insert(newValue, root, rootRangeStart, rootRangeEnd);
            A[index] = newValue;
        }

        private void delete(int element) {
            deleteHelper(element, root, rootRangeStart, rootRangeEnd);
        }

        private boolean deleteHelper(int element, Node node, int nodeRangeStart, int nodeRangeEnd) {
            if (node == null || node.totalIntegers == 0) return false;

            if (element == nodeRangeStart && element == nodeRangeEnd)
                return true; // indicating that leaf was found and the parent can delete this

            int mid = nodeRangeStart + (nodeRangeEnd - nodeRangeStart) / 2;

            if (element <= mid) {
                boolean deleted = deleteHelper(element, node.left, nodeRangeStart, mid);
                if (deleted) node.left = null;
            }
            else {
                boolean deleted = deleteHelper(element, node.right, mid + 1, nodeRangeEnd);
                if (deleted) node.right = null;
            }

            node.totalIntegers -= 1;
            return false;
        }

        private int queryHelper(int queryRangeStart, int queryRangeEnd, Node node, int nodeRangeStart, int nodeRangeEnd) {
            // Base case, no overlap
            if (queryRangeEnd < nodeRangeStart || queryRangeStart > nodeRangeEnd) {
                return 0;
            }

            // Complete overlap
            if (queryRangeStart <= nodeRangeStart && queryRangeEnd >= nodeRangeEnd) {
                return node.totalIntegers;
            }

            // Partial overlap - explore children
            int mid = nodeRangeStart + (nodeRangeEnd - nodeRangeStart) / 2;

            int left = 0;
            if (node.left != null)
                left = queryHelper(queryRangeStart, queryRangeEnd, node.left, nodeRangeStart, mid);

            int right = 0;
            if (node.right != null)
                right = queryHelper(queryRangeStart, queryRangeEnd, node.right, mid + 1, nodeRangeEnd);

            return left + right;

        }

        private int insert(int element, Node node, int rangeStart, int rangeEnd) {
            if (rangeStart == rangeEnd) {
                node.totalIntegers += 1;
                return 1;
            }

            int mid = rangeStart + (rangeEnd - rangeStart) / 2;
            if (element <= mid) {
                node.left = node.left == null ? new Node(): node.left;
                insert(element, node.left, rangeStart, mid);
            } else {
                node.right = node.right == null ? new Node() : node.right;
                insert(element, node.right, mid + 1, rangeEnd);
            }
            node.totalIntegers += 1;
            return 1;
        }

        private static class Node {
            int totalIntegers;
            Node left;
            Node right;

            Node() {
                this.left = null;
                this.right = null;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "totalIntegers=" + totalIntegers +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "SegmentTree{" +
                    "root=" + root +
                    ", rootRangeStart=" + rootRangeStart +
                    ", rootRangeEnd=" + rootRangeEnd +
                    '}';
        }
    }
}
