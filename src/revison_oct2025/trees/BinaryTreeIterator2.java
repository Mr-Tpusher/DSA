package revison_oct2025.trees;

import java.util.*;

public class BinaryTreeIterator2 {
    Deque<BTNode> stack = new ArrayDeque<>();

    public BinaryTreeIterator2(BTNode root) {
        pushLeftSubTreeToStack(root);
    }

    public static void main(String[] args) {
        BTNode root = BinaryTree.buildTree(new int[] {1, 2, 3, 4, 5, -1, -1, 6, 7, -1, -1});
        System.out.println(BinaryTree.inOrder(root));

        BinaryTreeIterator2 itr = new BinaryTreeIterator2(root);

        while (itr.hasNext())
            System.out.println(itr.getNext());
    }

    private void pushLeftSubTreeToStack(BTNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int getNext() {
        if (!hasNext())
            throw new NoSuchElementException("no more elements in the iterator.");

        BTNode curr = stack.pop();
        pushLeftSubTreeToStack(curr.right);
        return curr.val;
    }

}
