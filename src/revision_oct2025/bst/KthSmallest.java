package revision_oct2025.bst;

public class KthSmallest {

    static class CountAndResult {
        int count = 0;
        int result = -1;
    }
    public static void main(String[] args) {
        BSTNode root = BinarySearchTree.constructBST(new int[] {10, 5, 15, 2, 7, 12, 17});
        System.out.println(BinarySearchTree.inOrderTraversal(root));

        System.out.println(getKthSmallest1(root, 3));
        System.out.println(getKthSmallest2(root, 3));

    }

    static int getKthSmallest1(BSTNode root, int k) {
        CountAndResult countAndResult = new CountAndResult();
        getKthSmallestRec1(root, k, countAndResult);
        return countAndResult.result;
    }

    static void getKthSmallestRec1(BSTNode node, int k, CountAndResult countAndResult) {
        if (node == null || countAndResult.result != -1) return;

        getKthSmallestRec1(node.left, k, countAndResult);
        if (countAndResult.result != -1) return;

        countAndResult.count++;
        if (countAndResult.count == k) {
            countAndResult.result = node.val;
            return;
        }

        getKthSmallestRec1(node.right, k, countAndResult);
    }


    static int getKthSmallest2(BSTNode root, int k) {
        return getKthSmallestRec2(root, k, new int[]{0});
    }

    static int getKthSmallestRec2(BSTNode node, int k, int[] index) {
        if (node == null)
            return -1;

        int left = getKthSmallestRec2(node.left, k, index);
        if (left != -1)
            return left;

        // process current
        index[0]++;
        if (index[0] == k) {
            return node.val;
        }

        return getKthSmallestRec2(node.right, k, index);
    }
}
