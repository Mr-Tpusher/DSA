package dsa_2024_25.graphs;
/*
* Given an undirected Graph, check if there's a cycle or not.
* e.g. A - B
*      |   |        Answer: true
*      D - C
*
* e.g.      E - D
*           |   |   Answer: true
*       A - B - C
*
 * e.g.      E - D
 *           |      Answer: false
 *       A - B - C
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UndirectedCyclicCheck {

    public static void main(String[] args) {
        Graph graph1 = new Graph();
        graph1.addEdge('A', 'B');
        graph1.addEdge('B', 'C');
        graph1.addEdge('C', 'D');
        graph1.addEdge('D', 'A');
        System.out.println("Test Case 1: " + graph1.isCyclic());  // Expected: true

        // Test Case 2: Graph with no cycle
        Graph graph2 = new Graph();
        graph2.addEdge('A', 'B');
        graph2.addEdge('B', 'C');
        graph2.addEdge('C', 'D');
        graph2.addEdge('D', 'E');
        System.out.println("Test Case 2: " + graph2.isCyclic());  // Expected: false

        // Test Case 3: Graph with disconnected components (one cycle)
        Graph graph3 = new Graph();
        graph3.addEdge('A', 'B');
        graph3.addEdge('B', 'C');
        graph3.addEdge('C', 'A');
        graph3.addEdge('D', 'E');
        System.out.println("Test Case 3: " + graph3.isCyclic());  // Expected: true

        // Test Case 4: Graph with no edges
        Graph graph4 = new Graph();
        System.out.println("Test Case 4: " + graph4.isCyclic());  // Expected: false
    }



    private static class Graph {
        HashMap<Character, List<Character>> adjList;

        Graph() {
            adjList = new HashMap<>();
        }

        void addEdge(Character src, Character dest) {
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.putIfAbsent(dest, new ArrayList<>());
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        boolean isCyclic() {
            if (adjList.isEmpty())
                return false;

            // We'll go for DFS since we want to explore a particular path completely
            HashSet<Character> visited = new HashSet<>();

            // Let's iterate through all the vertices to ensure all connected components
            //are checked
            for (Character vertex : adjList.keySet()) {
                if (!visited.contains(vertex)) {
                    return isCyclic(vertex, null, visited);
                }
            }
            return true;
        }

        private boolean isCyclic(Character vertex, Character predecessor, HashSet<Character> visited) {
            visited.add(vertex);

            for (Character neighbour : adjList.get(vertex)) {
                if (visited.contains(neighbour) && neighbour != predecessor) {
                    return true;
                } else if (!visited.contains(neighbour)) {
                    return isCyclic(neighbour, vertex, visited);
                }
            }
            // if no cycle found
            return false;
        }
    }
}
