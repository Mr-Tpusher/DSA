package dsa_2024_25.bit_manipulation;

public class BinaryConverter {
    public static void main(String[] args) {

        toBinary(0);
        toBinary(10);
        toBinary(58);
        
    }

    public static byte[] toBinary(int N) {
        byte[] binary = new byte[32];

        for (int i=0; i < 32; i++) {
            if ((N & (1 << i)) >= 1) {
                binary[31 - i] = 1;
            } else {
                binary[31 - i] = 0;
            }
        }

        System.out.print( N + ":");
        for(int i = 0; i < 32; i++) {
            System.out.print(binary[i]);
        }
        System.out.println();

        return binary;
    }
}
