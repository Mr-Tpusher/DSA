package dsa_2024_25.segment_trees;

public class SegTreeNode {
    private int value;
    private SegTreeNode leftNode;
    private SegTreeNode rightNode;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SegTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(SegTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public SegTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(SegTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "SegTreeNode{" +
                "value=" + value +
                '}';
    }
}
