package revison_oct2025.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.right.left = new BTNode(5);
        root.right.right = new BTNode(6);
        root.right.right.right = new BTNode(7);
        System.out.println(recursivePreOrder(root, new ArrayList<>()));
        System.out.println(iterativePreOrder(root));
    }

    static ArrayList<Integer> recursivePreOrder(BTNode curr, ArrayList<Integer> output) {
        if (curr == null)
            return output;

        output.add(curr.val);
        recursivePreOrder(curr.left, output);
        recursivePreOrder(curr.right, output);

        return output;
    }

    static ArrayList<Integer> iterativePreOrder(BTNode curr) {
        ArrayList<Integer> output = new ArrayList<>();
        Deque<BTNode> stack = new ArrayDeque<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                curr = stack.pop().right;

            } else {
                output.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
        }

        return output;
    }

}
