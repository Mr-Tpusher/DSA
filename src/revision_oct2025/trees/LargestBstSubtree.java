package revision_oct2025.trees;
/*
* Given a BT find the largest BST subtree in it.
*
*                44
*             /      \
*           30         60
*         /   \      /   \
*        5     20   45    70
*                       /   \
*                     65      80
*
* Answer=5
*
* */
public class LargestBstSubtree {
    public static void main(String[] args) {
        BTNode root = BinaryTree.buildTree(new int[] {44, 30, 60, 5, 20, 45, 70, -1, -1, -1, -1, -1, -1, 65, 80});
        LargestBstSubtree obj = new LargestBstSubtree();
        System.out.println(obj.largestBst(root));
    }

    int largestBst(BTNode root) {
        return largestBstHelper(root).maxBstSize;
    }

    private Result largestBstHelper(BTNode node) {
        // every null node is a bst with size 0 and range +inf to -inf.
        // we have deliberately kept the range reverse so that at the leaf node comparisons get easy.
        if (node == null)
            return new Result(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Result left = largestBstHelper(node.left);
        Result right = largestBstHelper(node.right);

        if (left.isBst && right.isBst && node.val > left.rangeMax && node.val < right.rangeMin) {
            return new Result(
                    true,
                    Math.min(node.val, left.rangeMin),
                    Math.max(node.val, right.rangeMax),
                    left.maxBstSize + right.maxBstSize + 1
            );
        } else {
            return new Result(false, -1, -1, Math.max(left.maxBstSize, right.maxBstSize));
        }
    }


    static class Result {
        boolean isBst;
        int rangeMin;
        int rangeMax;
        int maxBstSize;

        public Result(boolean isBst, int rangeMin, int rangeMax, int maxBstSize) {
            this.isBst = isBst;
            this.rangeMin = rangeMin;
            this.rangeMax = rangeMax;
            this.maxBstSize = maxBstSize;
        }
    }

}

