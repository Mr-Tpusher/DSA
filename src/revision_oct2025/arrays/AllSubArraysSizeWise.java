package revision_oct2025.arrays;

import java.util.Arrays;

public class AllSubArraysSizeWise {
    public static void main(String[] args) {
        int[] arr = {3, 7, 11, 19};
        allSubArraysSizeWise(arr);

    }

    public static void allSubArraysSizeWise(int[] arr) {

        int[][] allSubarrays = new int[arr.length * (arr.length + 1) / 2][];

        for (int size = 1, x = 0; size <= arr.length; size++) {
            for (int i = 0; i + size <= arr.length; i++, x++) {
                int[] subArr = new int[size];
                for (int j = i, z = 0; (j < i + size); j++, z++) {
                    subArr[z] = arr[j];
                }
                allSubarrays[x] = subArr;
            }
        }
        System.out.println(Arrays.deepToString(allSubarrays));
    }
}
