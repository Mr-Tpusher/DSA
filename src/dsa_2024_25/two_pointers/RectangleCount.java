package dsa_2024_25.two_pointers;
/*
* Given a sorted array of distinct integers,
* return count of different configurations of rectangle,
* such that the area of those rectangles <= B
*
* */

import java.util.ArrayList;

public class RectangleCount {
    public static void main(String[] args) {
        int[] A = {2, 3, 5};
        int B = 10;
        System.out.println(bruteForce(A, B));
        System.out.println(rectangleCount(A, B));
    }

    public static int bruteForce(int[] A, int B) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] * A[j] <= B) {
                    count++;
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(A[i]);
                    pair.add(A[j]);
                    output.add(pair);
                }
            }
        }
        System.out.println(output);
        return count;
    }

    public static int rectangleCount(int[] A, int B) {
        int count = 0;
        int left = 0, right = A.length - 1;
        while (left < A.length && right >= 0) {
            int area = A[left] * A[right];
            if (area > B) {
                right--;
            } else {
                count += right + 1;
                left++;
                right--;
            }
        }
        return count;
    }
}
