package revison_oct2025.misc;

import java.util.ArrayList;

public class AllSubArrays {
    public static void main(String[] args) {
        int[] A = {1, 20, 3, 7};
        System.out.println(allSubarrays(A));
    }

    static ArrayList<ArrayList<Integer>> allSubarrays(int[] A) {
        ArrayList<ArrayList<Integer>> allSubarrays = new ArrayList<>();
        for (int size = 1; size <= A.length; size++) {
            for (int i = 0; i <= A.length - size; i++) {
                ArrayList<Integer> currSubarray = new ArrayList<>();
                for (int k = i; k < i + size; k++) {
                    currSubarray.add(A[k]);
                }
                allSubarrays.add(currSubarray);
            }
        }
        return allSubarrays;
    }
}
