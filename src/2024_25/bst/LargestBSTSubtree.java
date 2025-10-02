package bst;
/*
* Given a BT, find the largest BST subtree in it. (largest in terms of no. of nodes)
*                44
*             /      \
*           30         60
*         /   \      /   \
*        5     20   45    70
*                       /   \
*                     65      80
*
* Answer=5
* */
public class LargestBSTSubtree {
    public static void main(String[] args) {
        BSTNode<Integer> root = buildBST();

        System.out.println(largestBST(root));

    }

    private static int largestBST(BSTNode<Integer> root) {
        Info info =  largestBSTRec(root);
        return info.getMaxBstSize();
    }

    private static Info largestBSTRec(BSTNode<Integer> root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);
        }

       // Since we need to look at both the subtrees first, we'll use postorder traversal.
       Info leftInfo = largestBSTRec(root.getLeft());
       Info rightInfo = largestBSTRec(root.getRight());

        if (leftInfo.isBST() && rightInfo.isBST() && root.getValue() > leftInfo.getRangeMax() &&
               root.getValue() < rightInfo.getRangeMin()) {

           int size = leftInfo.getSize() + rightInfo.getSize() + 1;
            return new Info(true,
                    Math.min(root.getValue(), leftInfo.getRangeMin()),
                    Math.max(root.getValue(), rightInfo.getRangeMax()),
                    size,
                    size);

       } else {

           int maxSize = Math.max(leftInfo.getMaxBstSize(), rightInfo.getMaxBstSize());
           return new Info(false, Integer.MIN_VALUE, Integer.MAX_VALUE,
                   0, maxSize);

       }
    }

    public static BSTNode<Integer> buildBST() {
        BSTNode<Integer> n44 = new BSTNode<>(44);
        BSTNode<Integer> n30 = new BSTNode<>(30);
        BSTNode<Integer> n60 = new BSTNode<>(60);
        BSTNode<Integer> n5 = new BSTNode<>(5);
        BSTNode<Integer> n20 = new BSTNode<>(20);
        BSTNode<Integer> n45 = new BSTNode<>(45);
        BSTNode<Integer> n70 = new BSTNode<>(70);
        BSTNode<Integer> n65 = new BSTNode<>(65);
        BSTNode<Integer> n80 = new BSTNode<>(80);

        n44.setLeft(n30);
        n44.setRight(n60);

        n30.setLeft(n5);
        n30.setRight(n20);

        n60.setLeft(n45);
        n60.setRight(n70);

        n70.setLeft(n65);
        n70.setRight(n80);

        return n44;
    }

}


class Info {
    private boolean isBST;
    private Integer rangeMin;
    private Integer rangeMax;
    private Integer size;
    private Integer maxBstSize;

    public Info(boolean isBST, Integer rangeMin, Integer rangeMax, Integer size, Integer maxBstSize) {
        this.isBST = isBST;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.size = size;
        this.maxBstSize = maxBstSize;
    }

    public boolean isBST() {
        return isBST;
    }

    public void setBST(boolean BST) {
        isBST = BST;
    }

    public Integer getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(Integer rangeMin) {
        this.rangeMin = rangeMin;
    }

    public Integer getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(Integer rangeMax) {
        this.rangeMax = rangeMax;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getMaxBstSize() {
        return maxBstSize;
    }

    public void setMaxBstSize(Integer maxBstSize) {
        this.maxBstSize = maxBstSize;
    }
}
