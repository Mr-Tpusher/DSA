package revision_oct2025.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* Given a 2D matrix consisting of residences and hospitals.
* For every residence R, find the min distance from a hospital H.
*
*
*   R R R H
*   R R H H
*   R H H R
*
*   3 2 1 0
*   2 1 0 0
*   1 0 0 1
*
*
*
* */
public class MinDistFromHospital {
    static int[] rowDir = {-1, 1, 0, 0};
    static int[] colDir = {0, 0, -1, 1};

    public static void main(String[] args) {
        char[][] cityMap = {
                {'R', 'R', 'R', 'H'},
                {'R', 'R', 'H', 'H'},
                {'R', 'H', 'H', 'R'}
        };

        int[][] result = solve1(cityMap);

        for (int[] row : result)
            System.out.println(Arrays.toString(row));

    }

    static int[][] solve1(char[][] cityMap) {
        int rows = cityMap.length;
        int cols = cityMap[0].length;
        int[][] result = new int[rows][cols];

        for (int[] row : result)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cityMap[i][j] == 'R')
                    nearestHospitalFromResidence(i, j, cityMap, result, rows, cols);
                if (cityMap[i][j] == 'H')
                    result[i][j] = 0;
            }
        }

        return result;
    }

    static void nearestHospitalFromResidence(int i, int j, char[][] cityMap, int[][] result, int rows, int cols) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // add the residence to the queue and also mark it visited
        queue.offer(new Node(i,j, 0));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.i;
            int y = node.j;
            int distance = node.distance;

            if (cityMap[x][y] == 'H') {
                result[i][j] = distance;
                return;
            }

            // add neighbours in all four directions to the queue
            for (int z = 0; z < 4; z++) {
                int newX = x + rowDir[z];
                int newY = y + colDir[z];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    queue.offer(new Node(newX, newY, distance + 1));
                }
            }
        }
    }

    static class Node {
        int i;
        int j;
        int distance;
        Node(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

}
