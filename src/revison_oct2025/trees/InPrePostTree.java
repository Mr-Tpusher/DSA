package revison_oct2025.trees;

import java.util.ArrayList;

/*
* Given an inorder, preorder and postorder traversal check if they represent the same tree.
*
* */
public class InPrePostTree {

    public static void main(String[] args) {
        BTNode root = BinaryTree.buildTree(new int[] {1, 2, 3, 4, 5, -1, 6});
        ArrayList<Integer> preorder = BinaryTree.preOrder(root);
        ArrayList<Integer> inorder = BinaryTree.inOrder(root);
        ArrayList<Integer> postOrder = BinaryTree.postOrder(root);
        //postOrder.set(postOrder.size() -1 , 55);
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postOrder);
        System.out.println(doesBelongToSameTree(preorder, inorder, postOrder));
    }

    static boolean doesBelongToSameTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        return check(preorder, 0, preorder.size() - 1,
                inorder, 0, inorder.size() - 1,
                postorder, 0, postorder.size() - 1);
    }

    static boolean check(
            ArrayList<Integer> preOrder, int preStart, int preEnd,
            ArrayList<Integer> inOrder, int inStart, int inEnd,
            ArrayList<Integer> postOrder, int postStart, int postEnd
    ) {

        // base cond, when array size is zero.
        if (preStart > preEnd) {
            return inStart > inEnd && postStart > postEnd;
        }

        if (!preOrder.get(preStart).equals(postOrder.get(postEnd)))
            return false;

        int root = preOrder.get(preStart);
        int inOrderRootIndex = inOrder.indexOf(root);
        if (inOrderRootIndex == -1)
            return false;

        int leftSize = inOrderRootIndex - inStart;
        int rightSize = inEnd - inOrderRootIndex;

        // left subtree
        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + leftSize - 1;
        int leftInStart = inStart;
        int leftInEnd = inOrderRootIndex - 1;
        int leftPostStart = postStart;
        int leftPostEnd = leftPostStart + leftSize - 1;

        // right subtree
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = rightPreStart + rightSize - 1;
        int rightInStart = inOrderRootIndex + 1;
        int rightInEnd = rightInStart + rightSize - 1;
        int rightPostStart = leftPostEnd + 1;
        int rightPostEnd = rightPostStart + rightSize - 1;

        boolean left = check(
                preOrder, leftPreStart, leftPreEnd,
                inOrder, leftInStart, leftInEnd,
                postOrder, leftPostStart, leftPostEnd
        );

        boolean right = check(
                preOrder, rightPreStart, rightPreEnd,
                inOrder, rightInStart, rightInEnd,
                postOrder, rightPostStart, rightPostEnd
        );

        return left && right;
    }

}
