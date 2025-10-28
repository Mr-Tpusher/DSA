package revision_oct2025.matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class AllSubmatrices {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add((new ArrayList<>(Arrays.asList(1, 2, 3))));
        matrix.add((new ArrayList<>(Arrays.asList(4, 5, 6))));
        matrix.add((new ArrayList<>(Arrays.asList(7, 8, 9))));
        matrix.add((new ArrayList<>(Arrays.asList(10, 11, 12))));

        ArrayList<ArrayList<ArrayList<Integer>>> allSubMatrices = getSubMatrices(matrix);

        printAllSubMatrices(allSubMatrices);
    }

    private static void printAllSubMatrices(ArrayList<ArrayList<ArrayList<Integer>>> allSubMatrices) {
        for (ArrayList<ArrayList<Integer>> subMatrix : allSubMatrices) {
            for (ArrayList<Integer> mat : subMatrix) {
                System.out.println(mat);
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<ArrayList<Integer>>> getSubMatrices(ArrayList<ArrayList<Integer>> matrix) {
       int rows = matrix.size();
       int columns = matrix.get(0).size();
       ArrayList<ArrayList<ArrayList<Integer>>> allSubMatrices = new ArrayList<>();

       // fix the first point coordinates
       for (int r1 = 0; r1 < rows; r1++) {
           for (int c1 = 0; c1 < columns; c1++) {
               // fix the second point coordinates
               for (int r2 = r1; r2 < rows; r2++) {
                   for (int c2 = c1; c2 < columns; c2++) {

                       // traverse from first point to the second to get the sub matrix
                       ArrayList<ArrayList<Integer>> currSubMat = new ArrayList<>();
                       for (int i = r1; i <= r2; i++) {
                           ArrayList<Integer> currRowSubMat = new ArrayList<>();
                           for (int j = c1; j <= c2; j++) {
                               currRowSubMat.add(matrix.get(i).get(j));
                               //System.out.println("currRowSubMat: " + currRowSubMat);
                           }
                           currSubMat.add(currRowSubMat);
                           //System.out.println("currSubMat:" + currSubMat);

                       }
                       allSubMatrices.add(currSubMat);
                       //System.out.println("allSubMatrices:" + allSubMatrices);
                   }
               }
           }
       }
       return allSubMatrices;
    }
}
