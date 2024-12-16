package graphs;

import maths.HighestFactors;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.*;

/*
Given directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that
 there is an edge directed from node B[i][0] to node B[i][1].
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed
edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.
If there is a solution return the correct ordering. If there are multiple solutions print the lexicographically smallest one.
Ordering (a, b, c) is said to be lexicographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

 A = 6
 B = [  [6, 3]
        [6, 1]
        [5, 1]
        [5, 2]
        [3, 4]
        [4, 2] ]

 Output: [5, 6, 1, 3, 4, 2]

* */
public class TopologicalSort {
    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{6, 3}, {6, 1}, {5, 1}, {5, 2}, {3, 4}, {4, 2}};
        DirectAcyclicGraph dag = new DirectAcyclicGraph(A, B);
        ArrayList<Integer> ans = dag.topologicalSortUsingInDegree();
        System.out.println(ans);
    }

    private  static class DirectAcyclicGraph {
        private  HashMap<Integer, List<Integer>> adjList;

        DirectAcyclicGraph(int A, int[][] B) {
            adjList = new HashMap<>();
            // Create vertices
            for (int i = 1; i <= A; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for (int[] edge : B) {
                int src = edge[0];
                int dest = edge[1];
                adjList.get(src).add(dest);
            }
        }

        ArrayList<Integer> topologicalSortUsingInDegree() {
            // First find out InDegree of all the nodes
            HashMap<Integer, Integer> inDegrees = getInDegree();

            // Separate out the nodes with inDegree 0
            // let's use priority queue or min heap to ensure the lexicography order
            PriorityQueue<Integer> zeroInDegreeNodes = new PriorityQueue<>();
            for (Integer node : inDegrees.keySet()) {
                if (inDegrees.get(node) == 0) {
                    zeroInDegreeNodes.add(node);
                }
            }

            ArrayList<Integer> topologySort = new ArrayList<>();
            while (!zeroInDegreeNodes.isEmpty()) {
                Integer node = zeroInDegreeNodes.poll();
                topologySort.add(node);

                // Decrease the in-degree of neighbours
                for (Integer neighbour : adjList.get(node)) {
                    inDegrees.put(neighbour, inDegrees.get(neighbour) - 1);
                    // If the in-degree becomes zero, add it in the queue
                    if (inDegrees.get(neighbour) == 0) {
                        zeroInDegreeNodes.add(neighbour);
                    }
                }
            }

            // if the topological sort size is not equal to the nodes then there's a cycle
            if (topologySort.size() != adjList.size()) {
                return new ArrayList<>();
            }
            return topologySort;
        }

        private HashMap<Integer, Integer> getInDegree() {
            // InDegree - Number of incoming edges at a particular node
            HashMap<Integer, Integer> inDegrees = new HashMap<>();

            for (Integer node : adjList.keySet()) {
                inDegrees.put(node, 0);
            }

            // calculate the in-degree of each node
            for (Integer node : adjList.keySet()) {
                for (int neighbour : adjList.get(node)) {
                    inDegrees.put(neighbour, inDegrees.getOrDefault(neighbour, 0) + 1);
                }
            }
            return inDegrees;
        }
    }
}
