package dsa_2024_25.matrix;

public class PrintMatrix {
    
    public static void main(String[] args) {
   
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8} , {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6} , {7, 8, 9}};

        printSubMatrix(matrix);
    }


    public static void printSubMatrix(int[][] matrix) {
        int rows = matrix.length;

        // Left top point of the matrix
        for(int row1 = 0; row1 < rows; row1++) {
            int columns = matrix[row1].length;
            for (int column1 = 0; column1 < columns ; column1++) {

                // Right bottom point of the matrix
                for (int row2 = row1; row2 < rows; row2++) {
                    for (int column2 = column1; column2 < columns; column2++) {

                        System.out.print("{");

                        for (int row = row1; row <= row2 ; row++) {
                            System.out.print("{");

                            for (int column = column1; column<= column2; column++) {
                                System.out.print(matrix[row][column]);
                                if (column != column2) {
                                    System.out.print(" ");
                                } else {
                                    System.out.println("},");
                                }
                            }
                            /* 
                            if (row != row2) {
                                System.out.print("}, ");
                            }
                                */
                            
                        }

                        /* 
                        if (column2 != columns) {
                            System.out.print("}, ");
                        }
                        */
                    }
                    //System.out.println();
                }
                //System.out.println();
            }
        }
        System.out.println();
    }


    public static void printMatrix(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0; i < length; i++) {
            for (int j=0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
