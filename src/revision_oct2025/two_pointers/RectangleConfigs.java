package revision_oct2025.two_pointers;

import java.util.Arrays;

/*
 * Given a sorted array, return count of different configurations of rectangle,
 * such that the area of those rectangles <= B.
 * arr = {2, 3, 5} , B = 10
 *
 * ans:
 * {2,2} {2,3} {2,5} {3,2} {3,3} {5,2} = 6
 *
 *
 * */
public class RectangleConfigs {
    public static void main(String[] args) {
        test(new int[]{2, 3, 5}, 10, 6);
        test(new int[]{1, 2, 3, 5, 10}, 10, 15);
        test(new int[]{11, 12, 13, 14, 15, 17}, 10, 0);


    }

    static void test(int[] arr, int B, int expected) {
        System.out.println("arr = " + Arrays.toString(arr) + ", B = " + B);
        System.out.println("expected = " + expected);
        // int ans = bruteForce(arr, B);
        int ans = solve(arr, B);
        System.out.println("actual = " + ans);
    }

    static int bruteForce(int[] arr, int B) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] * arr[j] <= B) {
                    count++;
                }
            }
        }
        return count;
    }

    static int solve(int[] arr, int B) {
        int i = 0, j = arr.length - 1, count = 0;

        while (i <= j) {
            int area = arr[i] * arr[j];
            if (area <= B) {
                count = count + (((j - i) * 2) + 1);
                i++;
            } else {
                j--;
            }

        }
        return count;
    }
}
