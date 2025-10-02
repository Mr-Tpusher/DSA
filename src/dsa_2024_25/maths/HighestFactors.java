package dsa_2024_25.maths;
/*
 * O to N, given top 5 number with highest number of factors
 */
import java.util.Comparator;
import java.util.*;

public class HighestFactors {
    public static void main(String[] args) {
        
        int N = 10;
        int[] factors = factors(N);

        NumberFactor[] NumberFactor = new NumberFactor[N + 1];
        for (int i = 0; i <= N; i++) {
            NumberFactor[i] = new NumberFactor(i, factors[i]);
        }

        Arrays.sort(NumberFactor, new MyComparator());

        for (int i = 0; i < N; i++) {
            System.out.println(NumberFactor[i].toString());
        }
    }


    public static int[] factors(int N) {
        int[] factors = new int[N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1, k = i * j; k <= N ; j++, k = i * j) {
                factors[k]++;
            }
        }

        for (int i = 0; i <= N ; i++) {
            System.out.println("factors of " + i + " : " + factors[i] + " ");
        }

        return factors;
    }

    
}

 class NumberFactor {
    int number;
    int factors;

    NumberFactor(int number, int factors) {
        this.number = number;
        this.factors = factors;
    }

    @Override
    public String toString() {
        return "NumberFactor [number=" + number + ", factors=" + factors + "]";
    }

    
 }

 class MyComparator implements Comparator<NumberFactor> {

    @Override
    public int compare(NumberFactor nf1, NumberFactor nf2) {
        return Integer.compare(nf2.factors, nf1.factors);
    }
 }
