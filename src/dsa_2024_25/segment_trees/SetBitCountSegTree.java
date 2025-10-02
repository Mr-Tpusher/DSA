package dsa_2024_25.segment_trees;
/*
* Given an integer array A where initially all of its elements are 0.
* There are Q queries:
* 1 x ---> A[x] = 2 * A[x] + 1
* 2 x ---> A[x] = A[x] / 2
* 3 xy --> find the total number of set bits in the binary representation of elements
*           from indices x to y.
*
* e.g.
* A = {2,3,6,8}
* Q: 313
* ---> A[i,j] = {3,6,8}
* answer = 5
* */
public class SetBitCountSegTree {
    private SegTreeNode root;
    private int rangeStart;
    private int rangeEnd;

    public SetBitCountSegTree() {
        root = new SegTreeNode();
    }

    public void build(int[] A) {
        rangeStart = 0;
        rangeEnd = A.length - 1;
        build(A, root, rangeStart, rangeEnd);
    }

    // Query2 = 2 * A[i] + 1   -> which boils down to incrementing the set bits count
    public void update1(int index) {
        update1(index, root, rangeStart, rangeEnd);
    }


    // Query2 = A[i] / 2   -> which boils down to decrementing the set bits count
    public void update2(int index) {
        update2(index, root, rangeStart, rangeEnd);
    }

    public int query(int queryStart, int queryEnd) {
        if (queryStart < rangeStart || queryEnd > rangeEnd) {
            throw new IndexOutOfBoundsException("Invalid range.");
        }
        return query(queryStart, queryEnd, root, rangeStart, rangeEnd);
    }

    private int query(int queryStart, int queryEnd, SegTreeNode root, int nodeStart, int nodeEnd) {
        // Base condition - No overlap
        if (queryEnd < nodeStart || queryStart > nodeEnd) {
            return 0;
        }

        // complete overlap
        if (queryStart <= nodeStart && queryEnd >= nodeEnd) {
            return root.getValue();
        }

        // Partial overlap
        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        int leftAnswer = query(queryStart, queryEnd, root.getLeftNode(), nodeStart, mid);
        int rightAnswer = query(queryStart, queryEnd, root.getRightNode(), mid + 1, nodeEnd);

        return leftAnswer + rightAnswer;
    }


    private void build(int[] A, SegTreeNode root, int nodeStart, int nodeEnd) {
        if (nodeStart == nodeEnd) {
            root.setValue(0);
            return;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        root.setLeftNode(new SegTreeNode());
        root.setRightNode(new SegTreeNode());

        build(A, root.getLeftNode(), nodeStart, mid);
        build(A, root.getRightNode(), mid + 1, nodeEnd);

        root.setValue(0);
    }


    public void update1(int index, SegTreeNode root, int nodeStart, int nodeEnd) {
        // Base condition
        if (nodeStart == nodeEnd) {
            if (nodeStart == index) {
                root.setValue(root.getValue() + 1);
            }
            return;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;
        if (index <= mid) {
            update1(index, root.getLeftNode(), nodeStart, mid);
        } else {
            update1(index, root.getRightNode(), mid + 1, nodeEnd);
        }

        root.setValue(root.getValue() + 1);
    }

        public boolean update2(int index, SegTreeNode root, int nodeStart, int nodeEnd) {
            // Base condition
            if (nodeStart == nodeEnd) {
                if (nodeStart == index && root.getValue() != 0) {
                    root.setValue(root.getValue() - 1);
                    return true;
                }
                return false;
            }

            int mid = nodeStart + (nodeEnd - nodeStart) / 2;
            boolean isLeftUpdated = false, isRightUpdate = false;
            if (index <= mid) {
                isLeftUpdated = update2(index, root.getLeftNode(), nodeStart, mid);
            } else {
                isRightUpdate = update2(index, root.getRightNode(), mid + 1, nodeEnd);
            }

            if (root.getValue() != 0 && (isLeftUpdated || isRightUpdate)) {
                root.setValue(root.getValue() - 1);
                return true;
            }
            return false;
        }

    public static void main(String[] args) {

        SetBitCountSegTree segTree = new SetBitCountSegTree();
        segTree.build(new int[4]);

        System.out.println(segTree.query(1,3));
        segTree.update2(3);
        System.out.println(segTree.query(1,3));
        segTree.update1(3);
        System.out.println(segTree.query(1,3));
    }
}
