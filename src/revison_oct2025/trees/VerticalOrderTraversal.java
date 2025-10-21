package revison_oct2025.trees;

import java.util.*;

public class VerticalOrderTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(BTNode A) {
        return verticalOrderUsingTreeMap(A);
    }

    public ArrayList<ArrayList<Integer>> verticalOrderUsingTreeMap(BTNode A) {

        TreeMap<Integer, ArrayList<Integer>> nodeLevels = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(A, 0));

        while (!queue.isEmpty()) {
            Pair element = queue.poll();
            BTNode currNode = element.node;
            int level = element.level;

            // Process current
            nodeLevels.putIfAbsent(level, new ArrayList<Integer>());
            nodeLevels.get(level).add(currNode.val);

            // push left in the queue
            if (currNode.left != null)
                queue.offer(new Pair(currNode.left, level - 1));

            // push right in the queue
            if (currNode.right != null)
                queue.offer(new Pair(currNode.right, level + 1));

        }

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> e : nodeLevels.entrySet()) {
            output.add(e.getValue());
        }

        return output;

    }

    public ArrayList<ArrayList<Integer>> verticalOrderUsingMaxMin(BTNode A) {

        HashMap<Integer, ArrayList<Integer>> nodeLevels = new HashMap<>();
        int maxLevel = Integer.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(A, 0));

        while (!queue.isEmpty()) {
            Pair element = queue.poll();
            BTNode currNode = element.node;
            int level = element.level;
            maxLevel = Math.max(maxLevel, level);
            minLevel = Math.min(minLevel, level);

            // Process current
            nodeLevels.putIfAbsent(level, new ArrayList<Integer>());
            nodeLevels.get(level).add(currNode.val);

            // push left in the queue
            if(currNode.left != null)
                queue.offer(new Pair(currNode.left, level - 1));

            // push right in the queue
            if (currNode.right != null)
                queue.offer(new Pair(currNode.right, level + 1));

        }

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = minLevel; i <= maxLevel; i++) {
            output.add(nodeLevels.get(i));
        }

        return output;

    }

    static class Pair {
        BTNode node;
        int level;

        Pair(BTNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

}
