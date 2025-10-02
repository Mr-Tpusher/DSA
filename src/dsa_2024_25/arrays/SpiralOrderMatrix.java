package dsa_2024_25.arrays;

import java.util.Arrays;

/*
* For given integer A, return a matrix A*A, having 1 to A^2 elements in the
* spiral order.
* */
public class SpiralOrderMatrix {
    public static void main(String[] args) {
        int[][] output = createSpiralOrderMatrix(4);
        for (int[] i : output) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static int[][] createSpiralOrderMatrix(int A) {
        int[][] output = new int[A][A];

        int TR, RC, BR, LC;
        TR = 0;
        RC = A - 1;
        BR = A - 1;
        LC = 0;
        int curr = 1;
        while (TR <= BR && LC <= RC) {

            // Print across top row
            for (int i = LC; i <= RC; i++) {
                output[TR][i] = curr++;
            }
            TR++;

            // Print across right column
            for (int i = TR; i <= BR; i++) {
                output[i][RC] = curr++;
            }
            RC--;

            // Print across Bottom row
            // Check if we still have a bottom row to print
            if (TR <= BR) {
                for (int i = RC; i >= LC; i--) {
                    output[BR][i] = curr++;
                }
                BR--;
            }

            // Print across Left Column
            // Check if we still have a left column to print
            if (LC <= RC) {
                for (int i = BR; i >= TR; i--) {
                    output[i][LC] = curr++;
                }
                LC++;
            }
        }
        return output;
    }
}

