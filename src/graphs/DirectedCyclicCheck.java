package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*

Given a directed graph having A nodes. A matrix B of size M x 2 is given which represents
the M edges such that there is an edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present
else return 0.

NOTE:
The cycle must contain at least two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
*
* */
public class DirectedCyclicCheck {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3} };
        DirectedGraph dg = new DirectedGraph(A, B);
        System.out.println(dg.isCyclic());
    }

    private static class DirectedGraph {
        HashMap<Integer, List<Integer>> adjList;

        DirectedGraph() {
            adjList = new HashMap<>();
        }

        DirectedGraph(int A, int[][] B) {
            this();
            for (int i = 1; i <= A; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for (int i = 0; i  < B.length; i++) {
                adjList.get(B[i][0]).add(B[i][1]);
            }
        }

        int isCyclic() {
            /*
            In directed graphs, along with the overall visited nodes, we will have
            to keep the track of the elements which are explored during current recursive
            call.
            Note: simply draw cyclic directed and undirected graphs on a piece of paper
                  to properly understand this.
            */

            HashSet<Integer> visited = new HashSet<>();
            HashSet<Integer> recursionStack = new HashSet<>();

            for (Integer v : adjList.keySet()) {
                if (!visited.contains(v)) {
                    if (isCyclic(v, visited, recursionStack) == 1) {
                        return 1;
                    }
                }
            }
            return 0;
        }

        int isCyclic(Integer v, HashSet<Integer> visited, HashSet<Integer> recursionStack) {
            // Add current element to the recursion stack
            recursionStack.add(v);

            // Explore all neighbours of the current element
            for (Integer neighbour : adjList.get(v)) {
                // If already visited in current DFS path, we have a cycle
                if (recursionStack.contains(neighbour)) {
                    return 1;
                }

                // If this node was not already explored outside the current DFS path
                // then there's probability of finding a cycle here
                if (!visited.contains(neighbour)) {
                    if (isCyclic(neighbour, visited, recursionStack) == 1) {
                        return 1;
                    }
                }
            }
            // If we reach here, it means we explored all the DFS path for the current
            // node and did not find a cycle
            // 1. Let's remove this from the recursive stack so the parent of this node
            // can explore/DFS other nodes
            recursionStack.remove(v);

            // 2. Also since this node has been explored/DFSed fully, mark it as visited
            visited.add(v);

            // No cycle was found starting from this node.V
            return 0;
        }
    }
}
