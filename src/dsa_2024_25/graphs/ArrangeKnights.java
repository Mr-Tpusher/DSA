package dsa_2024_25.graphs;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
* Given an N*N chess board with K distinct knights already placed on it.
* If a knight is reachable from the other knight, they can be swapped.
* Find the total number of ways to arrange the knights.
* e.g.
*   0 0 0 k 0 0
*   k 0 0 0 0 0
*   0 0 0 0 k 0
*   0 k 0 0 k 0
*   0 0 0 k 0 0
*   0 0 0 k 0 0
* answer : 120 * 2 = 240 ways
*
*
* */
public class ArrangeKnights {
    /*
    * Essentially the question boils down
    * 1. Find connected components
    * 2. Find number of elements in each connected component
    * 3. Multiply ways to arrange the elements of each connected components
    *
    * */

    static final int[] rowDir = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] colDir = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        int N = 6;
        int[][] board = new int[N][N];
        // Place the knights
        board[0][3] = 1;
        board[1][0] = 1;
        board[2][4] = 1;
        board[3][1] = 1;
        board[4][3] = 1;

        board[3][4] = 1;
        board[5][3] = 1;

        System.out.println(ways(board, N));

    }

    static int ways(int[][] board, int N) {
        // find connected components and number of elements in it

        boolean[][] visited = new boolean[N][N];
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }

        int totalWays = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    int[] currCCWays = new int[1];
                    dfs(i, j, board, visited, currCCWays);
                    int componentSize = currCCWays[0];
                    System.out.println(componentSize);
                    totalWays *= getFactorial(componentSize);
                }
            }
        }
        return totalWays;
    }

    static void dfs(int i, int j, int[][] board, boolean[][] visited, int[] currCCWays) {
        visited[i][j] = true;
        currCCWays[0]++;

        for (int d = 0; d < 8; d++) {
            int newI = i + rowDir[d];
            int newJ = j + colDir[d];
            if (isValid(newI, newJ, board) && !visited[newI][newJ]) {
                dfs(newI, newJ, board, visited, currCCWays);
            }
        }

    }

    static boolean isValid(int i, int j, int[][] board) {
        int N = board.length;
        if (i >= 0 && i < N && j >= 0 && j < N && board[i][j] == 1) {
            return true;
        }
        return false;
    }

    static int getFactorial(int N) {
        int factorial = 1;
        for (int i = N; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
