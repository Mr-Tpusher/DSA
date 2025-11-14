package revision_oct2025.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* Given an n * n chess board, with k distinct knights already placed on it. If a knight is reachable from the other
* knight, they can be swapped.
* Find number of ways to arrange the knights.
*
                        {0, 0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1},
                        {0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0}

*
*   ans= 120 * 2 = 240
*
* */
public class ArrangeKnights {
    static int[][] directions = {{-2, 1}, {-2, -1} , {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {1, 2}, {-1, 2}};

    public static void main(String[] args) {
        int[][] board =
                {
                        {0, 0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1},
                        {0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0}
                };

        System.out.println(numberOfWays(board));
    }

    static int numberOfWays(int[][] board) {
        // find connected components
        ArrayList<ArrayList<ArrayList<Integer>>> connectedComponents = new ArrayList<>();
        getConnectedComponents(board, connectedComponents);
        System.out.println(connectedComponents);

        // find number of elements in each connected component
        int numberOfWays = 1;
        for (ArrayList<ArrayList<Integer>> cc : connectedComponents) {
            numberOfWays *= factorial(cc.size());
        }

        return numberOfWays;
    }

    static int factorial(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    static void getConnectedComponents(int[][] board, ArrayList<ArrayList<ArrayList<Integer>>> connectedComponents) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    ArrayList<ArrayList<Integer>> cc = new ArrayList<>();
                    dfsCc(i, j, board, visited, cc, n, m);
                    connectedComponents.add(cc);
                }
            }
        }
    }

    static void dfsCc(int r, int c, int[][] board, boolean[][] visited, ArrayList<ArrayList<Integer>> cc, int n, int m) {
        cc.add(new ArrayList<>(Arrays.asList(r,c)));
        visited[r][c] = true;

        // traverse over all the neighbours to which a knight can travel
        for (int i = 0; i < 8; i++) {
            int newR = r + directions[i][0];
            int newC = c + directions[i][1];
            if (newR >= 0 && newR < n && newC >= 0 && newC < m && board[newR][newC] == 1 && !visited[newR][newC]) {
                dfsCc(newR, newC, board, visited, cc, n, m);
            }
        }

    }
}
