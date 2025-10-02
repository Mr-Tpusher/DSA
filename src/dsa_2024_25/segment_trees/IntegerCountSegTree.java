package dsa_2024_25.segment_trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/*
* Given an array:
* A = {1, 100, 510, 225, 900, 8, 91}
*
* and two types of queries:
* Q1:(R1, R2) -> Find integers from the array lying between the range R1 and R2
* Q2:(i, x) -> Update the ith index to x
*
* 1 <= A[i] <= 10^9
* */
public class IntegerCountSegTree {
    private SegTreeNode root;
    int rangeStart;
    int rangeEnd;

    public IntegerCountSegTree(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.root = new SegTreeNode();
    }

    public void build(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int count = insertRec(A[i], root, rangeStart, rangeEnd);
            System.out.println(A[i] + ":" + count);
        }
    }

    private int query(int queryStart, int queryEnd) {
        return queryRec(queryStart, queryEnd, root, rangeStart, rangeEnd);
    }

    private void update(int oldValue, int newValue) {
        deleteRec(oldValue, root, rangeStart, rangeEnd);
        insertRec(newValue, root, rangeStart, rangeEnd);
    }

    private void deleteRec(int value, SegTreeNode root, int nodeStart, int nodeEnd) {
        // Safety check
        if (value < nodeStart || value > nodeEnd) {
            throw new NoSuchElementException("Invalid Element");
        }

        //Base case
        if (nodeStart == nodeEnd) {
            int updatedCount = root.getValue();
            --updatedCount;
            root.setValue(updatedCount);
            return;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        if (value <= mid) {
            deleteRec(value, root.getLeftNode(), nodeStart, mid);
        } else {
            deleteRec(value, root.getRightNode(), mid + 1, nodeEnd);
        }
        // Decrement current node value if it has children
        if (root.getLeftNode() != null && root.getLeftNode().getValue() > 0) {
            root.setValue(root.getValue() - 1);
        }
        if (root.getRightNode() != null && root.getRightNode().getValue() > 0) {
            root.setValue(root.getValue() - 1);
        }
    }

    public int queryRec(int queryStart, int queryEnd, SegTreeNode node, int nodeStart, int nodeEnd) {
        System.out.println("nodeStart:" + nodeStart + ", nodeEnd:" + nodeEnd);
        // Safety check
        if (node == null) {
            return 0;
        }

        // Base case - No overlap
        if (queryEnd < nodeStart || queryStart > nodeEnd) {
            return 0;
        }

        // Complete overlap - if node ranges are completely inside query ranges
        if (nodeStart >= queryStart && nodeEnd <= queryEnd) {
            return node.getValue();
        }

        // Partial overlap - Recurse
        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        int leftCount = queryRec(queryStart, queryEnd, node.getLeftNode(), nodeStart, mid);
        int rightCount = queryRec(queryStart, queryEnd, node.getRightNode(), mid + 1, nodeEnd);

        return leftCount + rightCount;
    }

    private int insertRec(int value, SegTreeNode root, int rangeStart, int rangeEnd) {
        // Base condition - Increment the count at the Leaf node
        if (rangeStart == rangeEnd) {
            int valueCount = root.getValue();
            valueCount++;
            root.setValue(valueCount);
            return valueCount;
        }

        // The element will lie either on left or right
        int mid = rangeStart + (rangeEnd - rangeStart) / 2;
        int childCount;
        if (value <= mid) {
            if (root.getLeftNode() == null) {
                root.setLeftNode(new SegTreeNode());
            }
            childCount = insertRec(value, root.getLeftNode(), rangeStart, mid);
        } else {
            if (root.getRightNode() == null) {
                root.setRightNode(new SegTreeNode());
            }
            childCount = insertRec(value, root.getRightNode(), mid + 1, rangeEnd);
        }

        // Update the current node count based on their child count update
        root.setValue(root.getValue() + childCount);

        return childCount;
    }





    public static void main(String[] args) {
        int[] A = {1, 100, 510, 225, 900, 8, 91, 1000};
        int[][] queries = {
                {1, 120, 900},
                {2, 100, 10},
                {1, 1, 900},
                {2, 1, 225},
                {1,5,1000}
        };

        IntegerCountSegTree segTree = new IntegerCountSegTree(1, 1000);
        segTree.build(A);

        ArrayList<Integer> output = new ArrayList<>();
        for (int[] q : queries) {
            System.out.println("query:" + Arrays.toString(q));
            if (q[0] == 1) {
                output.add(segTree.query(q[1], q[2]));
            } else {
                segTree.update(q[1], q[2]);
            }
        }

        System.out.println(output);





    }




}
