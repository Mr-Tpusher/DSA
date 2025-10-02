package dsa_2024_25.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given a N*M matrix and also a source and destination.
* Find the length of the shortest path from source to destination.
* Note:
* 1. Matrix is not an adjacency matrix
* 2. Some of the cells in the matrix are marked X indicating cannot visit them.
*
*  1 1 1 x 1
*  s 1 1 1 x
*  1 1 x 1 1
*  x 1 1 1 d
*  1 1 1 x 1
*
* */
public class MinDistSrcToDest {

    // movement directions
    private static final int[] rowDir = {-1, 1, 0, 0}; // Up, Down
    private static final int[] colDir = {0, 0, -1, 1}; // Left, Right

    // Check if cell is within the bounds and not marked x
    public static boolean isValid(int x, int y, int rows, int cols, char[][] grid, boolean[][] visited) {
        return (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] != 'x' && !visited[x][y]);
    }


    // method to get the shortest path from source to destination
    public static int minDist(char[][] grid, int rows, int cols, int sx, int sy, int dx, int dy) {
        // Visited array to track already visited cells
        boolean[][] visited = new boolean[rows][cols];

        // BFS queue to hold the current cell co-ordinates and the distance from the source
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];

            // If destination reached
            if (x == dx && y == dy) {
                return dist;
            }

            // explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newX = x + rowDir[i];
                int newY = y + colDir[i];

                if (isValid(newX, newY, rows, cols, grid, visited)) {
                    visited[newX][newY] = true;
                    queue.offer(new int[] {newX, newY, dist + 1});
                }
            }
        }
        // no path found
        return -1;
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', 'x', '1'},
                {'s', '1', '1', '1', 'x'},
                {'1', '1', 'x', '1', '1'},
                {'x', '1', '1', '1', 'd'},
                {'1', '1', '1', 'x', '1'}
        };

        int rows = 5;
        int columns = 5;

        // source and destination co-ordinates
        int sx = 1, sy = 0;      // (1,0)
        int dx = 3, dy = 4;      // (3,4)

        int ans = minDist(grid, rows, columns, sx, sy, dx, dy);
        System.out.println(ans);
    }
}
