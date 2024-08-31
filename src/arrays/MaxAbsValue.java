/*
 * Find the greatest value of the given expression:
 * abs(A[i] - A[j]) + abs(i - j)
 * A = {1, 10, 5, 6, 7, 8}
 * 
 */
package arrays;
public class MaxAbsValue {
    public static void main(String[] args) {
        int[] A = { 1, 10, 5, 6, 7, 8 };

        System.out.println("maxValue1(int[] A) : " + maxValue1(A));
        System.out.println("maxValue2(int[] A) : " + maxValue2(A));
        System.out.println("maxValue3(int[] A) : " + maxValue3(A));
    }

    public static int maxValue1(int[] A) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int value = Math.abs(A[i] - A[j]) + Math.abs(i - j);
                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }

        return maxValue;
    }

    public static int maxValue2(int[] A) {
        int length = A.length;
        int[] elementPlusIndex = new int[length];
        int[] elementMinusIndex = new int[length];

        for (int i = 0; i < length; i++) {
            elementPlusIndex[i] = A[i] + i;
            elementMinusIndex[i] = A[i] + i;
        }

        // elementPlusIndex array
        int elementPlusIndexAnswer = Integer.MIN_VALUE;
        int elementPlusIndexMaxValue = elementPlusIndex[0];
        int elementPlusIndexMinValue = elementPlusIndex[0];

        for (int i = 1; i < length; i++) {
            if (elementPlusIndex[i] > elementPlusIndexMaxValue) {
                elementPlusIndexMaxValue = elementPlusIndex[i];
            }
            if (elementPlusIndex[i] < elementPlusIndexMinValue) {
                elementPlusIndexMinValue = elementPlusIndex[i];
            }
            elementPlusIndexAnswer = Math.max(elementPlusIndexAnswer,
                    (elementPlusIndexMaxValue - elementPlusIndexMinValue));
        }

        // elementMinusIndex array
        int elementMinusIndexAnswer = Integer.MIN_VALUE;
        int elementMinusIndexMaxValue = elementMinusIndex[0];
        int elementMinusIndexMinValue = elementMinusIndex[0];

        for (int i = 1; i < length; i++) {
            if (elementMinusIndex[i] > elementMinusIndexMaxValue) {
                elementMinusIndexMaxValue = elementMinusIndex[i];
            }
            if (elementMinusIndex[i] < elementMinusIndexMinValue) {
                elementMinusIndexMinValue = elementMinusIndex[i];
            }
            elementMinusIndexAnswer = Math.max(elementMinusIndexAnswer,
                    (elementMinusIndexMaxValue - elementMinusIndexMinValue));
        }

        return Math.max(elementPlusIndexAnswer, elementMinusIndexAnswer);

    }

    public static int maxValue3(int[] A) {

        int elementPlusIndexMax = Integer.MIN_VALUE;
        int elementPlusIndexMin = Integer.MAX_VALUE;
        int elementMinusIndexMax = Integer.MIN_VALUE;
        int elementMinusIndexMin = Integer.MAX_VALUE;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            int element = A[i];
            int elementPlusIndex = element + i;
            int elementMinusIndex = element - i;

            if (elementPlusIndex > elementPlusIndexMax) {
                elementPlusIndexMax = elementPlusIndex;
            }
            if (elementPlusIndex < elementPlusIndexMin) {
                elementPlusIndexMin = elementPlusIndex;
            }

            if (elementMinusIndex > elementMinusIndexMax) {
                elementMinusIndexMax = elementMinusIndex;
            }
            if (elementMinusIndex < elementMinusIndexMin) {
                elementMinusIndexMin = elementMinusIndex;
            }

        }

        int currentMax = Math.max((elementMinusIndexMax - elementMinusIndexMin),
                (elementPlusIndexMax - elementPlusIndexMin));
        answer = Math.max(answer, currentMax);

        return answer;
    }
}
