package revision_oct2025.graphs;
/*
*
Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
If there is no possible path from vertex i to vertex j , B[i][j] = -1

Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Example Input:
A = [ [0 , 50 , 39],
      [-1 , 0 , 1],
      [-1 , 10 , 0] ]

Example Output:
[ [0 , 49 , 39 ],
  [-1 , 0 , 1 ],
  [-1 , 10 , 0 ] ]
* */

import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {
        int[][] adjMat =
                {
                        {0, 50, 39},
                        {-1, 0, 1},
                        {-1, 10, 0}
                };

        int[][] result = floydWarshall(adjMat);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }


    }

    // we can update the results in the same adjMat as well, but since the problem asks for a separate answer matrix
    // we will return a separate matrix

    static int[][] floydWarshall(int[][] adjMat) {

        // In floyd-warshall, we consider each vertex as an intermediate vertex and calculate the min distance between
        // each possible source and destination in the graph.

        int N = adjMat.length;

        int[][] result = new int[N][N];

        // mark the edges with distance -1 as Integer.MAX_VALUE because we will be taking minimum of two values
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adjMat[i][j] == -1) {
                    result [i][j] = Integer.MAX_VALUE;
                } else {
                    result [i][j] = adjMat[i][j];
                }
            }
        }

        // consider each vertex as intermediate one
        for (int i = 0; i < N; i++) {
            // update min distance for each source and destination
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // skip the cells having the intermediate node as source or destination
                    // also skip diagonal elements since min distance form a vertex A to A is always 0
                    if (i == j || i == k || j == k)
                        continue;

                    /*
                     consider 3 vertices A, B, C.
                     if we are finding min distance between A to C via B,
                     and there is no edge from A to B or B to C, then that edge value will be Integer.MAX_VALUE.
                     and the addition result[A][B] + result[A][C] will overflow.

                     so essentially the result[A][C] will remain as it is.
                     */

                    if (result[j][i] != Integer.MAX_VALUE && result[i][k] != Integer.MAX_VALUE) {
                        result[j][k] = Math.min(result[j][k], result[j][i] + result[i][k]);
                    }
                }
            }
        }

        // mark those Integer.MAX_VALUE back to -1, indicating absence fo an edge.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (result[i][j] == Integer.MAX_VALUE)
                    result[i][j] = -1;
            }
        }

        return result;
    }
}
