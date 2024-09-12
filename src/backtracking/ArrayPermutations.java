package backtracking;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayPermutations {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        ArrayList<Integer> A1 = Arrays.stream(A).boxed().
                collect(Collectors.toCollection(ArrayList::new));
        //genPermutation(A, 0, new int[A.length], A.length);
        genPermutation2(A1, 0, new ArrayList<>(A.length), A.length);
    }

    public static void genPermutation(int[] A, int index, int[] perm, int N) {

        // Base Condition
        if (index == N) {
            System.out.println(Arrays.toString(perm));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            perm[index] = A[i];

            // Copy input A into temp except the element which is already used
            int[] temp = new int[A.length - 1];
            for (int j = 0, k = 0; j < A.length; j++) {
                if (A[j] != A[i]) {
                    temp[k] = A[j];
                    k++;
                }
            }
            genPermutation(temp, index + 1, perm, N);
        }
    }


    public static void genPermutation2(ArrayList<Integer> A, int index, ArrayList<Integer> perm, int N) {

        if (index == N) {
            System.out.println(perm);
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            perm.add(index, A.get(i));
            ArrayList<Integer> temp = new ArrayList<>(A);
            temp.remove(A.get(i));
            genPermutation2(temp, index + 1, perm, N);
            perm.remove(index);
        }
    }
}
