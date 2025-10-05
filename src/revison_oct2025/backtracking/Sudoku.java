package revison_oct2025.backtracking;

class Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solve(board);
        printBoard(board);
    }

    public static boolean solve(char[][] board) {
        if (isSolved(board))
            return true;

        // check the cell with min possibilities
        int minPossibilites = Integer.MAX_VALUE;
        int minPosRow = -1;
        int minPosCol = -1;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.')
                    continue;

                // check all the possibilites
                int currPos = 0;
                for (int value = 1 ; value <= 9; value++) {
                    char charVal = (char) ('0' + value);
                    if (isFeasible(board, row, col, charVal)) {
                        currPos++;
                    }
                }
                if (currPos < minPossibilites) {
                    minPossibilites = currPos;
                    minPosRow = row;
                    minPosCol = col;
                }
            }
        }

        // By the time we reach here we will have the cell with min possibilites
        // put a possibility and recurse, if not feasible backtrack and try the next
        if (minPosRow == -1 || minPosCol == -1)
            return false;

        for (int val = 1; val <= 9; val++) {
            char charVal = (char) ('0' + val);
            if (isFeasible(board, minPosRow, minPosCol, charVal)) {
                board[minPosRow][minPosCol] = charVal;

                if (solve(board))
                    return true;

                else
                    board[minPosRow][minPosCol] = '.';


            }
        }

        return false;
    }

    public static boolean isFeasible(char[][] board, int row, int col, char val) {
        if (board[row][col] != '.')
            return false;

        // check the row
        for (int col1 = 0; col1 < 9; col1++) {
            if (board[row][col1] == val)
                return false;
        }

        // check the column
        for (int row1 = 0; row1 < 9; row1++) {
            if (board[row1][col] == val)
                return false;
        }

        // check the grid
        int p1 = row / 3;
        int p2 = col / 3;
        for (int i = 3 * p1; i <= 3 * p1 + 2; i++) {
            for (int j = 3 * p2; j <= 3 * p2 + 2; j++) {
                if (board[i][j] == val)
                    return false;
            }
        }
        return true;
    }

    public static boolean isSolved(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currVal = board[i][j];
                board[i][j] = '.';
                boolean feasible = isFeasible(board, i, j, currVal);
                board[i][j] = currVal;
                if (!feasible) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

}
