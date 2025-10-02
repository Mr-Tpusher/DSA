package dsa_2024_25.backtracking;

public class Sudoku1 {
    public static void main(String[] args) {
        int[][] A = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        printBoard(A);

        for (int i = 0; i <= 5; i++) {
            System.out.println();
        }

        if (solveSudoku1(A)) {
            printBoard(A);
        } else {
            System.out.println("Solution does not exist.");
        }

    }

    public static boolean solveSudoku1(int[][] A) {
        // Iterate over each cell
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {

                int cellValue = A[i][j];
                // Pick an empty cell
                if (cellValue == 0) {

                    // Check for feasible options
                    for (int value = 1; value <= 9; value++) {


                        if (isFeasible(A, i, j, value)) {
                            A[i][j] = value;
                            // If feasible, recurse to solve the rest of the puzzle.
                            if (solveSudoku1(A)) {
                                return true;
                            }
                            // Backtrack :
                            // If the feasible value was correct then the flow won't reach
                            // here, If the flow reaches here means. the value wasn't feasible,
                            // just backtrack bro!
                            A[i][j] = 0;
                        }
                    }
                    // If we reach here, then it means that no number is feasible for this cell,
                    // means we choose the wrong path somewhere earlier
                    return false;
                }
            }
        }
        // all cells are filled correctly
        return true;
    }

    // Print the solved Sudoku board
    public static void printBoard(int[][] A) {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(A[r][d] + " ");
                // Print a vertical separator every 3 columns
                if ((d + 1) % 3 == 0 && d < 8) {
                    System.out.print("| ");
                }
            }
            System.out.print("\n");

            // Print a horizontal separator every 3 rows
            if ((r + 1) % 3 == 0 && r < 8) {
                System.out.println("---------------------");
            }
        }
    }

    public static boolean isFeasible(int[][] A, int row, int column, int value) {

        // 1. check row
        for (int col = 0; col < A.length; col++) {
            if (A[row][col] == value) {
                return false;
            }
        }

        for (int r1 = 0; r1 < A.length; r1++) {
            if (A[r1][column] == value) {
                return false;
            }
        }

        int gridRowStart = row / 3;
        int gridColumnStart = column / 3;
        for (int g1 = 3 * gridRowStart; g1 <= 3 * gridRowStart + 2; g1++) {
            for (int g2 = 3 * gridColumnStart; g2 <= 3 * gridColumnStart + 2; g2++) {
                if (A[g1][g2] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
