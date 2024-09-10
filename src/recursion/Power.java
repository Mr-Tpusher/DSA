package recursion;

public class Power {
    public static void main(String[] args) {
        System.out.println(power1(25,3));
        System.out.println(power2(25,3));
    }

    public static int power1(int A, int B) {
        if (B == 0) {
            return 1;
        }
        int ans = power1(A, B - 1) * A;
        return ans;
    }

    public static int power2(int A, int B) {
        if (B == 0) {
            return 1;
        }
        int exponentBy2 = power2(A, B / 2);
        if ((A & 1) == 0) {
            return exponentBy2 * exponentBy2;
        } else {
            return exponentBy2 * exponentBy2 * A;
        }
    }
}
