package segment_trees;

/*
 * Given an array A of integers with Q queries i.e.:
 * 1 i x ---> A[i] = x
 * 2 i j ---> A[i] + 2 A[i+1] + 3 A[i+2] + ..... + (j-i+1) A[j]
 * considering 1 based indexing
 *
 * e.g.
 * A = {1,2,3,4,5,6}
 * q: 2 2 4 ---> 1 * 2 + 2 * 3 + 3 * 4 = 20
 *
 *
 * */
public class WeightedSum {
    /* The weighted sum equation can be broken down into two equations and those two
        values could be stored in each node separately.

        eq = {[i-(i-1)] * A[i]} + {[(i+1)-(i-1)] * A[i+1]} + ... + {[(j-(i-1)] * A[j]}
        eq = i*A[i] + (i+1)*A[i+1] + (i+2)*A[i+2] + ... + j*A[j]
            - {(i-1) * [A[i] + A[i+1] + ....]}
    *
    * */

    public static void main(String[] args) {
        //int[] A = {0, 2, 3, 1, 5};
        int[] A = {0, 1, 2, 3, 4, 5, 6};
        SegTree segTree = new SegTree(A);
        System.out.println(segTree.query(2,4));
        //segTree.update(1,5);

    }

}


class SegTree {
    Node root;
    int rangeStart;
    int rangeEnd;

    public SegTree(int[] A) {
        root = new Node();
        rangeStart = 1;
        rangeEnd = A.length - 1;
        build(A);
    }

    void build(int[] A) {
        build(A, root, rangeStart, rangeEnd);
    }

    void update(int index, int newValue) {
        update(index, newValue, root, rangeStart, rangeEnd);
    }

    int query(int queryStart, int queryEnd) {
        Sums sums =  query(queryStart, queryEnd, root, rangeStart, rangeEnd);
        return sums.sum1 - (queryStart - 1) * sums.sum2;
    }

    Sums query(int queryStart, int queryEnd, Node root, int nodeStart, int nodeEnd) {
        // Base condition ---> No overlap
        if (queryEnd < nodeStart || queryStart > nodeEnd) {
            return new Sums(0, 0);
        }

        // Complete Overlap
        if (nodeStart >= queryStart && nodeEnd <= queryEnd) {
            return new Sums(root.sum1, root.sum2);
        }

        // Partial Overlap
        int mid = nodeStart + (nodeEnd - nodeStart) / 2;
        Sums sums1 = query(queryStart, queryEnd, root.leftChild, nodeStart, mid);
        Sums sums2 = query(queryStart, queryEnd, root.rightChild, mid + 1, nodeEnd);

        return new Sums(sums1.sum1 + sums2.sum1 , sums1.sum2 + sums2.sum2);

    }


    Sums update(int index, int newValue, Node root, int rangeStart, int rangeEnd) {
        if (rangeStart == rangeEnd) {
            if (rangeStart == index) {
                int newSum1 = rangeStart * newValue;
                int sum1Diff = newSum1 - root.sum1;
                root.sum1 = newSum1;

                int sum2Diff = newValue - root.sum2;
                root.sum2 = newValue;

                return new Sums(sum1Diff, sum2Diff);
            }
            return new Sums(0,0);
        }

        int mid = rangeStart + (rangeEnd - rangeStart) / 2;
        Sums sumDiffs;

        if (index <= mid) {
            sumDiffs = update(index, newValue, root.leftChild, rangeStart, mid);
        } else {
            sumDiffs = update(index, newValue, root.rightChild, mid + 1, rangeEnd);
        }

        root.sum1 = root.sum1 + sumDiffs.sum1;
        root.sum2 = root.sum2 + sumDiffs.sum2;

        return sumDiffs;
    }

    void build(int[] A, Node root, int nodeStart, int nodeEnd) {
        // Base condition
        if (nodeStart == nodeEnd) {
            int sum1 = nodeStart * A[nodeStart];
            int sum2 = A[nodeStart];
            root.sum1 = sum1;
            root.sum2 = sum2;
            return;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;

        root.leftChild = new Node();
        root.rightChild = new Node();

        build(A, root.leftChild, nodeStart, mid);
        build(A, root.rightChild, mid + 1, nodeEnd);

        root.sum1 = root.leftChild.sum1 + root.rightChild.sum1;
        root.sum2 = root.leftChild.sum2 + root.rightChild.sum2;
    }
}


class Node {
    int sum1;
    int sum2;
    Node leftChild;
    Node rightChild;
}


class Sums {
    int sum1;
    int sum2;

    Sums(int sum1, int sum2) {
        this.sum1 = sum1;
        this.sum2 = sum2;
    }
}