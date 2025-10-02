package dsa_2024_25.graphs;
/*
A country consist of N cities connected by N - 1 roads. King of that country want to
construct maximum number of roads such that the new country formed remains bipartite country.
Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way,
such that for each road (u, v) that belongs to the country, u and v belong to different sets.
* Also, there should be no multiple roads between two cities and no self loops.
Return the maximum number of roads king can construct.
Since the answer could be large return answer % 10^9 + 7.

NOTE: All cities can be visited from any city.
*
* */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class MaxRoads {
    static int MOD = 1000000007;

    public static void main(String[] args) {
        int A = 15;
        int[][] B =
                {{7,5},{15,14},{11,2},{8,7},{10,3},{5,3},{4,2},{6,4},{13,2},{3,2},{14,11},{12,9},{2,1},{9,2}};

        Graph graph = new Graph(A, B);
        System.out.println(graph.maxRoades());
    }

    private static class Graph {
        private HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        Graph(int A, int[][] B) {
            adjList = new HashMap<>();
            for (int i = 1; i <= A; i++) {
                adjList.put(i, new ArrayList<Integer> ());
            }
            for (int i = 0; i < B.length; i++) {
                int src = B[i][0], dest = B[i][1];
                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
        }

        int maxRoades() {
            HashSet<Integer> visited = new HashSet<>();
            HashMap<Integer, Integer> levelNodes = new HashMap<>();

            // DFS over all nodes and add it to the levelNodes - seggregating leves of a tree
            for (Integer node : adjList.keySet()) {
                if (!visited.contains(node)) {
                    dfs(node, 1, visited, levelNodes);
                }
            }

            // Calculate number of maxRoades
            int odd = 0, even = 0;
            for (Integer level : levelNodes.keySet()) {
                int nodes = levelNodes.get(level);
                if ((level & 1) == 0) {
                    even += nodes;
                } else {
                    odd += nodes;
                }
            }

            long roads = ((long) (odd % MOD) * (even % MOD) ) % MOD;

            return ((int)roads % MOD)  - (visited.size() - 1);

        }

        void dfs(Integer node, int level, HashSet<Integer> visited, HashMap<Integer, Integer> levelNodes) {

            visited.add(node);
            levelNodes.put(level, levelNodes.getOrDefault(level, 0) + 1);

            for (Integer neighbour : adjList.get(node)) {
                if (!visited.contains(neighbour)) {
                    dfs(neighbour, level + 1, visited, levelNodes);
                }
            }

        }

    }
}
