package dsa_2024_25.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KruskalAlgo {
    public static void main(String[] args) {
        // Number of vertices (V) and edges (E)
        int V = 4;
        Edge[] edges = new Edge[] {
                new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(0, 3, 5),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4)
        };

        // Call Kruskal's algorithm
        ArrayList<Edge> mst = getMSTUsingKruskal(edges, V);
        System.out.println(mst);
        System.out.println(minCostOfMST(edges, V));

    }

    static ArrayList<Edge> getMSTUsingKruskal(Edge[] edges, int V) {
        // sort the edges
        Arrays.sort(edges, Comparator.comparingInt(a -> a.weight));

        DisjointSet ds = new DisjointSet(V);
        ArrayList<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;

            if (ds.findRoot(u) != ds.findRoot(v)) {
                mst.add(edge);
                ds.union(u, v);
            }
        }
        return mst;
    }

    static int minCostOfMST(Edge[] edges, int V) {
        int minCost = 0;
        for (Edge edge : getMSTUsingKruskal(edges, V)) {
            minCost += edge.weight;
        }
        return minCost;
    }

    private static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dest=" + dest +
                    ", weight=" + weight +
                    '}';
        }
    }

    private static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int findRoot(int x) {
            if (parent[x] != x) {
                parent[x] = findRoot(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = findRoot(x);
            int rootY = findRoot(y);

            if (rootX != rootY) {
                // union by rank
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                    rank[rootY]++;
                }
            }
        }
    }
}
