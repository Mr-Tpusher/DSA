package revision_oct2025.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeFromInOrderAndPreOrder {
    public static void main(String[] args) {
        java.util.ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3));
        java.util.ArrayList<Integer> B = new ArrayList<>(List.of(2, 1, 3));
        buildTree(A, B);
    }
    static BTNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return solve(A, B);
    }

    static BTNode solve(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {

        if (preOrder.isEmpty()) return null;

        BTNode currentRoot = new BTNode(preOrder.get(0));

        int currentRootIndexInInorder = inOrder.indexOf(currentRoot.val);

        ArrayList<Integer> leftSubTreeInOrder = new ArrayList<>(inOrder.subList(0, currentRootIndexInInorder));

        ArrayList<Integer> rightSubTreeInOrder = new ArrayList<>(inOrder.subList(currentRootIndexInInorder + 1, inOrder.size()));

        ArrayList<Integer> leftSubTreePreOrder = new ArrayList<>(preOrder.subList(1, 1 + leftSubTreeInOrder.size()));

        ArrayList<Integer> rightSubTreePreOrder = new ArrayList<>(preOrder.subList(1 + leftSubTreeInOrder.size() , preOrder.size()));


        currentRoot.left = solve(leftSubTreePreOrder, leftSubTreeInOrder);
        currentRoot.right = solve(rightSubTreePreOrder, rightSubTreeInOrder);


        return currentRoot;

    }
}
