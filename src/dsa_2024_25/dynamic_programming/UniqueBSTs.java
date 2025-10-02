package dsa_2024_25.dynamic_programming;
/*
* Given N distinct numbers, count the number of BSTs possible.
* N=1   answer=1
* N=2   answer=2
* N=3   answer=5
*
* */
public class UniqueBSTs {
    public static void main(String[] args) {
        int N = 4;
        System.out.println(solve(N));

    }

    public static int solve(int N) {
        int[] count = new int[N + 1];
        count[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - 1 - j];
            }
        }
        return count[N];
    }
}
