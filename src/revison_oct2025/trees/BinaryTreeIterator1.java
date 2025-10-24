package revison_oct2025.trees;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinaryTreeIterator1 {
    ArrayList<BTNode> inOrder;
    int currIndex;

    private BinaryTreeIterator1(BTNode root) {
        inOrder = inOrderTraversal(root);
        currIndex = -1;
    }

    public static void main(String[] args) {
        BTNode root = BinaryTree.buildTree(new int[] {1, 2, 3, 4, 5, -1, -1, 6, 7, -1, -1});
        System.out.println(BinaryTree.inOrder(root));

        BinaryTreeIterator1 itr = BinaryTreeIterator1.getIterator(root);

        while (itr.hasNext())
            System.out.println(itr.getNext());
    }

    static BinaryTreeIterator1 getIterator(BTNode root) {
        return new BinaryTreeIterator1(root);
    }

    boolean hasNext() {
        return currIndex + 1 < inOrder.size();
    }

    int getNext() {
        if (hasNext())
            return inOrder.get(++currIndex).val;
        throw new NoSuchElementException("no more elements in the tree.");
    }

    ArrayList<BTNode> inOrderTraversal(BTNode root) {
        ArrayList<BTNode> traversal = new ArrayList<>();
        inOrderTraversalHelper(root, traversal);
        return traversal;

    }

    private void inOrderTraversalHelper(BTNode node, ArrayList<BTNode> traversal) {
        if (node == null)
            return;

        inOrderTraversalHelper(node.left, traversal);
        traversal.add(node);
        inOrderTraversalHelper(node.right, traversal);
    }


}
