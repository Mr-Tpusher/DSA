package dsa_2024_25.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a 2D matrix consisting of Residences and Hospitals.
 * For every Residence R, find the min distance from the Hospital H.
 *
 * input:
 * R R R H
 * R R H H
 * R H H R
 *
 * ans:
 * 3 2 1 0
 * 2 1 0 0
 * 2 0 0 1
 *
 * */
// Typical Multi Source BFS problem
public class MinDistFromHospital {

    // movement directions
    private static final int[] rowDir = new int[]{-1, 1, 0, 0};
    private static final int[] colDir = new int[]{0, 0, -1, 1};


    // Multi-Source BFS
    public static int[][] minDist(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        // result matrix
        int[][] result = new int[rows][cols];

        // Queue for BFS processing
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the result and populate queue for all hospitals
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 1) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Multi-Source BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newX = x + rowDir[i];
                int newY = y + colDir[i];

                // check if new position to be visited is within the bounds
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    // check if the distance of the cell to be visited can be updated
                    /* it can be updated if distance from current source is less than
                    / whatever is the value already there
                    */
                    if (result[newX][newY] > result[x][y] + 1) {
                        result[newX][newY] = result[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Input matrix
        int[][] grid = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };

        // Get the minimum distances matrix
        int[][] result = minDist(grid);

        // Print the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
