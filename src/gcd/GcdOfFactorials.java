package gcd;
/*
 * Given an array of elements, find
 * gcd of factorial of all the elements
 * e.g. A = {5, 3, 4, 2}
 * find gcd of:  5!, 3!, 4!, 2!
 */
public class GcdOfFactorials {
    public static void main(String[] args) {
        int[] A = {12, 9, 4, 21};
        /* If you observe closely 
        *  Since we need to consider factorials of all the elements,
        *  Whatever the smallest element is, will be the gcd,
        *  5! = 5 * 4 * 3 * 2 * 1
        *  3! = 3 * 2 * 1
        *  4! = 4 * 3 * 2 * 1
        *  2! = 2 * 1
        * 2! is the gcd.
        */

        // find smallest element
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < smallest) {
                smallest = A[i];
            }
        }

        System.out.println(factorial(smallest));

    }

    public static int factorial(int A) {
        int factorial = 1;
        for(int i = A; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }

}
