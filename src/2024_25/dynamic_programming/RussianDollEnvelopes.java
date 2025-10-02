package dynamic_programming;

import java.util.*;

/*
Given a matrix of integers A of size N x 2 describing dimensions of N envelopes,
where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width
of the ith envelope.
One envelope can fit into another if and only if both the width and height of
one envelope is greater than the width and height of the other envelope.
Find the maximum number of envelopes you can put one inside other.

e.g. { {5,4}, {6,4}, {6,7}, {2,3} }
solution : {2,3} ---> {5,4} ---> {6,7}      Answer=3
* */
public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopesArray = { {5,4}, {6,4}, {6,7}, {2,3} };
        ArrayList<Envelope> envelopes = Envelope.getEnvelopes(envelopesArray);
        envelopes.sort(Envelope.HEIGHT_FIRST_COMPARATOR);

        System.out.println(envelopes);

        System.out.println(bruteForce(envelopes));

        System.out.println(dpSolve(envelopes));

    }

    // The idea here is to sort the envelopes based on their height, and then iterate
    // over each one by one checking if previous height and width was lesser.
    // we are essentially choosing the elements greedily
    public static int bruteForce(ArrayList<Envelope> envelopes) {
        // This brute force won't work since we are greedily choosing the next envelope.
        // It might very well happen that next envelope is not the best choice
        int count = 1;
        Envelope prev = envelopes.get(0);
        for (int i = 1; i < envelopes.size(); i++) {
            Envelope curr = envelopes.get(i);
            if (prev.height < curr.height && prev.width < curr.width) {
                count++;
                prev = curr;
            }
        }
        return count;
    }


// using dp - idea is simple
// 1. sort based on height inc then width dec
// 2. find LIS of width - if height is equal then skip, because largest
    public static int dpSolve(ArrayList<Envelope> envelopes) {
        int[] dp = new int[envelopes.size() + 1];
        // every element itself is LIS of size 1
        Arrays.fill(dp, 1);

        for (int i = 0; i < envelopes.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes.get(i).width > envelopes.get(j).width) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}


class Envelope {
    int height;
    int width;
    public Envelope(int height, int width) {
        this.height = height;
        this.width = width;
    }

    static ArrayList<Envelope> getEnvelopes(int[][] envelopesArray) {
        ArrayList<Envelope> envelopes = new ArrayList<>();
        for (int[] arr : envelopesArray) {
            envelopes.add(new Envelope(arr[0], arr[1]));
        }
        return envelopes;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    public static final Comparator<Envelope> HEIGHT_FIRST_COMPARATOR = new Comparator<Envelope>() {
        @Override
        public int compare(Envelope e1, Envelope e2) {
            if (e1.height != e2.height) {
                return Integer.compare(e1.height, e2.height);
            } else {
                return Integer.compare(e2.width, e1.width);
            }
        }
    };
}
