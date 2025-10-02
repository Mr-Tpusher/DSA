package dsa_2024_25.gcd;

import java.util.ArrayList;

/*
 * Provided 2 elements, find their gcd
 */
public class GCD {
    public static void main(String[] args) {
        int A, B;
        A = 961748927;
        B = 756065179;
        //System.out.println("gcdUsingSieve(int A, int B) : " + gcdUsingSieve(A, B) );
        //System.out.println("gcdUsing2Pointers(int A, int B) : " + gcdUsing2Pointers(A, B));
        //System.out.println("gcdUsingFactors(int A, int B) : " + gcdUsingFactors(A, B));
        //System.out.println("gcdUsingRoot(int A, int B) : " + gcdUsingRoot(36, 480));
        //System.out.println("gcdUsingRoot(int A, int B) : " + gcdUsingRoot(A, B));        System.out.println("gcdUsingRoot(int A, int B) : " + gcdUsingRoot(36, 480));
        System.out.println("gcd(int A, int B) : " + gcd(36, 480));
        System.out.println("gcd(int A, int B) : " + gcd(A, B));
    }
    
    public static int gcdUsingSieve(int A, int B) {
        if (A == 0 || B == 0) {
            return  A == 0 ? B : A;
        }
        int[] factorsOfA = new int[A + 1];
        int[] factorsOfB = new int[B + 1];

        for (int i=1; i <= A; i++) {
            if (A % i == 0) {
                factorsOfA[i] = 1;
            } else {
                factorsOfA[i] = 0;
            }
        }

        for (int j = 1; j <= B; j++) {
            if (B % j == 0) {
                factorsOfB[j] = 1;
            } else {
                factorsOfB[j] = 0;
            }
        }

        int gcd = 0;
        for (int i = 1 ; i <= A && i <= B; i++) {
            if (factorsOfA[i] == 1 && factorsOfB[i] == 1) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int gcdUsing2Pointers(int A, int B) {

        if (A == 0 || B == 0) {
            return  A == 0 ? B : A;
        }

        ArrayList<Integer> AFacotrs = new ArrayList<>();
        ArrayList<Integer> BFactors = new ArrayList<>();

        for (int i = 1; i <= A; i++) {
            if (A % i == 0) {
                AFacotrs.add(i);
            }
        }

        for (int i  = 1; i <= B; i++) {
            if (B % i == 0) {
                BFactors.add(i);
            }
        }

        int gcd = 0;
        int a, b;
        a = b = 0;

        while (a < AFacotrs.size() && b < BFactors.size()) {
            int af = AFacotrs.get(a);
            int bf = BFactors.get(b);

            if (af == bf) {
                gcd = af;
                a++;
                b++;
            } else if (af < bf) {
                a++;
            } else {
                b++;
            }
        }
        return gcd;
    }

    public static int gcdUsingFactors(int A, int B) {
        if (A == 0 || B == 0) {
            return  A == 0 ? B : A;
        }

        int smaller = (A < B ? A : B);
        int gcd = 1;
        for(int i = 1; i <= smaller; i++) {
            if (A % i == 0 && B % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int gcdUsingRoot(int A, int B) {
        if (A == 0 || B == 0) {
            return  A == 0 ? B : A;
        }

        int smaller = (A < B ? A : B);
        int larger = (A == smaller ? B : A);
        int gcd = 1;
        for(int factor1 = 1; factor1 <= Math.sqrt(smaller); factor1++) {
            if (smaller % factor1 == 0) {
                int factor2 = smaller/factor1;

                if (larger % factor1 == 0) {
                    gcd = Math.max(gcd, factor1);
                }
                if (larger % factor2 == 0) {
                    gcd = Math.max(gcd, factor2);
                    
                }
            }
        }
        return gcd;
    }

    public static int gcd(int a, int b) {

        if (a < b) {
            // swap
            int temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) {
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
