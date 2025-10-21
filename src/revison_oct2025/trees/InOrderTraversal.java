package revison_oct2025.trees;

import dsa_2024_25.stacks.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.right.left = new BTNode(5);
        root.right.right = new BTNode(6);
        root.right.right.right = new BTNode(7);

        System.out.print("Recursive inorder : " );
        recursiveInOrder(root);
        System.out.println();

        System.out.print("Iterative inorder : ");
        iterativeInOrder(root);
        System.out.println();

    }

    static void recursiveInOrder(BTNode curr) {
        if (curr == null)
            return;

        recursiveInOrder(curr.left);
        System.out.print(curr.val+ " ");
        recursiveInOrder(curr.right);
    }


    static void iterativeInOrder(BTNode curr) {
        Stack<BTNode> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BTNode temp = stack.pop();
                System.out.print(temp.val + " ");
                curr = temp.right;
            }

        }
    }
}
