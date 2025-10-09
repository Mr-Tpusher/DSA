package revison_oct2025.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        String[][] ans = solveNQueens(4);
        System.out.println(Arrays.deepToString(ans));

    }
    static String[][] solveNQueens(int A) {
        char[][] board = new char[A][A];
        for(char[] arr : board)
            Arrays.fill(arr, '.');

        List<String[]> answerList = new ArrayList<>();
        solveQ(board, 0, answerList);

        String[][] answer = new String[answerList.size()][];
        int i = 0;
        for (String[] s : answerList) {
            answer[i] = s;
            i++;
        }
        return answer;
    }

    static void solveQ(char[][] board, int row, List<String[]> answer) {
        int N = board.length;
        if (row == N) {
            String[] currAns = new String[board.length];
            for (int i = 0; i < N; i++) {
                currAns[i] = "";
                for (int j = 0; j < N; j++) {
                    currAns[i] += board[i][j];
                }
            }

            answer.add(currAns);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (canBePlaced(board, row, col)) {
                board[row][col] = 'Q';
                solveQ(board, row + 1, answer);
                board[row][col] = '.';
            }
        }
    }

    static boolean canBePlaced(char[][] board, int row, int col) {
        int N = board.length;

        // check column
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q')
                return false;
        }

        // check diagonal , only 2 directions
/*        for (int r1 = row, c1 = col; r1 < N && c1 < N; r1++, c1++) {
            if (board[r1][c1] == 'Q')
                return false;
        }*/

        for (int r1 = row, c1 = col; r1 >= 0 && c1 >= 0; r1--, c1--) {
            if (board[r1][c1] == 'Q')
                return false;
        }

/*        for (int r1 = row, c1 = col; r1 < N && c1 >= 0; r1++, c1--) {
            if (board[r1][c1] == 'Q')
                return false;
        }*/

        for (int r1 = row, c1 = col; r1 >= 0 && c1 < N; r1--, c1++) {
            if (board[r1][c1] == 'Q')
                return false;
        }

        return true;
    }
}
