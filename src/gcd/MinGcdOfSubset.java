package gcd;

public class MinGcdOfSubset {

    public static void main(String[] args) {

        int[] A = {3, 6, 12, 18};

        int gcd = A[0];
        for (int i = 1; i < A.length; i++) {
            gcd = gcd(gcd, A[i]);
        }
        System.out.println(gcd);
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            //swap
            int temp = a;
            a = b;
            b = temp;
        }

        if (b  == 0) {
            return a;
        }

        while (b > 0) {
            a = a % b;

            // swap
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
