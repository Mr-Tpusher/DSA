package two_pointers;
/*
* Given a sorted array where A[i] represents the height of the bar at ith position,
* find out max area possible between any two bars.
* */
public class RainWaterDripping {
    public static void main(String[] args) {
        int[] A = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(bruteForce(A));
        System.out.println(maxArea(A));
    }
    public static int bruteForce(int[] A) {
        int maxArea = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int rectangleHeight = Math.min(A[i], A[j]);
                int rectangleWidth = j - i;
                maxArea = Math.max(maxArea, rectangleHeight * rectangleWidth);
            }
        }
        return maxArea;
    }

    public static int maxArea(int[] A) {
        int start = 0, end = A.length - 1;
        int maxArea = 0;
        while (start < end) {
            int rectangleHeight = Math.min(A[start], A[end]);
            int rectangleWidth = end - start;
            maxArea = Math.max(maxArea, rectangleHeight * rectangleWidth);
            if (A[start] <= A[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
