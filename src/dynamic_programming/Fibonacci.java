package dynamic_programming;
/*
* fibonacci series : 0, 1, 1, 2, 3, 5
*
* */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(fibo1(n));

        int[] fibos = new int[n+1];
        System.out.println(fibo2(n, fibos));


    }

    private static int fibo2(int n, int[] fibos) {
        if (n < 2) return n;

        if (fibos[n] > 0) return fibos[n];

        fibos[n] = fibo2(n - 1, fibos) + fibo2(n - 2, fibos);
        return fibos[n];
    }

    public static int fibo1(int x) {
        if (x < 2) {
            return x;
        }
        return fibo1(x - 1) + fibo1(x - 2);
    }
}
