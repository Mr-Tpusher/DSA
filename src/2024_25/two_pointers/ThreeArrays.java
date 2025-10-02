package two_pointers;
/*
* Given 3 arrays, find 3 indices such that,
* |Max(a,b,c) - Min(a,b,c)| is minimized.
* return this value
*
* */
public class ThreeArrays {
    public static void main(String[] args) {
        int[] A = {1, 4, 5, 8, 20};
        int[] B = {6, 9, 15};
        int[] C = {2, 3, 6, 6};

        System.out.println(bruteForce(A, B, C));
        System.out.println(solve(A, B, C));
    }

    public static int bruteForce(int[] A, int[] B, int[] C) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    ans = Math.min(ans, Math.abs(
                            Math.max(Math.max(A[i], B[j]), C[k]) -
                                    Math.min(Math.min(A[i], B[j]), C[k])));
                }
            }
        }
        return ans;
    }


    public static int solve(int[] A, int[] B, int[] C) {
        int ans = Integer.MAX_VALUE;
        int a = 0, b = 0, c = 0;
        while (a < A.length && b < B.length && c < C.length) {
            ans = Math.min(ans, Math.abs(
                    Math.max(Math.max(A[a], B[b]), C[c]) -
                            Math.min(Math.min(A[a], B[b]), C[c])));
            if (A[a] <= B[b] && A[a] <= C[c]) {
                a++;
            } else if (B[b] <= A[a] && B[b] <= C[c]) {
                b++;
            } else if (C[c] <= A[a] && C[c] <= B[b]) {
                c++;
            }
        }
        return ans;
    }
}
