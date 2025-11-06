package revision_oct2025.dynamic_programming.knapsack;

/*
 * Given N toys, which have happiness value H and weight W, total bag capacity is cap.
 * Find the max happiness.
 * H = {1,3,5,6}
 * W = {2,3,4,5}
 * cap = 7
 *
 * */
public class ToysHappiness {
    public static void main(String[] args) {
        int[] H = {1, 3, 5, 6};
        int[] W = {2, 3, 4, 5};
        int cap = 7;

        System.out.println(bruteForce(H, W, cap));
    }

    static int bruteForce(int[] H, int[] W, int cap) {
        return bruteForceHelper(0, cap, H, W);
    }

    static int bruteForceHelper(int index, int remCap, int[] H, int[] W) {

        if (remCap == 0 || index == H.length) return 0;

        // select current toy
        int selectToy = 0;
        if (W[index] <= remCap) {
            selectToy = H[index] + bruteForceHelper(index + 1, remCap - W[index], H, W);
        }

        // reject current toy
        int rejectToy = bruteForceHelper(index + 1, remCap, H, W);

        return Math.max(selectToy, rejectToy);
    }
}
