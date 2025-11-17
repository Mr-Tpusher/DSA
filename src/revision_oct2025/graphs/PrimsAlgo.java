package revision_oct2025.graphs;

import java.util.*;

/*
*
 * Find the MST in a given graph.
 *
 *             ___8___
 *            |       |
 *           2.---6---3.
 *        7/ |        |  \5
 *       1.  |8      2|    4.
 *        7\ |        |  /5
 *           6.---10---5.
 *
 * */
public class PrimsAlgo {
    public static void main(String[] args) {
        int N = 6;
        int[][] edges = {
                {1, 2, 7},
                {1, 6, 7},
                {2, 6, 8},
                {2, 3, 6},
                {3, 4, 5},
                {3, 5, 2},
                {4, 5, 5},
                {5, 6, 10}
        };

        Graph graph = new Graph(N, edges);
        System.out.println(graph.getMstWeightUsingPrims(1));
    }

    private static class Graph {
        int N;
        int[][] adjMat;
        Graph(int N, int[][] edges) {
            this.N = N;
            // consider 1-based indexing
            adjMat = new int[N + 1][N + 1];

            // mark all the weights/distances as Integer.MAX_VALUE initially
            for (int[] row : adjMat) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            // mark diagonal elements as 0 i.e. distance of the element from itself
            for (int i = 1; i <= N; i++) {
                adjMat[i][i] = 0;
            }

            for (int[] edge : edges) {
                int src = edge[0];
                int dest = edge[1];
                int weight = edge[2];

                // if statement will avoid self loops and multi-edges
                if (weight < adjMat[src][dest]) {
                    adjMat[src][dest] = weight;
                    adjMat[dest][src] = weight;
                }
            }
        }

        int getMstWeightUsingPrims(int src) {
            // Pre-requisite prims
            // 1. Graph should be fully connected
            // 2. No self-loops and multi-edges -> taken care in constructor

            // 1. checking if the graph is fully connected
            if (!isFullyConnected()) return Integer.MAX_VALUE;


            /*
            * Prim's algo:
            * 1. We start from a source node, mark it visited, put all the edges going from that node into the minheap.
            * 2. We pick the edge with min weight from the minheap, mark the node visited,
            *    and add all the edges going from that in the minheap.
            * */

            PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
            Set<Integer> visited = new HashSet<>();

            minHeap.add(new Edge(src, src, 0));
            //visited.add(src);

            int totalWeight = 0;
            while (!minHeap.isEmpty()) {
                Edge minEdge = minHeap.poll();
                int destination = minEdge.destination;
                int weight = minEdge.weight;

                if (!visited.contains(destination)) {
                    totalWeight += weight;
                    visited.add(destination);

                    // add all neighbours of destination in the min heap
                    for (int i = 1; i <= N; i++) {
                        if (!visited.contains(i) && adjMat[destination][i] != Integer.MAX_VALUE && destination != i) {
                            minHeap.add(new Edge(destination, i, adjMat[destination][i]));
                        }
                    }
                }
            }
            return totalWeight;
        }

        private static class Edge {
            int src;
            int destination;
            int weight;

            Edge(int src, int destination, int weight) {
                this.src = src;
                this.destination = destination;
                this.weight = weight;
            }
        }

        boolean isFullyConnected() {
            // if number of connected components in the graph is 1, then it is fully connected
            int connectedComponents = 0;
            Set<Integer> visited = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                    if (!visited.contains(i)) {
                        dfs(i, visited);
                        connectedComponents++;
                    }
                }
            return connectedComponents == 1;
        }

        void dfs(int i, Set<Integer> visited) {
            visited.add(i);

            for (int j = 1; j <= N; j++) {
                if (!visited.contains(j) && j != i && adjMat[i][j] != Integer.MAX_VALUE) {
                    dfs(j, visited);
                }
            }
        }
    }
}
