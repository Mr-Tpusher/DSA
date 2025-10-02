package dsa_2024_25.bit_manipulation;
/*
 * In an array, every number occurs thrice except one.
 */
public class SingleNumber2 {
    public static void main(String[] args) {

        int[] A = {1, 3, 8, 1, 8, 1, 8, 3, 3, 100};

        int ans = 0;
        for (int bit = 0 ; bit < 32; bit++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if ( (A[j] & (1 << bit)) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans += (1 << bit);
            }
        }
        System.out.println(ans);
    }
}
