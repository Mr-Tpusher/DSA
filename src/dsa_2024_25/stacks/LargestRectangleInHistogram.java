package dsa_2024_25.stacks;

/*
 * Given an array which represents height of blocks, Using these blocks form a rectangle such that
 * area of that rectangle is maximum.
 * int[] A = {6, 2, 5, 4, 5, 1, 6}       answer = 12
 * */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] A = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(bruteForce(A));
        System.out.println(solve(A));
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

    public static int solve(int[] A) {
        int length = A.length;
        int[] nearestSmallerOnLeft = getNearestSmallerOnLeft(A);
        int[] nearestSmallerOnRight = getNearestSmallerOnRight(A);

        int largestRectangle = 0;
        for (int i = 0; i < length; i++) {
            int totalBlocks = nearestSmallerOnRight[i] - nearestSmallerOnLeft[i] - 1;
            int currRectangle = A[i] * totalBlocks;
            largestRectangle = Math.max(largestRectangle, currRectangle);
        }
        return largestRectangle;
    }

    public static int[] getNearestSmallerOnLeft(int[] A) {
        //A = {6, 2, 5, 4, 5, 1, 6};
        int length = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] nearestSmallerOnLeft = new int[length];
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if (stack.isEmpty())
                nearestSmallerOnLeft[i] = -1;
            else
                nearestSmallerOnLeft[i] = stack.peek();
            stack.push(i);
        }
        return nearestSmallerOnLeft;
    }

    public static int[] getNearestSmallerOnRight(int[] A) {
        //A = {6, 2, 5, 4, 5, 1, 6};
        int length = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] nearestSmallerOnRight = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if (stack.isEmpty())
                nearestSmallerOnRight[i] = length;
            else
                nearestSmallerOnRight[i] = stack.peek();
            stack.push(i);
        }
        return nearestSmallerOnRight;
    }
}
