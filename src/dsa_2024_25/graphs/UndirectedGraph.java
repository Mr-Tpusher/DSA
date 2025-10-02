package dsa_2024_25.graphs;

import java.util.*;
/*
              0
             / \
            1   2
            |   |
            3   4
*/

public class UndirectedGraph<T> {
    private HashMap<T, List<T>> adjList;

    public UndirectedGraph() {
        adjList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T src, T dest) {
        addVertex(src);
        addVertex(dest);
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void bfs(T start) {
        HashSet<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            System.out.print(vertex + " ");

            // Add all the neighbours
            for (T ver : adjList.get(vertex)) {
                if (!visited.contains(ver)) {
                    visited.add(ver);
                    queue.add(ver);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T start) {
        Set<T> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    public void dfsRecursive(T vertex, Set<T> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (T neighbour : adjList.get(vertex)) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        graph.bfs(0);
        graph.dfs(0);
    }
}
