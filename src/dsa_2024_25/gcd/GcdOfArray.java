package dsa_2024_25.gcd;
public class GcdOfArray {
    public static void main(String[] args) {
        int[] A = {4,4, 12, 16, 8};
        System.out.println(gcd(A));
    }
    
    public static int gcd(int[] A) {
        int gcd = A[0];
        for (int i=1; i < A.length; i++) {
            gcd = gcd(gcd, A[i]);
        }
        return gcd;
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            //swap
            int temp = a;
            a = b;
            b = temp;
        }
        if (b == 0) {
            return a;
        }
        while (b > 0) {
            a = a % b;

            //swap
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
