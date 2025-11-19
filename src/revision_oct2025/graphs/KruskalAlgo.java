package revision_oct2025.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
* Find min spanning tree in the graph
*
*       2       3
*   0.----- 1 ----- 2
*   |     / |     /
* 6 |  8/  5|   /7
*   | /     | /
*   3       4
*
* */
public class KruskalAlgo {
    public static void main(String[] args) {

        Edge[] edges = {
                new Edge(0, 3, 6),
                new Edge(0, 1, 2),
                new Edge(1, 2, 3),
                new Edge(1, 3, 8),
                new Edge(1, 4, 5),
                new Edge(2, 4, 7)
        };

        ArrayList<Edge> mst = kruskal(edges, 5);
        System.out.println(mst);

    }

    static ArrayList<Edge> kruskal(Edge[] edges, int v) {
        // step 1 -> Sort the edges in non-decreasing order of weights
        // step 2 -> Initialize Disjoint Sets
        // step 3 -> Iterate over the sorted edges and add in MST if not part of the same connected component(set)

        // step 1
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        // step 2
        DisjointSet disjointSet = new DisjointSet(v);

        // step 3
        ArrayList<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int source = edge.source;
            int destination = edge.destination;
            if (disjointSet.find(source) != disjointSet.find(destination)) {
                mst.add(edge);
                disjointSet.union(source, destination);
            }
        }

        return mst;
    }

    private static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }

    private static class DisjointSet {
        private int[] parent;
        private int[] rank;

        DisjointSet(int V) {
            parent = new int[V];
            rank = new int[V];

            // initialize all the disjoints sets
            for (int i = 0; i < V; i++) {
                parent[i] = i;  // all nodes are their own parent
                rank[i] = 0;    // rank of all the nodes is 0
            }
        }

        int find(int x) {
            if (x == parent[x]) {
                return x;
            }

            // path compression
            parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int u = find(x);
            int v = find(y);

            if (u == v) {
                return false;
            }

            if (rank[u] < rank[v]) {
                parent[u] = v;
            } else if (rank[v] < rank[u]) {
                parent[v] = u;
            } else {
                parent[u] = v;
                rank[u]++;
            }

            return true;
        }
    }
}
