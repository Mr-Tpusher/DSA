package dsa_2024_25.recursion;
/*
* Find nth Fibonacci number
* 0, 1, 1, 2, 3, 5, 8, 13
* */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibo(8));
    }

    public static int fibo(int N) {

        if (N == 1) {
            return 0;
        }
        if (N == 2) {
            return 1;
        }
        int ans = fibo(N - 1) + fibo(N - 2);
        return ans;
    }

}
