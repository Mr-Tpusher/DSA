package dsa_2024_25.segment_trees;
/*
* Given an integer array of size N where initially all elements are 1.
* Queries:
* 1 x ---> A[x] = 0
* 2 x ---> find the index of xth 1 in the array
*
* e.g.
*      0 1 2 3 4 5
* A = {1,1,1,1,1,1}
* Queries:
* 2 3 ---> index of 3rd one ---> 2
* 1 1 ---> A[i] = 0         A = {1,0,1,1,1,1}
* 2 3 ---> index of 3rd one ---> 3
*
*
* */
public class IndexOf1SegTree {
    // The node value of the segment tree should contain number of 1s in the range.
    private SegTreeNode root;
    int rangeStart;
    int rangeEnd;

    public IndexOf1SegTree(int totalArrayElements) {
        root = new SegTreeNode();
        rangeStart = 1;
        rangeEnd = totalArrayElements;
        build(root, rangeStart, rangeEnd);
    }

    public int build(SegTreeNode root, int nodeStart, int nodeEnd) {
        if (nodeStart == nodeEnd) {
            root.setValue(1);
            return 1;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;
        root.setLeftNode(new SegTreeNode());
        root.setRightNode(new SegTreeNode());

        int leftAnswer = build(root.getLeftNode(), nodeStart, mid);
        int rightAnswer = build(root.getRightNode(), mid + 1, nodeEnd);

        root.setValue(leftAnswer + rightAnswer);
        return leftAnswer + rightAnswer;
    }

    public void update(int index) {
        update(index, root, rangeStart, rangeEnd);
    }

    public int query(int x) {
        return query(x, root, rangeStart, rangeEnd);
    }

    private int query(int x, SegTreeNode root, int nodeStart, int nodeEnd) {

        if (nodeStart == nodeEnd) {
            return nodeStart;
        }

        if (root.getValue() < x) {
            return -1;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;
        if (root.getLeftNode().getValue() >= x) {
            return query(x, root.getLeftNode(),nodeStart, mid);
        } else {
            return query(x - root.getLeftNode().getValue(), root.getRightNode(), mid + 1, nodeEnd);
        }
    }


    private boolean update(int index, SegTreeNode root, int nodeStart, int nodeEnd) {
        // Base condition ---> Leaf node
        if (nodeStart == nodeEnd) {
            if (nodeStart == index && root.getValue() == 1) {
                root.setValue(0);
                return true;
            }
            return false;
        }

        int mid = nodeStart + (nodeEnd - nodeStart) / 2;
        boolean leftUpdated = false, rightUpdated = false;
        if (index <= mid) {
            leftUpdated = update(index, root.getLeftNode(), nodeStart, mid);
        } else {
            rightUpdated = update(index, root.getRightNode(), mid + 1, nodeEnd);
        }

        if (leftUpdated || rightUpdated) {
            root.setValue(root.getValue() - 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IndexOf1SegTree segTree = new IndexOf1SegTree(6);

        System.out.println(segTree.query(3));
        segTree.update(1);
        segTree.update(2);
        System.out.println(segTree.query(3));

    }
}
