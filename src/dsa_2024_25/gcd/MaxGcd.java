package dsa_2024_25.gcd;
/*
 * Given an array, delete exactly one element such
 * that GCD of the rest of the array is max.
 * i.e. A = {12, 15, 18, 24, 66}
 * answer: 15, if we delete 15 gcd is 6 else 3
 */
public class MaxGcd {
    public static void main(String[] args) {
        int[] A = {6, 12, 15, 18, 24, 66};
        
        System.out.println("maxGcd1(int[] A): " + maxGcd1(A));
        System.out.println("maxGcd2(int[] A): " + maxGcd1(A));
        System.out.println("maxGcd2(int[] A): " + maxGcd2(new int[] {2, 6, 12, 18}));
        System.out.println("maxGcd2(int[] A): " + maxGcd2(new int [] {6, 12, 18, 2}));
        System.out.println("maxGcd2(int[] A): " + maxGcd2(new int [] {7, 21}));
        
    }

    public static int maxGcd1(int[] A) {
        // Brute Force
        // calculate GCD for a subarray where 
        // one element is excluded
        int[] gcds = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int currGcd = i == 0 ? A[1] : A[0];
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    currGcd = gcd(currGcd, A[j]);
                }
            }
            gcds[i] = currGcd;
        }

        int maxGcd = Integer.MIN_VALUE;
        for (int i = 0 ; i < gcds.length; i++) {
            if (gcds[i] > maxGcd) {
                maxGcd = gcds[i];
            }
        }
        return maxGcd;
    }


    public static int maxGcd2(int[] A) {
        int length = A.length;
        int[] prefixGcd = new int[length];
        int [] sufixGcd = new int[length];

        prefixGcd[0] = A[0];
        for (int i = 1; i < length; i++) {
            prefixGcd[i] = gcd(prefixGcd[i - 1], A[i]);
        }

        sufixGcd[length - 1] = A[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            sufixGcd[i] = gcd(sufixGcd[i + 1], A[i]);
        }

        int maxGcd = sufixGcd[0];

        //check GCD without the first element
        if (sufixGcd[1] > maxGcd) {
            maxGcd = sufixGcd[1];
        }

        // check GCD without the last element
        if (prefixGcd[length - 2] > maxGcd) {
            maxGcd = prefixGcd[length - 2];
        }

        // check rest of the possibilities
        for (int i=1; i < length - 1; i++) {
            int gcdWithoutElement = gcd(prefixGcd[i - 1], sufixGcd[i + 1]);
            if (gcdWithoutElement > maxGcd) {
                maxGcd = gcdWithoutElement;
            }
        }

        return maxGcd;

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
