package revision_oct2025.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given a map after war between 2 countries I and P.
* Convert all the area under P to I if it is completely surrounded by I.
*
* */
public class MapAfterWar {
    public static void main(String[] args) {
        char[][] map = {
                {'I', 'I', 'P', 'I', 'I'},
                {'I', 'P', 'P', 'I', 'I'},
                {'I', 'I', 'I', 'I', 'P'},
                {'I', 'P', 'I', 'I', 'P'},
                {'I', 'P', 'P', 'I', 'P'},
                {'I', 'I', 'I', 'P', 'I'}
        };

        printMap(map);

        capture(map);

        printMap(map);


    }

    static void printMap(char[][] map) {
        for (char[] row : map) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void capture(char[][] map) {
        // idea is to start a multi-source or simple single source bfs from corner cells having 'P'
        int n = map.length;
        int m = map[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // add corner cells having 'P' into the queue
        addBoundaryPs(map, queue, visited);

        // start multi source bfs and mark 'P' as 'X'
        bfs(map, queue, visited);

        // iterate over the matrix and convert remaining 'P' into 'I' and 'X' into 'P'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'P')
                    map[i][j] = 'I';
                else if (map[i][j] == 'X')
                    map[i][j] = 'P';
            }
        }
    }

    static void bfs(char[][] map, Queue<int[]> queue, boolean[][] visited) {
        int n = map.length;
        int m = map[0].length;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            map[r][c] = 'X';

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int i = 0; i < 4; i++) {
                int newR = r + directions[i][0];
                int newC = c + directions[i][1];

                if (newR >= 0 && newR < n && newC >= 0 && newC < m && map[newR][newC] == 'P' && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    queue.add(new int[]{newR, newC});
                }
            }

        }
    }

    static void addBoundaryPs(char[][] map, Queue<int[]> queue, boolean[][] visited) {
        int n = map.length;
        int m = map[0].length;

        // top row
        int tr = 0;
        for (int col = 0; col < m; col++) {
            if (map[tr][col] == 'P') {
                queue.add(new int[]{tr, col});
                visited[tr][col] = true;
            }
        }

        // right column
        int rc = m - 1;
        for (int row = 0; row < n; row++) {
            if (map[row][rc] == 'P') {
                queue.add(new int[]{row, rc});
                visited[row][rc] = true;
            }
        }

        // bottom row
        int br = n - 1;
        for (int col = m - 1; col >= 0; col --) {
            if (map[br][col] == 'P') {
                queue.add(new int[]{br, col});
                visited[br][col] = true;
            }
        }

        // left col
        int lc = 0;
        for (int row = 0; row < n; row++) {
            if (map[row][lc] == 'P') {
                queue.add(new int[]{row, lc});
                visited[row][lc] = true;
            }
        }

    }
}
