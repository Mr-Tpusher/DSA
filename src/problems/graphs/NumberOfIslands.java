package problems.graphs;
/*
Problem: Count the number of islands in a binary matrix

Given a matrix of integers A of size N x M consisting of 0 and 1.
A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1,
you can visit any cell that shares a corner with (i, j) and has value 1.

From cell (i, j), you can move to:
  - (i-1, j), (i+1, j), (i, j-1), (i, j+1)
  - (i-1, j-1), (i-1, j+1), (i+1, j-1), (i+1, j+1)
if the cell is inside the matrix and contains 1.

Task:
Return the number of islands in the matrix.

Constraints:
1 <= N, M <= 100
0 <= A[i][j] <= 1

Input:
An integer matrix A of size N x M.

Output:
An integer representing the number of islands.

Example 1:
Input:
A = [ [0, 1, 0],
      [0, 0, 1],
      [1, 0, 0] ]
Output:
2
Explanation:
The 1's at positions A[0][1] and A[1][2] form one island.
The other island is formed by A[2][0].

Example 2:
Input:
A = [ [1, 1, 0, 0, 0],
      [0, 1, 0, 0, 0],
      [1, 0, 0, 1, 1],
      [0, 0, 0, 0, 0],
      [1, 0, 1, 0, 1] ]
Output:
5

Explanation:
There are 5 islands in total.

*/
public class NumberOfIslands {
    static int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) {
        int[][] A = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };

        System.out.println(solve(A));
    }

    public static int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        // find total number of connected components
        int islands = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && A[i][j] == 1) {
                    dfs(i, j, visited, n, m, A);
                    islands++;
                }
            }
        }

        return islands;
    }

    static void dfs(int x, int y, boolean[][] visited, int n, int m, int[][] matrix) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(newX, newY, visited, n, m, matrix);
            }
        }
    }
}
