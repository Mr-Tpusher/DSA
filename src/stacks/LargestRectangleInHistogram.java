package stacks;

/*
 * Given an array which represents height of blocks, Using these blocks form a rectangle such that
 * area of that rectangle is maximum.
 * int[] A = {6, 2, 5, 4, 5, 1, 6}       answer = 12
 * */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] A = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(bruteForce(A));
    }

    public static int bruteForce(int[] A) {
        int length = A.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            int blocks = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] >= A[i]) {
                    blocks++;
                } else {
                    break;
                }
            }
            for (int k = i + 1; k < length; k++) {
                if (A[k] >= A[i]) {
                    blocks++;
                } else {
                    break;
                }
            }
            int currArea = A[i] * blocks;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}
