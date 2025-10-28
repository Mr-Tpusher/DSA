package revision_oct2025.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class AllSubsetsNonDupes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};

        ArrayList<ArrayList<Integer>> elements = new ArrayList<>();
        Arrays.sort(arr);

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                ArrayList<Integer> element = new ArrayList<>();
                element.add(arr[i - 1]);
                element.add(count);
                elements.add(element);
                count = 1;
            }
        }
        // last element
        ArrayList<Integer> element = new ArrayList<>();
        element.add(arr[arr.length - 1]);
        element.add(count);
        elements.add(element);


        ArrayList<ArrayList<Integer>> allSubsets = generateSets(elements, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println(allSubsets);

    }

    private static ArrayList<ArrayList<Integer>> generateSets(ArrayList<ArrayList<Integer>> elementList,
                                                              int index,
                                                              ArrayList<Integer> subset,
                                                              ArrayList<ArrayList<Integer>> allSubsets) {

        if (index == elementList.size()) {
            allSubsets.add(new ArrayList<>(subset));
            return allSubsets;
        }

        int key = elementList.get(index).get(0);
        int value = elementList.get(index).get(1);


        for (int i = 0; i <= value; i++) {
            ArrayList<Integer> newSs = new ArrayList<>(subset);
            for (int j = 0; j < i; j++) {
                newSs.add(key);
            }
            generateSets(elementList, index + 1, newSs, allSubsets);
        }
        return allSubsets;
    }
}


