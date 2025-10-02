package arrays;
/*
 * Given an array denoting heights of the buildings , return the sum of total Rainwater 
 * that can be trapped above those buildings
 * A = [5, 4, 1, 4, 3, 2, 7] 
 */
public class RainwaterTrapped {

    public static void main(String[] args) {
    
        //int[] buldingHeights = {5, 4, 1, 4, 3, 2, 7};
        int[] buldingHeights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("rainwaterTrapped1(int[] buldingHeights) : " + rainwaterTrapped1(buldingHeights));
        System.out.println("rainwaterTrapped2(int[] buldingHeights) : " + rainwaterTrapped2(buldingHeights));
    }

    public static int rainwaterTrapped1(int[] buldingHeights) {
        
        int length = buldingHeights.length;
        int[] tallestOnLeft = new int[length];
        int[] tallestOnRight = new int[length];

        tallestOnLeft[0] = buldingHeights[0];
        for(int i = 1; i < length; i++) {
            tallestOnLeft[i] = Math.max(tallestOnLeft[i - 1], buldingHeights[i]);
        }

        tallestOnRight[length - 1] = buldingHeights[length - 1];
        for(int i = length - 2; i >= 0; i--) {
            tallestOnRight[i] = Math.max(tallestOnRight[i + 1], buldingHeights[i]);
        }

        int answer = 0;
        for (int i = 0; i < length; i++) {
            answer += Math.min(tallestOnLeft[i], tallestOnRight[i]) - buldingHeights[i];
        }

        return answer;
    }

    public static int rainwaterTrapped2(int[] buldingHeights) {
        
        // Find the tallest building : TB
        // All the Buildings on the left side of TB, have TB as the tallest building on right (tbor)
        // All the Buildings on the right side of TB, have TB as the tallest building on left (tbol)

        int length = buldingHeights.length;

        // Find Tallest Building\
        int tallestBuildingIndex = 0;
        int tallestBuildingHeight = buldingHeights[tallestBuildingIndex];
        for (int i = 1; i < length; i++) {
            if (buldingHeights[i] > tallestBuildingHeight) {
                tallestBuildingIndex = i;
                tallestBuildingHeight = buldingHeights[tallestBuildingIndex];
            }
        }

        int answer = 0;

        int tallestOnLeft = Integer.MIN_VALUE;
        for (int i = 0; i < tallestBuildingIndex; i++) {
            int currentBuildingHeight = buldingHeights[i];
            tallestOnLeft = Math.max(tallestOnLeft, currentBuildingHeight);
            answer += Math.min(tallestOnLeft, tallestBuildingHeight) - currentBuildingHeight;
        }

        int tallestOnRight = Integer.MIN_VALUE;
        for (int i = length - 1; i > tallestBuildingIndex; i--) {
            int currentBuildingHeight = buldingHeights[i];
            tallestOnRight = Math.max(tallestOnRight, currentBuildingHeight);
            answer += Math.min(tallestOnRight, tallestBuildingHeight) - currentBuildingHeight;
        }

        return answer;
    }
}
