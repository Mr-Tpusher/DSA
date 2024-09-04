package bit_manipulation;
/*
 * In a given array, all numbers occur twice except for one
 * A = {1, 5, 8, 5, 8, 1}
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] A = {1, 5, 3, 8, 5, 8, 1};

        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        
        System.out.println(ans);
    }
}
