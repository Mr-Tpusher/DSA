package dynamic_programming;

/*
 * Given N toys, which have happiness value H and weight W, total bag capacity C.
 * Find the max Happiness.
 *
 * */
public class ToyStore {
    public static void main(String[] args) {
        int[] H = {1, 3, 5, 6};
        int[] W = {2, 3, 4, 5};
        int C = 7;

        System.out.println(bruteForce(H, W, 0, C));


    }

    public static int bruteForce(int[] H, int[] W, int index, int remainingCap) {
        if (remainingCap < 0 || index >= W.length) {
            return 0;
        }

        // select the element
        int selected = 0;
        if (W[index] <= remainingCap) {
            selected = H[index] + bruteForce(H, W, index + 1, remainingCap - W[index]);
        }

        // reject the element
        int rejected = bruteForce(H, W, index + 1, remainingCap);

        return Math.max(selected, rejected);
    }
}
