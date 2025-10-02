package backtracking;

import java.util.ArrayList;

/*
 * Find Subsets for a given array.
 * We cannot have the same subset twice
 * */
public class Subsets2 {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3};

        // First convert the array in terms of element value and frequency
        ArrayList<ValueAndFrequency> vfList = ValueAndFrequency.generateValueFrequency(A);
        System.out.println(vfList);

        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        generate(vfList, 0, new ArrayList<>(), allSubsets);
        System.out.println(allSubsets);
    }

    public static void generate(ArrayList<ValueAndFrequency> vfList, int index, ArrayList<Integer> currentSubset, ArrayList<ArrayList<Integer>> allSubsets) {

        if (index == vfList.size()) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        ValueAndFrequency vf = vfList.get(index);
        int value = vf.getValue();
        int frequency = vf.getFrequency();

        // Explore all possibilities for the current index
        for (int i = 0; i <= frequency; i++) {
            ArrayList<Integer> newSubset = new ArrayList<>(currentSubset);
            for (int j = 0; j < i; j++) {
                newSubset.add(value);
            }
            generate(vfList, index + 1, newSubset, allSubsets);
        }

/*----------------------------------------------------------------------------------------
        // Explore all possibilities for the current index
        for (int i =0; i <= frequency; i++) {
            generate(vfList, index + 1, currentSubset, allSubsets);
            currentSubset.add(value);
        }

        // Backtrack: remove the elements added for the current index
        for (int i = 0; i <= frequency; i++) {
            currentSubset.remove(currentSubset.size() - 1);
        }

 ---------------------------------------------------------------------------------------*/
    }
}

class ValueAndFrequency {

    int value;
    int frequency;

    public ValueAndFrequency(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public static ArrayList<ValueAndFrequency> generateValueFrequency(int[] A) {

        ArrayList<ValueAndFrequency> vfList = new ArrayList<>();

        if (A.length == 0) {
            return vfList;
        }

        int prev = A[0];
        int freq = 1;
        for (int i = 1; i < A.length; i++) {
            int curr = A[i];
            if (curr == prev) {
                freq++;
            } else {
                ValueAndFrequency valueAndFrequency = new ValueAndFrequency(prev, freq);
                vfList.add(valueAndFrequency);
                prev = curr;
                freq = 1;
            }
        }
        ValueAndFrequency valueAndFrequency = new ValueAndFrequency(prev, freq);
        vfList.add(valueAndFrequency);

        return vfList;
    }


    @Override
    public String toString() {
        return "ValueAndFrequency{" + "value=" + value + ", frequency=" + frequency + '}';
    }
}
