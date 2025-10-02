package dsa_2024_25.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sudoku2 {
    public static void main(String[] args) {

        char[][] A = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(A);

    }

    public static void solveSudoku(char[][] A) {

        ArrayList<Set<Character>> rows = new ArrayList<>();
        ArrayList<Set<Character>> columns = new ArrayList<>();
        ArrayList<Set<Character>> grids = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(i, new HashSet<>());
            columns.add(i, new HashSet<>());
            grids.add(i, new HashSet<>());
        }

        // Populate the hashsets
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                char element = A[i][j];
                if (element == '.') {
                    continue;
                }
                rows.get(i).add(element);
                columns.get(j).add(element);
                int gridNumber = ((i / 3) * 3) + (j / 3);
                grids.get(gridNumber).add(element);
            }
        }

        if (isSolved(A, rows, columns, grids)) {
            printBoard(A);
        } else {
            System.out.println("Solution does not exist!");
        }
    }


    public static boolean isSolved(char[][] A, ArrayList<Set<Character>> rows,
                                   ArrayList<Set<Character>> columns,
                                   ArrayList<Set<Character>> grids) {

        // Find an element with minimum possibilities
        int row, col, minPossibilities;
        row = col = -1;
        minPossibilities = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] != '.') {
                    continue;
                }
                int numberOfPossibilities = 0;
                for (char c = '1'; c <= '9'; c++) {
                    if (rows.get(i).contains(c)) {
                        continue;
                    }
                    if (columns.get(j).contains(c)) {
                        continue;
                    }
                    int gridNumber = ((i / 3) * 3) + (j / 3);
                    if (grids.get(gridNumber).contains(c)) {
                        continue;
                    }
                    numberOfPossibilities++;
                }
                if (numberOfPossibilities < minPossibilities) {
                    minPossibilities = numberOfPossibilities;
                    row = i;
                    col = j;
                }
            }
        }

        if (row == -1 && col == -1) {
            return true;
        }

        for (char c = '1'; c <= '9'; c++) {
            if (rows.get(row).contains(c)) {
                continue;
            }
            if (columns.get(col).contains(c)) {
                continue;
            }
            int gridNumber = ((row / 3) * 3) + (col / 3);
            if (grids.get(gridNumber).contains(c)) {
                continue;
            }

            A[row][col] = c;
            rows.get(row).add(c);
            columns.get(col).add(c);
            grids.get(gridNumber).add(c);

            if (isSolved(A, rows, columns, grids)) {
                return true;
            }
            A[row][col] = '.';
            rows.get(row).remove(c);
            columns.get(col).remove(c);
            grids.get(gridNumber).remove(c);
        }
        return false;
    }


    public static void printBoard(char[][] A) {
        for (char[] c : A) {
            for (char ch : c) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

}
