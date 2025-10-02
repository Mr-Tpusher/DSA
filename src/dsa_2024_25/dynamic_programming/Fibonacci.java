package dsa_2024_25.dynamic_programming;
/*
* fibonacci series : 0, 1, 1, 2, 3, 5
*
* */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 20;

        System.out.println(fibo1(n));
        System.out.println(fibo2(n, new int[n+1]));

        System.out.println("bottomUp1:" + bottomUpFibo1(n));
        System.out.println("bottomUp2:" + bottomUpFibo2(n));


    }

    // A typical recursive top-down approach
    // with TC: O(2^N) and SC:O(2^N)
    public static int fibo1(int x) {
        if (x < 2) {
            return x;
        }
        return fibo1(x - 1) + fibo1(x - 2);
    }

    // Top-down with memoization
    // TC: O(N) and SC:O(N)
    private static int fibo2(int n, int[] fibos) {
        if (n < 2) return n;

        if (fibos[n] > 0) return fibos[n];

        fibos[n] = fibo2(n - 1, fibos) + fibo2(n - 2, fibos);
        return fibos[n];
    }


    // Bottom-up approach with TC:O(N) and SC:O(N)
    public static int bottomUpFibo1(int n) {
        int[] output = new int[n + 1];
        output[0] = 0;
        output[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (output[i] != 0) {
                return output[i];
            }
            output[i] = output[i - 1] + output[i - 2];
        }
        return output[n];
    }

    // Bottom-up without any extra space
    public static int bottomUpFibo2(int n) {
        int first = 0, second = 1;
        for (int i = 2; i <= n; i++) {
            int curr = first + second;
            first = second;
            second = curr;
        }
        return second;
    }
}
