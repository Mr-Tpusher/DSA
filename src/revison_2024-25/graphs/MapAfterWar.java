package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * There are two countries I and P.
 * We are given the state of the map after the war between 'I' and 'P'.
 * Initially the complete map belonged to I, then P had attacked and occupied some territory.
 * 'I' is a very peaceful country, after winning the war, I has decided not to take entire land
 * of the country P which they occupied in I.
 * I is going to take only the land which is completely surrounded by I.
 * Find out the state of the map after I takes back the land.
 * e.g.                         ans:
 * I I P I I                     I I P I I
 * I P P I I                     I P P I I
 * I I I I P                     I I I I P
 * I P I I P                     I I I I P
 * I P P I I                     I I I I P
 * I I I P I                     I I I P I
 *
 *
 * */
public class MapAfterWar {

    private static int[] rowDir = {-1, 1, 0, 0};
    private static int[] colDir = {0, 0, -1, 1};

    public static void main(String[] args) {
        Character[][] map = {
                {'I', 'I', 'P', 'I', 'I'},
                {'I', 'P', 'P', 'I', 'I'},
                {'I', 'I', 'I', 'I', 'P'},
                {'I', 'P', 'I', 'I', 'P'},
                {'I', 'P', 'P', 'I', 'I'},
                {'I', 'I', 'I', 'P', 'I'}
        };

        System.out.println("Before War:");
        printMap(map);
        reclaimLand(map);
        System.out.println("\nAfter War:");
        printMap(map);
    }

    // Function to print the map
    public static void printMap(Character[][] map) {
        for (Character[] row : map) {
            for (Character cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    static void reclaimLand(Character[][] map) {
        /*
         * The idea here is to start from the edges and look for the connected components
         * of P.
         *   -> For this, find all Ps at edges and start a Multi-source BFS.
         * Mark CCs temporarily with some special characters say 'X'.
         * Then again iterate over the array and
         *   -> Convert Ps into Is
         *   -> convert those 'X's into Ps.
         *
         * */

        int rows = map.length;
        int columns = map[0].length;

        // get source for Multi-source BFS
        Queue<int[]> queue = new LinkedList<>();
        getBoundaryNodes(map, queue);

        Boolean[][] visited = new Boolean[rows][columns];
        for (Boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }

        // start BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];
            visited[row][col] = true;

            if (map[row][col] == 'P') {
                // temporarily mark the cell 'X'
                map[row][col] = 'X';

                for (int i = 0; i < 4; i++) {
                    int newRow = row + rowDir[i];
                    int newCol = col + colDir[i];

                    if (isValid(newRow, newCol, map) && !visited[newRow][newCol]) {
                       queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        // mark P to I and X -> P
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (map[i][j] == 'P') {
                    map[i][j] = 'I';
                } else if (map[i][j] == 'X') {
                   map[i][j] = 'P';
                }
            }
        }
    }

    static boolean isValid(int row, int col, Character[][] map) {
        int rows = map.length;
        int columns = map[0].length;

        if (row < rows && row >= 0 && col < columns && col >= 0 && map[row][col] == 'P') {
            return true;
        }
        return false;
    }

    static void getBoundaryNodes(Character[][] map, Queue<int[]> queue) {
        int rows = map.length;
        int columns = map[0].length;

        // top row
        for (int row = 0, col = 0; col < columns; col++) {
            if (map[row][col] == 'P') {
                queue.offer(new int[]{row, col});
            }
        }
        // right column
        for (int row = 0, col = columns - 1; row < rows; row++) {
            if (map[row][col] == 'P') {
                queue.offer(new int[]{row, col});
            }
        }
        // bottom row
        for (int row = rows - 1, col = columns - 1; col >= 0; col--) {
            if (map[row][col] == 'P') {
                queue.offer(new int[]{row, col});
            }
        }
        // left column
        for (int row = rows - 1, col = 0; row >= 0; row--) {
            if (map[row][col] == 'P') {
                queue.offer(new int[]{row, col});
            }
        }
    }
}
