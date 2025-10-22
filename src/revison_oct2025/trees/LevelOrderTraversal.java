package revison_oct2025.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.right.left = new BTNode(5);
        root.right.right = new BTNode(6);
        root.right.right.left = new BTNode(7);
        root.right.right.right = new BTNode(8);

        System.out.println(levelOrderTraversal(root));
        System.out.println(iterativeLevelOrder(root));

    }

    static ArrayList<Integer> levelOrderTraversal(BTNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        if (root == null) return output;

        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BTNode curr = queue.poll();
            output.add(curr.val);
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }
        return output;
    }



    static ArrayList<ArrayList<Integer>> iterativeLevelOrder(BTNode node) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (node == null)
            return ans;

        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            ArrayList<Integer> currLevel = new ArrayList<>();
            int currLevelSize = queue.size();
            for (int i = 0; i < currLevelSize; i++) {
                BTNode temp = queue.poll();
                currLevel.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            ans.add(currLevel);
        }
        return ans;
    }
}
