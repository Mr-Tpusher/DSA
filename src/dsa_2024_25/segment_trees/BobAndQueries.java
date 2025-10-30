package dsa_2024_25.segment_trees;
import java.util.Arrays;
/*
 * Bob and Queries
 * -------------------
 * Problem Description:
 * Bob has an array A of N integers. Initially, all elements of the array are zero.
 * You have to perform Q operations on this array. Each operation is one of three types:
 *
 * 1. If x = 1: Update the value of A[y] to 2 * A[y] + 1.
 * 2. If x = 2: Update the value of A[y] to floor(A[y] / 2).
 * 3. If x = 3: Consider all A[i] such that y <= i <= z. Convert each A[i] to its binary
 *    representation, concatenate all binary strings, and count the number of '1's in the
 *    resulting string.
 *
 * Queries are given in a 2D array B of size Q x 3 where:
 * - B[i][0] = x
 * - B[i][1] = y
 * - B[i][2] = z
 *
 * Problem Constraints:
 * 1 <= N, Q <= 100000
 * 1 <= y, z <= N
 * 1 <= x <= 3
 *
 * Input Format:
 * - int A: the size of the array
 * - int[][] B: a 2D array of queries of size Q x 3
 *
 * Output Format:
 * - Return an int[] where each element corresponds to the result of a type 3 query.
 *
 * Example Input 1:
 * A = 5
 * B = {
 *     {1, 1, -1},
 *     {1, 2, -1},
 *     {1, 3, -1},
 *     {3, 1, 3},
 *     {3, 2, 4}
 * }
 *
 * Example Output 1:
 * [3, 2]
 *
 * Example Input 2:
 * A = 5
 * B = {
 *     {1, 1, -1},
 *     {1, 2, -1},
 *     {3, 1, 3},
 *     {2, 1, -1},
 *     {3, 1, 3}
 * }
 *
 * Example Output 2:
 * [2, 1]
 */

public class BobAndQueries {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {
                {1, 1, -1},
                {1, 2, -1},
                {1, 3, -1},
                {3, 1, 3},
                {3, 2, 4}
        };

         BobAndQueries b = new BobAndQueries();
         int[]  output = b.solve(A, B);
        System.out.println(Arrays.toString(output));

    }


    public int[] solve(int A, int[][] B) {
        SegmentTree segmentTree = new SegmentTree(A);

        int outputLength = 0;
        for (int[] q : B) {
            if (q[0] == 3)
                outputLength++;
        }
        int[] output = new int[outputLength];

        for (int i = 0, k = 0; i < B.length; i++) {
            int[] query = B[i];

            switch(query[0]) {

                case 1:
                    segmentTree.update1(query[1]);
                    break;

                case 2:
                    segmentTree.update2(query[1]);
                    break;

                case 3:
                    output[k++] = segmentTree.query(query[1], query[2]);
                    break;
            }
        }

        return output;
    }

    static class SegmentTree {
        Node root;
        int rootRangeStart;
        int rootRangeEnd;

        SegmentTree(int arraySize) {
            this.root =  new Node();
            this.rootRangeStart = 1;
            this.rootRangeEnd = arraySize;
            build(root, rootRangeStart, rootRangeEnd);
        }

        private void build(Node root, int rootRangeStart, int rootRangeEnd) {
            // base case - leaf node
            if (rootRangeStart == rootRangeEnd) {
                root.val = 0;
                return;
            }

            int mid = rootRangeStart + (rootRangeEnd - rootRangeStart) / 2;

            root.left = new Node();
            root.right = new Node();

            build(root.left, rootRangeStart, mid);
            build(root.right, mid + 1, rootRangeEnd);
        }

        private int query(int index1, int index2) {
            return queryHelper(root, rootRangeStart, rootRangeEnd, index1, index2);
        }

        private int queryHelper(Node root, int rootRangeStart, int rootRangeEnd, int index1, int index2) {
            // base case - No overlap
            if (index2 < rootRangeStart || index1 > rootRangeEnd) {
                return 0;
            }

            // Complete overlap
            if (index1 <= rootRangeStart && index2 >= rootRangeEnd) {
                return root.val;
            }

            // Partial overlap - explore both the children
            int mid = rootRangeStart + (rootRangeEnd - rootRangeStart) / 2;
            int left = queryHelper(root.left, rootRangeStart, mid, index1, index2);
            int right = queryHelper(root.right, mid + 1, rootRangeEnd, index1, index2);

            return left + right;
        }

        void update1(int index) {
            update1Helper(index, root, rootRangeStart, rootRangeEnd);
        }

        void update1Helper(int index, Node root, int rootRangeStart, int rootRangeEnd) {
            if (index < rootRangeStart || index > rootRangeEnd) return;

            if (rootRangeStart == rootRangeEnd && index == rootRangeStart) {
                root.val += 1;
                return;
            }

            int mid = rootRangeStart + (rootRangeEnd - rootRangeStart) / 2;

            if (index <= mid) {
                update1Helper(index, root.left, rootRangeStart, mid);
            } else {
                update1Helper(index, root.right, mid + 1, rootRangeEnd);
            }

            root.val = root.left.val + root.right.val;
        }


        void update2(int index) {
            update2Helper(index, root, rootRangeStart, rootRangeEnd);
        }

        void update2Helper(int index, Node root, int rootRangeStart, int rootRangeEnd) {
            if (index < rootRangeStart || index > rootRangeEnd) return;

            if (rootRangeStart == rootRangeEnd && index == rootRangeStart) {
                if (root.val != 0) root.val -= 1;
                return;
            }

            int mid = rootRangeStart + (rootRangeEnd - rootRangeStart) / 2;

            if (index <= mid) {
                update2Helper(index, root.left, rootRangeStart, mid);
            } else {
                update2Helper(index, root.right, mid + 1, rootRangeEnd);
            }

            root.val = root.left.val + root.right.val;
        }




        static class Node {
            int val;
            Node left;
            Node right;
            Node() {
                this.left = null;
                this.right = null;
            }
        }
    }
}

