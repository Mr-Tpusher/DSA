package revison_oct2025.two_pointers;
/*
* Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).
* N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
* Find two lines, which together with x-axis forms a container, such that the container contains the most water.
* You need to return this maximum area.
* A = [1, 5, 4, 3]
* output = 6
* */
public class WaterContainer {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 5, 4, 3}));
    }

    static int bruteForce(int[] A) {
        int maxArea = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int area = Math.min(A[i], A[j]) * (j - i);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    static int maxArea(int[] A) {

        int maxArea = 0;

        int left = 0, right = A.length - 1;

        while (left < right) {
            int area = Math.min(A[left], A[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (A[left] <= A[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
