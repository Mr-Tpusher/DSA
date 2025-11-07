package revision_oct2025.dynamic_programming.knapsack;

import java.util.Arrays;

/*
* Find out the max happiness that can be obtained for cap = 8, where each item can be chosen any number of times.
* H = {2, 3, 5}
* W = {3, 4, 7}
* cap = 8
*
* */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] H = {2, 3, 5};
        int[] W = {3, 4, 7};
        int cap = 8;

        maxHappinessBF(H, W, cap);
        topDownDPBinary(H, W, cap);
        topDownDPLoop(H, W, cap);

    }

    static void maxHappinessBF(int[] H, int[] W, int cap) {
        System.out.println(bruteForceHelper1(H, W, 0, cap));
        System.out.println(bruteForceHelper2(H, W,  cap));
    }

    static void topDownDPBinary(int[] H, int[] W, int cap) {
        int n = H.length;
        int[][] dp = new int[n + 1][cap + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(topDownDPBinaryHelper(H, W, cap, 0, dp));
    }

    static void topDownDPLoop(int[] H, int[] W, int cap) {
        int[] dp = new int[cap + 1];
        Arrays.fill(dp, -1);
        System.out.println(topDownDPLoopHelper(H, W, cap, dp));
    }


    static int topDownDPBinaryHelper(int[] H, int[] W, int cap, int index, int[][] dp) {
        if (index == H.length || cap == 0) return 0;

        if (dp[index][cap] != -1) return dp[index][cap];

        int select = 0;
        if (W[index] <= cap)
            select = H[index] + topDownDPBinaryHelper(H, W, cap - W[index], index, dp);

        int reject = topDownDPBinaryHelper(H, W, cap, index + 1, dp);

        return dp[index][cap] = Math.max(select, reject);
    }


    static int topDownDPLoopHelper(int[] H, int[] W, int cap, int[] dp) {
        if (cap == 0) return 0;

        if (dp[cap] != -1) return dp[cap];


        for (int i = 0; i < H.length; i++) {
            if (W[i] <= cap) {
                int happiness = H[i] + topDownDPLoopHelper(H, W, cap - W[i], dp);
                dp[cap] = Math.max(dp[cap], happiness);
            }
        }

        return dp[cap];
    }

    static int bruteForceHelper1(int[] H, int[] W, int index, int remCap) {
        if (index == H.length || remCap == 0)
            return 0;

        int select = 0;
        if (W[index] <= remCap) {
            select = H[index] + bruteForceHelper1(H, W, index, remCap - W[index]);
        }

        int reject = bruteForceHelper1(H, W, index + 1, remCap);

        return Math.max(select, reject);
    }

    static int bruteForceHelper2(int[] H, int[] W, int remCap) {
        if (remCap == 0) return 0;

        // iterate over all the options and get maxHappiness
        int maxHappiness = 0;

        for (int i = 0; i < W.length; i++) {
            // select an item if it fits
            if (W[i] <= remCap) {
                int happiness = H[i] + bruteForceHelper2(H, W, remCap - W[i]);
                maxHappiness = Math.max(maxHappiness, happiness);
            }

            // no need to handle the rejection case specifically because the above loop itself tries all options one by one.
            // which means it automatically rejects.
        }

        return maxHappiness;
    }

}
