package dsa_2024_25.graphs;

import java.util.Arrays;

/*
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
public class FloydWarshall {
    public static void main(String[] args) {
        int[][] adjMat = {
                {0, 5, -1, 10},
                {-1, 0, 3, -1},
                {-1, -1, 0, 1},
                {-1, -1, -1, 0}};

        int[][] answer = floydWarshall(adjMat);

        for (int[] arr : answer) {
            System.out.println(Arrays.toString(arr));
        }
    }


    static int[][] floydWarshall(int[][] adjMat) {
        /*
         * In Floyd-Warshall algo we consider every node as an intermediate node and calculate distance
         * between source and destination
         * */
        int length = adjMat.length;
        int[][] answer = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (adjMat[i][j] == -1) {
                    answer[i][j] = Integer.MAX_VALUE;
                } else {
                    answer[i][j] = adjMat[i][j];
                }
            }
        }

        // Consider each node as an intermediate node
        for (int k = 0; k < length; k++) {
            // Iterate over each cell
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    // skip the diagonal or kth row or kth column
                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    // update
                    if (answer[i][k] != Integer.MAX_VALUE && answer[k][j] != Integer.MAX_VALUE) {
                        answer[i][j] = Math.min(answer[i][j], answer[i][k] + answer[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (answer[i][j] == Integer.MAX_VALUE)
                    answer[i][j] = -1;
            }
        }
        return answer;
    }
}
