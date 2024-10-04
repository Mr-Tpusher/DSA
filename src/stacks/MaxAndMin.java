package stacks;

import java.util.ArrayList;

/*
 * Given an array A, find sum of (MAX - MIN) of each sub array.
 * All elements are distinct.
 * */
public class MaxAndMin {
    public static void main(String[] args) {
        int[] A = {1, 7, 3, 8};
        System.out.println(bruteForce1(A));
        System.out.println(bruteForce2(A));
        System.out.println(bruteForce3(A));
    }

    public static int bruteForce1(int[] A) {
        // find all subArrays
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                ArrayList<Integer> subArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArray.add(A[k]);
                }
                subArrays.add(subArray);
            }
        }

        int answer = 0;
        for (ArrayList<Integer> a : subArrays) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i : a) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            answer += max - min;
        }
        return answer;
    }

    public static int bruteForce2(int[] A) {
        // find all subArrays
        int length = A.length;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    max = Math.max(max, A[k]);
                    min = Math.min(min, A[k]);
                }
                answer += max - min;
            }
        }
        return answer;
    }

    public static int bruteForce3(int[] A) {
        // A = {1, 7, 3, 8};
        // find all subArrays
        int length = A.length;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < length; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                answer += max - min;
            }
        }
        return answer;
    }


}
