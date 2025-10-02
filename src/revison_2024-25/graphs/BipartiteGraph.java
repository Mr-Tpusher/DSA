package graphs;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.*;

/*
Given an undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges
such that there is an edge between B[i][0] and B[i][1].
Find whether the given graph is bipartite or not.
A graph is bipartite if we can split it's set of nodes into two independent subsets A and B
such that every edge in the graph has one node in A and another node in B

Note:
There are no self-loops in the graph.
No multiple edges between two pair of vertices.
The graph may or may not be connected.
Nodes are Numbered from 0 to A-1.
*
* */
public class BipartiteGraph {
    // Use graph colouring concept, if we are able to colour the whole graph in 2 colours, it is Bipartite.
    public static void main(String[] args) {
        int A = 2;
        int[][] B = {{0, 1}};
        Graph graph1 = new Graph(A, B);
        System.out.println(graph1.isBipartite());

        int A2 = 3;
        int[][] B2 = {{0, 1}, {0, 2}, {1, 2}};
        Graph graph2 = new Graph(A2, B2);
        System.out.println(graph2.isBipartite());
    }

    private static class Graph {
        HashMap<Integer, List<Integer>> adjList;

        Graph(int A, int[][] B) {
            adjList = new HashMap<>();
            for (int i = 0; i < A; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for (int i = 0; i < B.length; i++) {
                int src = B[i][0], dest = B[i][1];
                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
        }

        int isBipartite() {
            // A DFS over all the nodes

            // visited map
            HashMap<Integer, String> visited = new HashMap<>();

            for (Integer node : adjList.keySet()) {
                if (!visited.containsKey(node)) {
                    if (dfs(node, visited, "black") == 0) {
                        return 0;
                    }
                }
            }
            return 1;
        }

        int dfs(Integer node, HashMap<Integer, String> visited, String colour) {
            visited.put(node, colour);

            for (Integer neighbour : adjList.get(node)) {
                String neighbourColour;
                if (!visited.containsKey(neighbour)) {
                    neighbourColour = colour.equals("black") ? "white" : "black";
                    if (dfs(neighbour, visited, neighbourColour) == 0) {
                        return 0;
                    }
                } else {
                    neighbourColour = visited.get(neighbour);
                    if (colour.equals(neighbourColour)) {
                        return 0;
                    }
                }
            }
            return 1;
        }
    }
}
