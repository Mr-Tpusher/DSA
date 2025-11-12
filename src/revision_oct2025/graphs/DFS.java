package revision_oct2025.graphs;

import java.util.*;

/*
*           A ----Z
*         / | \  /
*       B   C   D
*      / \  /  / \
*     E    F  G   H
*
* */
public class DFS {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('A', 'Z');
        graph.addEdge('B', 'E');
        graph.addEdge('B', 'F');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'G');
        graph.addEdge('D', 'H');
        graph.addEdge('D', 'Z');

        graph.printGraph();
        graph.dfs('A');

    }

    private static class Graph {
        Map<Character, Set<Character>> adjList = new HashMap<>();

        void addEdge(char src, char dest) {
            adjList.putIfAbsent(src, new HashSet<>());
            adjList.putIfAbsent(dest, new HashSet<>());

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        void printGraph() {
            System.out.println(adjList);
        }

        void dfs(char src) {
            System.out.print("Pre order dfs : ");
            preOrderDFS(src, new HashSet<>());
            System.out.println();

            System.out.print("Post order dfs : ");
            postOrderDFS(src, new HashSet<>());
        }

        void preOrderDFS(char vertex, Set<Character> visited) {
            // base condition
            if (visited.contains(vertex)) return;

            // add to the visited set
            visited.add(vertex);

            // process the node -> pre-order style
            System.out.print(vertex + " ");

            // call dfs on neighbours
            for (char neighbour : adjList.get(vertex)) {
                preOrderDFS(neighbour, visited);
            }
        }

        void postOrderDFS(char vertex, Set<Character> visited) {
            if (visited.contains(vertex)) return;

            visited.add(vertex);

            for (char neighbour : adjList.get(vertex))  {
                postOrderDFS(neighbour, visited);
            }

            // process the vertex -> postorder style
            System.out.print(vertex + " ");

        }

    }
}
