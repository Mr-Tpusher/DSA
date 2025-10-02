package dsa_2024_25.two_pointers;

import java.util.ArrayList;

/*
* Given a sorted array with distinct integers and a number k,
* find all pairs of indices int the array where the sum of value
* of these indices is k
*
* */
public class KSum {
    public static void main(String[] args) {
        int [] A = {1, 2, 6, 9, 14, 20, 21};
        int k = 15;
        System.out.println(bruteForce(A, k));
        System.out.println(solve(A, k));
    }

    public static ArrayList<ArrayList<Integer>> solve(int[] A, int k) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        int left = 0, right = A.length - 1;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum == k) {
                ArrayList<Integer> out = new ArrayList<>();
                out.add(left);
                out.add(right);
                output.add(out);
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return output;
    }

        public static ArrayList<ArrayList<Integer>> bruteForce(int[] A, int k) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == k) {
                    ArrayList<Integer> out = new ArrayList<>();
                    out.add(i);
                    out.add(j);
                    output.add(out);
                }
            }
        }
        return output;
    }
}
