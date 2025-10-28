package revision_oct2025.trees;

import java.util.LinkedList;
import java.util.Queue;

public class OddAndEvenLevels {
    public static void main(String[] args) {
        //return oddEven(A, 1);
    }
    int sum(BTNode A) {
        Queue<NodeAndLevel> q = new LinkedList<>();
        q.offer(new NodeAndLevel(A, 1));
        int sum = 0;

        while (!q.isEmpty()) {
            NodeAndLevel nodeLevel = q.poll();

            if (nodeLevel.level % 2 == 0)
                sum -= nodeLevel.node.val;
            else
                sum += nodeLevel.node.val;

            if (nodeLevel.node.left != null)
                q.offer(new NodeAndLevel(nodeLevel.node.left, nodeLevel.level + 1));
            if (nodeLevel.node.right != null)
                q.offer(new NodeAndLevel(nodeLevel.node.right, nodeLevel.level + 1));
        }

        return sum;

    }

    static class NodeAndLevel {
        BTNode node;
        int level;
        public NodeAndLevel(BTNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }


    static int oddEvenPostOrder(BTNode A, int level) {
        if (A == null) return 0;

        int left = oddEvenPostOrder(A.left, level + 1);
        int right = oddEvenPostOrder(A.right, level + 1);

        int sum = left + right;

        if (level % 2 == 0)
            sum -= A.val;
        else
            sum += A.val;
        return sum;
    }
}

