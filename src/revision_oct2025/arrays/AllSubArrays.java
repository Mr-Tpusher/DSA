package revision_oct2025.arrays;

import java.util.Arrays;

public class AllSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 20, 3, 7};
        allSubArrays(arr);

    }

    public static void allSubArrays(int[] arr) {
        int[][] allSubArrays = new int[arr.length * (arr.length + 1) / 2][];
        for (int i = 0, x = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++, x++) {
                int[] subArr = new int[j - i + 1];
                for (int k = i, z = 0; k <= j; k++, z++) {
                    subArr[z] = arr[k];
                }
                allSubArrays[x] = subArr;
            }
        }

        System.out.println(Arrays.deepToString(allSubArrays));
    }


}
