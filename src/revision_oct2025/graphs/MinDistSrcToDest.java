package revision_oct2025.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given an N * M matrix and also a source and destination, find the length of the shortest path from source to destination.
* Note:
* 1. It is not an adjacency matrix
* 2. Some of the cells in the matrix are going to be marked as 'x' indicating that, you cannot travel to them.
* 3. From a particular cell, you can move in all the 4 directions.
*
* matrix = 1 1 1 x 1
*          s 1 1 1 x
*          1 1 x 1 1
*          x 1 1 1 d
*          1 1 1 x 1
*
* answer -> 6
*
* */


public class MinDistSrcToDest {

    // row and column navigation
    static final int[] rowDir = {1, -1, 0, 0};
    static final int[] colDir = {0, 0, -1, 1};

    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '1', '1', 'x', '1'},
            {'s', '1', '1', '1', 'x'},
            {'1', '1', 'x', '1', '1'},
            {'x', '1', '1', '1', 'd'},
            {'1', '1', '1', 'x', '1'}
        };

        int srcX = 1, srcY = 0;
        int destX = 3, destY = 4;

        int minDist = findShortestPath(matrix, srcX, srcY, destX, destY);
        System.out.println(minDist);

    }


    static int findShortestPath(char[][] matrix, int srcX, int srcY, int destX, int destY) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // to hold the visited cells
        boolean[][] visited = new boolean[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        int[] src = {srcX, srcY, 0};

        queue.add(src);
        visited[srcX][srcY] = true;

        while (!queue.isEmpty()) {
            int[] vertex = queue.poll();
            int x = vertex[0];
            int y = vertex[1];
            int distance = vertex[2];

            if (x == destX && y == destY) {
                return distance;
            }

            // add all neighbours of the node to the queue

            for (int i = 0; i < 4; i++) {
                int newX = x + rowDir[i];
                int newY = y + colDir[i];

                if (isValid(newX, newY, matrix, rows, columns) && !visited[newX][newY]) {
                    int[] neighbour = {newX, newY, distance + 1};
                    queue.add(neighbour);
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }

    static boolean isValid(int x, int y, char[][] matrix, int rows, int cols) {

        if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] != 'x')
            return true;
        return false;
    }
}
