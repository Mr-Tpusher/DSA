package dsa_2024_25.arrays;

import java.util.Arrays;

/*
* 1
* 1 1
* 1 2 1
* 1 3 3 1
* 1 4 6 4 1
* 1 5 10 10 5 1
*
* */
public class PascalTriangle {
    public static void main(String[] args) {
        int A = 6;
        int[][] output = createPascalTriangle(A);
        for (int[] a : output) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] createPascalTriangle(int A) {
        int[][] output = new int[A][];
        for (int row = 0; row < A; row++) {
            output[row] = new int[row + 1];
            for (int element = 0; element <= row; element++) {
                if (element == 0 || element == row) {
                    output[row][element] = 1;
                } else {
                    output[row][element] = output[row - 1][element] +
                            output[row - 1][element - 1];
                }
            }
        }
        return output;
    }
}
