package searching;

/*
 * Given an N * M matrix, which has sorted rows.
 * Find the median
 * */
public class MatrixMedian {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 8}, {2, 7, 10}, {0, 1, 2}, {1, 10, 20}, {100, 200, 202}};
        int rows = matrix.length;
        int columns = matrix[0].length;
        int totalElements = rows * columns;
        int medianElementNumber = (totalElements + 1) / 2 ;

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int row = 0; row < rows; row++) {
            minVal = Math.min(minVal, matrix[row][0]);
            maxVal = Math.max(maxVal, matrix[row][columns - 1]);
        }

        int ans = findMedian(matrix, medianElementNumber, minVal, maxVal);
        System.out.println(ans);
    }

    public static int findMedian(int[][] matrix, int medianElementNumber, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = numberOfElementsBeforeCandidateMedian(matrix, mid);

            if (count < medianElementNumber) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }

    public static int numberOfElementsBeforeCandidateMedian(int[][] matrix, int candidateMedian) {
        int count = 0;

        for (int row = 0; row < matrix.length; row++) {
            int start = 0;
            int end = matrix[row].length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[row][mid] <= candidateMedian) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            count += start;
        }
        return count;
    }
}
