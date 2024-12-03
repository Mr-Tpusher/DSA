package dynamic_programming;
/*
* Find the count of N digit numbers, with digit sum = S
* e.g. N = 2, S = 4
*
* */
public class NDigitNumber {
    public static void main(String[] args) {
        int N = 3;
        int S = 4;
        System.out.println(bruteForce(N, S));
    }
    /*
    * consider N = 2
    * N digit numbers 10 to 99 i.e. 10^(N-1) to 10^N - 1
    * total number = (10^N - 1 - 10^(N-1) + 1)
    *              = 10^(N-1) [10 - 1]
    *              = 9 * 10^(N-1)
    *
    *
    * */

    public static int bruteForce(int N, int S) {
        int count = 0;
        for (int i = (int) Math.pow(10, N - 1); i < Math.pow(10, N); i++) {
            int sum = 0;
            int number = i;
            while (number != 0) {
                sum += number % 10;
                number = number / 10;
            }
            if (sum == S) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }
}
