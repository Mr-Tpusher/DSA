package revison_oct2025.trees;

public class HeightBalancedTree {

    public static void main(String[] args) {

    }

    static int isBalanced(BTNode A) {
        return isHeightBalanced(A).isBalanced ? 1 : 0;
    }

    static HeightBalancedStatus isHeightBalanced(BTNode A) {
        if (A == null)
            return new HeightBalancedStatus(-1, true);

        HeightBalancedStatus leftStatus = isHeightBalanced(A.left);
        if (!leftStatus.isBalanced)
            return new HeightBalancedStatus(leftStatus.height, false);

        HeightBalancedStatus rightStatus = isHeightBalanced(A.right);
        if (!rightStatus.isBalanced)
            return new HeightBalancedStatus(rightStatus.height, false);


        int currNodeHeight = 1 + Math.max(leftStatus.height, rightStatus.height);
        if (Math.abs(leftStatus.height - rightStatus.height) <= 1) {
            return new HeightBalancedStatus(currNodeHeight, true);
        } else {
            return new HeightBalancedStatus(currNodeHeight, false);
        }
    }

    static class HeightBalancedStatus {
        int height;
        boolean isBalanced;
        public HeightBalancedStatus(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
