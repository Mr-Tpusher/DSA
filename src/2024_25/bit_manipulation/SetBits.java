package bit_manipulation;
/*
 * Given a number, count the number of set bits
 */
public class SetBits {
    public static void main(String[] args) {

        int N = 8;
        System.out.println(setBitCount1(8));
        System.out.println(setBitCount2(4));
        System.out.println(setBitCount3(7));
        System.out.println(setBitCount4(10));


        
    }

    public static int setBitCount1(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }

    public static int setBitCount2(int number) {

        int count = 0;
        for(int i = 0; i < 32; i++) {
            if (((number >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

 
    public static int setBitCount3(int number) {

        int count = 0;
        for(int i = 0; i < 32; i++) {
            if ((number & (1 << i)) >= 1) {
                count++;
            }
        }
        return count;
    }

 
    public static int setBitCount4(int number) {

        int count = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

}
