package dsa_2024_25.maths;
/*
 * Find all prime number from 0 to N.
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        int N = 100;

        int[] primes = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            primes[i] = 0;
        }
        primes[0] = primes[1] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 2, k = i * j; k <= N; j++, k= i * j) {
                if (primes[k] != 0) {
                    continue;
                }
                primes[k] = 1;
            }
        }

        System.out.print("The primes between 1 and N are: ");
        for (int i = 2; i <= N; i++) {
            if (primes[i] == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
