package backtracking;
/*
* Problem Description
The N-queens puzzle is the problem of placing N queens on an N×N chessboard such that no two queens attack each other.

Given an integer A denoting the value of N, return all distinct solutions to the N-queens puzzle.

Each solution contains a distinct board configuration of the N-queens' placement, where 'Q' and '.' both indicate
* a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in
* reverse lexicographical order.


* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {

        int A = 4;
        List<List<String>> output = solveNQueens(A);
        printBoards(output);
    }

    public static List<List<String>> solveNQueens(int A) {

        List<List<String>> allSolutions = new ArrayList<>();
        int[] placedQueens = new int[A];
        Arrays.fill(placedQueens, -1);
        solve(A, 0, placedQueens, allSolutions);

        return allSolutions;
    }

    public static void solve(int A, int row, int[] placedQueens, List<List<String>> allSolutions) {
        if (row == A) {
            List<String> board = createBoard(A, placedQueens);
            allSolutions.add(board);
            return;
        }

        for (int col = 0; col < A; col++) {
            if (isValid(row, col, placedQueens)) {
                placedQueens[row] = col;
                solve(A, row + 1, placedQueens, allSolutions);
                placedQueens[row] = -1; // Let's backtrack
            }
        }
    }

    public static boolean isValid(int row, int col, int[] placedQueens) {
        for (int i = 0; i < row; i++) {
            int queenAtColumn = placedQueens[i];
            if (queenAtColumn == col) {
                return false;
            }
            if ((i + queenAtColumn == row + col) || (i - queenAtColumn == row - col)) {
                return false;
            }
        }
        return true;
    }

    public static void printBoards(List<List<String>> allSolutions) {
        for (List<String> board : allSolutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<String> createBoard(int A, int[] placedQueens) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            char[] row = new char[A];
            Arrays.fill(row, '.');
            row[placedQueens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
