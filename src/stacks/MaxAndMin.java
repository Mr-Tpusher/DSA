package stacks;

import java.util.ArrayList;

/*
 * Given an array A, find sum of (MAX - MIN) of each sub array.
 * All elements are distinct.
 * */
public class MaxAndMin {
    public static void main(String[] args) {
        int[] A = {1, 7, 3, 8};
        System.out.println(bruteForce1(A));
        System.out.println(bruteForce2(A));
        System.out.println(bruteForce3(A));
        System.out.println(solve(A));
    }

    public static int bruteForce1(int[] A) {
        // find all subArrays
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                ArrayList<Integer> subArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArray.add(A[k]);
                }
                subArrays.add(subArray);
            }
        }

        int answer = 0;
        for (ArrayList<Integer> a : subArrays) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i : a) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            answer += max - min;
        }
        return answer;
    }

    public static int bruteForce2(int[] A) {
        // find all subArrays
        int length = A.length;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    max = Math.max(max, A[k]);
                    min = Math.min(min, A[k]);
                }
                answer += max - min;
            }
        }
        return answer;
    }

    public static int bruteForce3(int[] A) {
        // A = {1, 7, 3, 8};
        // find all subArrays
        int length = A.length;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < length; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                answer += max - min;
            }
        }
        return answer;
    }


    /*
    * SUM(MAX-MIN) for all subArrays = SUM(MAX) for all subArrays - SUM(MIN) for all subArrays
    * Instead of finding the subArrays, we can just find the contribution of A[i] to max and min
    * contribution of  A[i] for max = A[i] * number of subArrays it is the max element
    * contribution of A[i] for min = A[i] * number of subArrays it is the min element
    * */
    public static int solve(int[] A) {
        //int[] A = {1, 7, 3, 8};
        /* Steps:
        *   1. Calculate JustGreaterOnLeft
        *   2. Calculate JustGreaterOnRight
        *   3. Calculate contribution to max
        *   4. Calculate JustSmallerOnLeft
        *   5. Calculate JustSmallerOnRight
        *   6. Calculate contribution to min
        *   7. Calculate Max - Min
        * */
        int length = A.length;
        final int MOD = 1000000007;
        int[] JGL = getJustGreaterOnLeft(A);
        int[] JGR = getJustGreaterOnRight(A);
        int[] JSL = getJustSmallerOnLeft(A);
        int[] JSR = getJustSmallerOnRight(A);


        long totalMax = 0;
        for (int i = 0; i < length; i++) {
            long currMax = ((long)(A[i] % MOD) * (((long) (i - JGL[i]) * (JGR[i] - i)) % MOD)) % MOD;
            totalMax = (totalMax + currMax) % MOD;
        }

        long totalMin = 0;
        for (int i = 0; i < length; i++) {
            long currMin = ((long)(A[i] % MOD) * (((long) (i - JSL[i]) * (JSR[i] - i)) % MOD)) % MOD;
            totalMin = (totalMin + currMin) % MOD;
        }

        int total = (int) (totalMax - totalMin);
        if (total < 0)
            total += MOD;

        return total;
    }

    public static int[] getJustGreaterOnLeft(int[] A) {
        //int[] A = {1, 7, 3, 8};
        int length = A.length;
        int[] JGL = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int currElement = A[i];
            while (!stack.isEmpty() && A[stack.peek()] <= currElement) {
                stack.pop();
            }
            if (stack.isEmpty())
                JGL[i] = -1;
            else {
                JGL[i] = stack.peek();
            }
            stack.push(i);
        }
        return JGL;
    }

    public static int[] getJustGreaterOnRight(int[] A) {
        //int[] A = {1, 7, 3, 8};
        int length = A.length;
        int[] JGR = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            int currElement = A[i];
            while (!stack.isEmpty() && A[stack.peek()] <= currElement) {
                stack.pop();
            }
            if (stack.isEmpty())
                JGR[i] = length;
            else {
                JGR[i] = stack.peek();
            }
            stack.push(i);
        }
        return JGR;
    }
    public static int[] getJustSmallerOnLeft(int[] A) {
        //int[] A = {1, 7, 3, 8};
        int length = A.length;
        int[] JSL = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int currElement = A[i];
            while (!stack.isEmpty() && A[stack.peek()] >= currElement) {
                stack.pop();
            }
            if (stack.isEmpty())
                JSL[i] = -1;
            else {
                JSL[i] = stack.peek();
            }
            stack.push(i);
        }
        return JSL;
    }

    public static int[] getJustSmallerOnRight(int[] A) {
        //int[] A = {1, 7, 3, 8};
        int length = A.length;
        int[] JSR = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            int currElement = A[i];
            while (!stack.isEmpty() && A[stack.peek()] >= currElement) {
                stack.pop();
            }
            if (stack.isEmpty())
                JSR[i] = length;
            else {
                JSR[i] = stack.peek();
            }
            stack.push(i);
        }
        return JSR;
    }
}
