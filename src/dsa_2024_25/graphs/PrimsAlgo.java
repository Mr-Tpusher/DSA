package dsa_2024_25.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/*
 * Find the MST in a given graph.
 *
 *             ___8___
 *            |       |
 *           2.---6---3.
 *        7/ |        |  \5
 *       1.  |8      2|     4.
 *        7\ |        |    /5
 *           6.---10---5.
 *
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
        System.out.println(graph.getMSTWeight(1));
    }

    private static class Graph {
        int N;
        int[][] adjMat;

        Graph(int N, int[][] edges) {
            this.N = N;
            // 1-based indexing
            this.adjMat = new int[N + 1][N + 1];

            for (int[] arr : adjMat) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            for (int i = 0; i <= N; i++) {
                adjMat[i][i] = 0;
            }

            for (int i = 0; i < edges.length; i++) {
                int src = edges[i][0], dest = edges[i][1], weight = edges[i][2];
                if (weight < adjMat[src][dest]) {
                    adjMat[src][dest] = weight;
                    adjMat[dest][src] = weight;
                }
            }

            for (int[] arr : adjMat) {
                System.out.println(Arrays.toString(arr));
            }
        }

        boolean isFullyConnected() {
            return totalConnectedComponents() <= 1;
        }

        int totalConnectedComponents() {
            HashSet<Integer> visited = new HashSet<>();

            int totalCCs = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited.contains(i)) {
                    dfs(i, visited);
                    totalCCs++;
                }
            }
            return totalCCs;
        }

        void dfs(int v, HashSet<Integer> visited) {
            visited.add(v);

            for (int i = 1; i <= N; i++) {
                if (!visited.contains(i) && adjMat[v][i] != Integer.MAX_VALUE && v != i) {
                    dfs(i, visited);
                }
            }
        }


        int getMSTWeight(int u) {
            // first check if the graph is connected
            if (!isFullyConnected()) {
                return Integer.MAX_VALUE;
            }
            // remove self loops and multi-edges if any - taken care in the constructor

            // Create MST
            PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
            HashSet<Integer> visited = new HashSet<>();

            visited.add(u);
            // Add all the outgoing edges to the minHeap
            for (int i = 1; i < adjMat.length; i++) {
                if (adjMat[u][i] != Integer.MAX_VALUE && u != i) {
                    minHeap.add(new Node(i, adjMat[u][i]));
                }
            }

            int totalWeight = 0;
            while (!minHeap.isEmpty()) {
                Node min = minHeap.poll();
                int destination = min.destination;
                if (!visited.contains(destination)) {
                    totalWeight += min.weight;
                    visited.add(destination);
                    // Add all neighbours of destination
                    for (int i = 1; i < adjMat.length; i++) {
                        if (!visited.contains(i) && adjMat[destination][i] != Integer.MAX_VALUE && i != destination) {
                            minHeap.add(new Node(i, adjMat[destination][i]));
                        }
                    }

                }
            }
            return totalWeight;
        }
    }

    private static class Node {
        int destination;
        int weight;

        Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }
}
