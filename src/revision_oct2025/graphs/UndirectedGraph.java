package revision_oct2025.graphs;

import java.util.*;

public class UndirectedGraph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    void addEdge(Integer src, Integer dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());

        if (!adjList.get(src).contains(dest))
            adjList.get(src).add(dest);

        if (!adjList.get(dest).contains(src))
            adjList.get(dest).add(src);
    }

    void bfs(Integer src) {
        if (!adjList.containsKey(src)) {
            System.out.println("Node not found in graph:" + src);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        System.out.println("bfs starting from the source : " + src);
        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            System.out.print(v + " ");
            for (int i : adjList.get(v)) {
                if (!visited.contains(i)) {
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }

        System.out.println();
    }

    void dfs(Integer src) {
        System.out.println("dfs starting from the src = " + src);
        HashSet<Integer> visited = new HashSet<>();
        dfsHelper(src, visited);

    }

    void dfsHelper(Integer src, HashSet<Integer> visited) {
        visited.add(src);
        System.out.print(src + " ");

        for (Integer neighbour : adjList.get(src)) {
            if (!visited.contains(neighbour))
                dfsHelper(neighbour, visited);
        }
    }


    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(0, 1);
        graph.addEdge(0,2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.bfs(0);
        graph.dfs(0);
    }




}
