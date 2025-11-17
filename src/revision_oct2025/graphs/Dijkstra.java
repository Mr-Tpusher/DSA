package revision_oct2025.graphs;
/*
 * Problem: Shortest Distance from Source in a Weighted Undirected Graph
 *
 * Given a weighted undirected graph with A nodes (0 to A-1) and M edges, and a source node C,
 * compute an array D where:
 *   - D[i] is the shortest distance from C to node i
 *   - D[i] = -1 if node i is not reachable from C
 *
 * Notes:
 *   - No self-loops or multiple edges between the same pair of vertices.
 *   - Graph may be disconnected.
 *
 * Constraints:
 *   1 <= A <= 10^5
 *   0 <= B[i][0], B[i][1] < A
 *   0 <= B[i][2] <= 10^3
 *   0 <= C < A
 *
 * Input:
 *   int A          : number of nodes
 *   int[][] B      : Mx3 matrix where each row [u, v, w] represents an edge from u to v with weight w
 *   int C          : source node
 *
 * Output:
 *   int[] D        : shortest distance array from source C
 *
 * Example:
 *   Input:
 *     A = 6
 *     B = [[0,4,9],[3,4,6],[1,2,1],[2,5,1],[2,4,5],[0,3,7],[0,1,1],[4,5,7],[0,5,1]]
 *     C = 4
 *   Output:
 *     D = [7, 6, 5, 6, 0, 6]
 */

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{0,4,9},{3,4,6},{1,2,1},{2,5,1},{2,4,5},{0,3,7},{0,1,1},{4,5,7},{0,5,1}};
        int C = 4;

        Graph graph = new Graph(A, B);
        int[] minDistances = graph.dijkstra(A, C);
        System.out.println(Arrays.toString(minDistances));

    }

    private static class Graph {
        HashMap<Integer, List<Edge>> adjList;

        Graph(int A, int[][] edges) {
            adjList = new HashMap<>();

            for (int i = 0; i < A; i++) {
                adjList.put(i, new ArrayList<>());
            }

            for (int i = 0; i < edges.length; i++) {
                int source = edges[i][0];
                int destination = edges[i][1];
                int weight = edges[i][2];

                adjList.get(source).add(new Edge(destination, weight));
                adjList.get(destination).add(new Edge(source, weight));
            }
        }

        int[] dijkstra(int A, int src) {
            int[] D = new int[A];
            Arrays.fill(D, Integer.MAX_VALUE);

            PriorityQueue<Node> minHeap = new PriorityQueue<>(
                    Comparator.comparingInt(node -> node.distanceFromSource));

            minHeap.add(new Node(src, 0));

            while (!minHeap.isEmpty()) {
                Node  node = minHeap.poll();
                if (D[node.vertex] > node.distanceFromSource) {
                    D[node.vertex] = node.distanceFromSource;

                    for (Edge neighbour : adjList.get(node.vertex)) {
                        int destNode = neighbour.node;
                        int destWeight = neighbour.weight;
                        minHeap.add(new Node(destNode, node.distanceFromSource + destWeight));
                    }
                }
            }

            for (int i = 0; i < D.length; i++) {
                if (D[i] == Integer.MAX_VALUE) {
                    D[i] = -1;
                }
            }

            return D;
        }
    }

    private static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static class Node {
        int vertex;
        int distanceFromSource;

        Node(int node, int distanceFromSource) {
            this.vertex = node;
            this.distanceFromSource = distanceFromSource;
        }
    }
}
