package backtracking;
/*
* Given an array, which might contain duplicates,
* find all permutations
* */

import util.ValueFrequency;
import java.util.ArrayList;

public class ArrayPermutations2 {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3};

        ArrayList<ValueFrequency> vf = ValueFrequency.generateValueFrequency(A);

        genPermutations(vf, 0, new ArrayList<>(), A.length);

    }

    public static void genPermutations(ArrayList<ValueFrequency> vf, int index,
                                       ArrayList<Integer> perm, int N) {

        if (index == N) {
            System.out.println(perm);
            return;
        }

        for (int i = 0; i < vf.size(); i++) {

            ValueFrequency element = vf.get(i);
            int value = element.getValue();
            int freq = element.getFrequency();

            if (freq == 0) {
                continue;
            }

            perm.add(index, value);
            element.setFrequency(--freq);

            genPermutations(vf, index + 1, perm, N);

            //Backtrack
            element.setFrequency(++freq);
            perm.remove(index);

        }

    }
}


