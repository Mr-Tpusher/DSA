package bit_manipulation;
/*
 * In an array, every element occurs twice,
 * except two
 */
public class TwoNumbers {
    public static void main(String[] args) {
        int[] A = {1, 5, 1, 5, 3, 2, 4, 2};

        //XOR of the array
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor = xor ^ A[i];
        }

        // last set bit of xor
        int bit = -1;
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) > 0) {
                bit = i;
                break;
            }
        }

        int xor1, xor2;
        xor1 = xor2 = 0;

        for (int i = 0; i < A.length; i++) {
            if ((A[i] & (1 << bit)) > 0 ) {
                xor1 = xor1 ^ A[i];
            } else {
                xor2 = xor2 ^ A[i];
            }
        }
        
        System.out.println("numbers:" + xor1 + "," + xor2);
    }
}
