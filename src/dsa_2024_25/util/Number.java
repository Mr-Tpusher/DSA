package dsa_2024_25.util;

public class Number {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static int factorial(int N) {
        int fact = 1;
        for (int i = N; i > 0; i--) {
            fact *= i;
        }
        return fact;
    }
}
