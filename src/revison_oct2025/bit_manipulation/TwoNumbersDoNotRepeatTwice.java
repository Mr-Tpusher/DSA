package revison_oct2025.bit_manipulation;

/*
* In an array there are two numbers which do not repeat twice. find them
* */
public class TwoNumbersDoNotRepeatTwice {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,2,5,5};

        // find xor of the whole array
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        // find first set bit of this xor
        int bit = 0;
        for (; bit < 32; bit++) {
            if ((xor & (1 << bit)) != 0) {
                break;
            }
        }

        int xor1, xor2;
        xor1 = xor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & (1 << bit)) != 0) {
                xor1 = xor1 ^ arr[i];
            } else {
                xor2 = xor2 ^ arr[i];
            }
        }
        System.out.println(xor1);
        System.out.println(xor2);

    }
}
