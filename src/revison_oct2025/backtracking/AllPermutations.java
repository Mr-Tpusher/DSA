package revison_oct2025.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(List.of(1, 2, 3, 4));
        genPerm(al, new ArrayList<>());
    }

    static void genPerm(ArrayList<Integer> candidates, ArrayList<Integer> perm) {
        if (candidates.isEmpty()) {
            System.out.println(perm);
            return;
        }

        // iterating over the candidates
        for (int i = 0; i < candidates.size(); i++) {
            // add current candidate into the permutation
            perm.add(candidates.get(i));

            // remove current candidate before recursively generating permutations with rest of the candidates
            int removed = candidates.remove(i);
            genPerm(candidates, perm);

            // since this permutation must have been
            perm.remove(perm.size() - 1);
            candidates.add(i, removed);
        }
    }
}
