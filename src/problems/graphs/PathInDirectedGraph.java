package problems.graphs;
/*
* 

/**
 * Check Path from Node 1 to Node A in a Directed Graph
 *
 * Given a directed graph with A nodes (1 to A) and M edges (matrix B of size Mx2),
 * determine if a path exists from node 1 to node A.
 *
 * Return 1 if a path exists, otherwise return 0.
 *
 * Notes:
 * - No self-loops or multiple edges.
 * - Graph may be disconnected.
 * - Nodes are numbered 1 to A.
 * - Clear global variables if using multiple test cases.
 *
 * Constraints:
 * 2 <= A <= 10^5
 * 1 <= M <= min(200000, A*(A-1))
 * 1 <= B[i][0], B[i][1] <= A
 *
 * Input:
 * - int A: number of nodes
 * - int[][] B: M edges where B[i][0] -> B[i][1]
 *
 * Output:
 * - 1 if path exists from node 1 to node A, else 0
 *
 * Example:
 * Input:  A = 5, B = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 1
 */

import java.util.*;

public class PathInDirectedGraph {
    public static void main(String[] args) {
    }
        public int solve(int A, int[][] B) {
            DirectedGraph graph = new DirectedGraph(A, B);
            return graph.checkPath(1, A);
        }

        private static class DirectedGraph {
            int A;
            HashMap<Integer, List<Integer>> adjList;

            DirectedGraph(int A, int[][] B) {
                this.adjList = new HashMap<>();
                this.A = A;

                for (int[] edge : B) {
                    int src = edge[0];
                    int dest = edge[1];

                    adjList.putIfAbsent(src, new ArrayList<>());
                    if (!adjList.get(src).contains(dest))
                        adjList.get(src).add(dest);
                }
            }

            int checkPath(int src, int dest) {
                Set<Integer> visited = new HashSet<Integer>();
                return dfs(src, dest, visited);
            }

            int dfs(int src, int dest, Set<Integer> visited) {
                //System.out.println("src=" + src + ", dest = " + dest);

                visited.add(src);

                if (src == dest)
                    return 1;

                for (int neighbour : adjList.get(src)) {
                    System.out.println("neighbour = " + neighbour);
                    if(!visited.contains(neighbour)) {
                        if (dfs(neighbour, dest, visited) == 1)
                            return 1;
                    }
                }

                return 0;
            }
        }
    }