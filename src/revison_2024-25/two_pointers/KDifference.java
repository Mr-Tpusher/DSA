package two_pointers;

import java.util.ArrayList;

/*
* Given a sorted array of positive numbers and a number k,
* return all pairs such that,
* A[i] - A[j] = k
*
*
* */
public class KDifference {
    public static void main(String[] args) {
        int[] A = {1, 4, 9, 15, 20, 21, 24, 27};
        int k = 3;
        System.out.println(solve(A, k));
    }

    public static ArrayList<ArrayList<Integer>> solve(int[] A, int k) {
        if (A.length <= 1) {
            return null;
        }
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        int left = 0, right = 1;
        while (right < A.length) {
            int diff = A[right] - A[left];
            if (diff == k) {
                ArrayList<Integer> out = new ArrayList<>();
                out.add(right);
                out.add(left);
                output.add(out);
                left++;
                right++;
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
        }
        return output;
    }
}
