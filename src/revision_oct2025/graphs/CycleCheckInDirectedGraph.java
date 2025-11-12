package revision_oct2025.graphs;

import java.util.*;

/*
*           A
*         /   \
*       B       C
*        \     /
*           D
*          / \
*         E   F
*
* */
public class CycleCheckInDirectedGraph {
    public static void main(String[] args) {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addEdge('A', 'B');
        directedGraph.addEdge('A', 'C');
        directedGraph.addEdge('B', 'D');
        directedGraph.addEdge('C', 'D');
        directedGraph.addEdge('D', 'E');
        directedGraph.addEdge('D', 'F');
        directedGraph.addEdge('E', 'B');

        System.out.println(directedGraph.isCyclic());


    }

    private static class DirectedGraph {
        Map<Character, List<Character>> adjList = new HashMap<>();

        void addEdge(char src, char dest) {
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);
        }

        // for a directed graph, we need to keep track of 2 things
        // 1. overall visited nodes
        // 2. nodes in current recursion stack

        boolean isCyclic() {
            Set<Character> visited = new HashSet<>();
            Set<Character> inRecStack = new HashSet<>();

            for (char node : adjList.keySet()) {
                if (dfs(node, visited, inRecStack)) {
                    return true;
                }
            }

            return false;
        }

        boolean dfs(char node, Set<Character> visited, Set<Character> inRecStack) {
            visited.add(node);
            inRecStack.add(node);

            for (char neighbour : adjList.get(node)) {
                if (inRecStack.contains(neighbour))
                    return true;
                else if (!visited.contains(neighbour)) {
                    if (dfs(neighbour, visited, inRecStack))
                        return true;
                }
            }

            inRecStack.remove(node);
            return false;
        }
    }
}
