package dsa_2024_25.arrays;

/*
 * Given an array, calculate sum of the elements from A[i] till A[j]
 * provided i and j
 * A = {1, 6, 9, 17, 26, 36, 48};
 * 
 */
public class SubArraySum {
    public static void main(String[] args) {
        int[] A = {1, 5, 3, 8, 9, 10, 12};
        int i = 2;
        int j = 5;
        System.out.println("subArraySum(int[] A) : " + subArraySum(A , i, j));


    }

    public static int subArraySum (int[] A, int a, int b) {
        int[] prefixSum = new int[A.length];

        prefixSum[0] = A[0];
        for (int i = 1 ; i < A.length; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i];
        }


        return prefixSum[b] - prefixSum[a-1];
    }
    
}
