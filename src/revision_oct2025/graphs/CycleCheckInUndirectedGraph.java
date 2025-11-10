package revision_oct2025.graphs;

import java.util.*;

/*
* Given an undirected graph, check if there's a cycle or not
*
*   A - B
*   |   |
*   D - C
* */
public class CycleCheckInUndirectedGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'A');

        System.out.println(graph.isCyclic());
    }

    private static class Graph {
        Map<Character, List<Character>> adjList = new HashMap<>();

        void addEdge(char first, char second) {
            adjList.putIfAbsent(first, new ArrayList<>());
            adjList.putIfAbsent(second, new ArrayList<>());
            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }

        boolean isCyclic() {
            Set<Character> visited = new HashSet<>();
            for (char v : adjList.keySet()) {
                if (isCyclicHelper(v, ' ', visited)) {
                    return true;
                }
            }
            return false;
        }

        // dfs
        boolean isCyclicHelper(char vertex, char parent, Set<Character> visited) {
            // add the vertex to the visited set
            visited.add(vertex);

            // call dfs on all of vertex's neighbours
            for (char neighbour : adjList.get(vertex)) {
                if (visited.contains(neighbour) && neighbour != parent) {
                    return true;
                }
                else if(neighbour != parent) {
                    if (isCyclicHelper(neighbour, vertex, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }
}
