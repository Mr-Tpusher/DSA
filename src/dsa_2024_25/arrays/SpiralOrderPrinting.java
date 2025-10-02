package dsa_2024_25.arrays;

public class SpiralOrderPrinting {
    public static void main(String[] args) {
        int[][] A = new int[][]
                {
                        {1,2,3,4},
                        {12,13,14,5},
                        {11,16,15,6},
                        {10,9,8,7}
        };

        printInSpiralOrder(A);
    }

    public static void printInSpiralOrder(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;

        int TR, RC, BR, LC;
        TR = 0;
        RC = columns - 1;
        BR = rows - 1;
        LC = 0;

        while (TR <= BR && LC <= RC) {

            // Print across top row
            for (int i = LC; i <= RC; i++) {
                System.out.print(A[TR][i] + " ");
            }
            TR++;

            // Print across right column
            for (int i = TR; i <= BR; i++) {
                System.out.print(A[i][RC] + " ");
            }
            RC--;

            // Print across Bottom row
            // Check if we still have a bottom row to print
            if (TR <= BR) {
                for (int i = RC; i >= LC; i--) {
                    System.out.print(A[BR][i] + " ");
                }
                BR--;
            }

            // Print across Left Column
            // Check if we still have a left column to print
            if (LC <= RC) {
                for (int i = BR; i >= TR; i--) {
                    System.out.print(A[i][LC] + " ");
                }
                LC++;
            }
        }
    }
}
