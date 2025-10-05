package revison_oct2025.arrays;

import java.util.ArrayList;

public class AllSubSets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            int numberOfCurrSubsets = allSubsets.size();
            for (int j = 0; j < numberOfCurrSubsets; j++) {
                ArrayList<Integer> newSubset = new ArrayList<>(allSubsets.get(j));
                newSubset.add(arr[i]);
                allSubsets.add(newSubset);
            }
        }

        System.out.println(allSubsets);
    }
}
