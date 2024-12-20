package graphs;

import java.util.*;

public class DijkstraAlgo {
    public static void main(String[] args) {
        int A = 6;
        int[][] B = { {0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1}};
        int C = 4;

        Graph graph = new Graph(A, B);
        int[] answer = graph.dijkstra(C);
        System.out.println(Arrays.toString(answer));

    }

    private static class Graph {
        private  HashMap<Integer, List<Edge>> adjList;

        Graph(int A, int[][] edges) {
            adjList = new HashMap<>();
            for (int i = 0; i < A; i++) {
                adjList.put(i, new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                int src = edges[i][0], dest = edges[i][1], weight = edges[i][2];
                adjList.get(src).add(new Edge(dest, weight));
                adjList.get(dest).add(new Edge(src, weight));
            }
        }

        int[] dijkstra(int source) {
            PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distanceFromSource));
            minHeap.add(new Node(source, 0));
            int[] minDist = new int[adjList.size()];
            Arrays.fill(minDist, Integer.MAX_VALUE);

            while (!minHeap.isEmpty()) {
                Node curr = minHeap.poll();
                int vertex = curr.vertex;
                int dist = curr.distanceFromSource;
                if (dist < minDist[vertex]) {
                    minDist[vertex] = dist;
                    for (Edge e : adjList.get(vertex)) {
                        minHeap.add(new Node(e.dest, e.weight + dist));
                    }
                }
            }

            for (int i = 0; i < minDist.length; i++) {
                if (minDist[i] == Integer.MAX_VALUE) {
                    minDist[i] = -1;
                }
            }
            return minDist;
        }

    }

    private static class Edge  {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static class Node {
        int vertex;
        int distanceFromSource;

        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.distanceFromSource = dist;
        }
    }
}
