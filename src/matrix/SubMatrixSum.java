package matrix;

/*
 * Given a M*M matrix consider all the submatrices and 
 * get sum of all elements in those.
 * 
 */
public class SubMatrixSum {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        System.out.println( "subMatrixSum1(int[][] matrix) :" + subMatrixSum1(matrix));
        System.out.println( "subMatrixSum2(int[][] matrix) :" + subMatrixSum2(matrix));

    }

    public static int subMatrixSum1(int[][] matrix) {

        int rows = matrix.length;
        int answer = 0;
        for (int row1 = 0; row1 < rows; row1++) {
            int columns = matrix[row1].length;
            for (int column1 = 0; column1 < columns; column1++) {
                for (int row2 = row1; row2 < rows; row2++) {
                    for (int column2 = column1; column2 < columns; column2++) {
                        for (int row = row1; row <= row2; row++) {
                            for (int column = column1; column <= column2; column++) {
                                answer += matrix[row][column];
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }


    public static int subMatrixSum2(int[][] matrix) {

        int rows = matrix.length;
        int answer = 0;
        for (int row = 0; row < rows; row++) {
            int columns = matrix[row].length;
            for (int column = 0; column < columns; column++) {
                int element = matrix[row][column];
                answer += (row + 1) * (column + 1) * (rows - row) * (columns - column) * element;
            }
        }
        return answer;
    }

}
