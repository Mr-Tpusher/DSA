package dsa_2024_25.matrix;
/*
 * Given a 2-D matrix, Provide the sum of the submatrix 
 * given by (r1,c1) and (r2,c2)
 */
public class SubMatrixSum2 {

    public static void main(String[] args) {
       
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int r1,c1,r2,c2;
        r1 = 1; c1 = 1;
        r2 = 2; c2 = 2;

        int ans = subMatrixSum(A, r1, c1, r2, c2);
        System.out.println("subMatrixSum() : " + ans);
    }

    public static int subMatrixSum(int[][] A, int r1, int c1, int r2, int c2) {
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j<= c2; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }

    
}
