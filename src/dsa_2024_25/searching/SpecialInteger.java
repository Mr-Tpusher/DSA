package dsa_2024_25.searching;
/*
* Given an array A, and an integer sum, find
* out max size k, where no sub-arrays of size k,
* has a sum greater than k.
* A = {1, 20, 3, 7} , sum = 25
* answer k = 2
*
* */
public class SpecialInteger {
    static int[] prefixSum;
    public static void main(String[] args) {
/*    int[] A = {1, 20, 3, 7};
     int sum = 25;*/

     int[] A = {5,10,20,100,105};
     int sum = 130;
     prefixSum = new int[A.length];
     prefixSum[0] = A[0];
     for (int i = 1; i < A.length; i++) {
        prefixSum[i] = prefixSum[i - 1] + A[i];
     }

     System.out.println(findSpecialInteger(A, sum, 1, A.length));
    }

    public static int findSpecialInteger(int[] A, int sum, int start, int end) {
        if (start > end) {
            return end;
        }
        int mid = start + (end - start) / 2;
        if (isSpecialInteger(A,sum, mid)) {
            return findSpecialInteger(A, sum, mid + 1, end);
        } else {
            return findSpecialInteger(A, sum,start, mid - 1);
        }
    }

    public static boolean isSpecialInteger(int[] A, int k, int mid) {

        if (prefixSum[mid - 1] > k) {
            return false;
        }
        for (int i = 0, j = mid; j < A.length ; i++, j++) {
            if (prefixSum[j] - prefixSum[i] > k) {
                return false;
            }
        }
        return true;
    }
}
