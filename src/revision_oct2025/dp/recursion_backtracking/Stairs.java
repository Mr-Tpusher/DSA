package revision_oct2025.dp.recursion_backtracking;

import java.util.ArrayList;

/*
* Given N stairs, in one step, you can climb either one stair or two stairs.
* Find all the paths to reach the Nth stair.
*
* */
public class Stairs {
    public static void main(String[] args) {
        climbingUpPaths(4);
        climbingDownPaths(4);

    }

    static void climbingUpPaths(int totalSteps) {
        ArrayList<ArrayList<Integer>> allWays = new ArrayList<>();
        climbingUpHelper(totalSteps, 0, new ArrayList<>(), allWays);
        System.out.println("All paths for climbing up " + totalSteps + " steps : \n" + allWays);
        System.out.println();
    }


    static void climbingDownPaths(int totalSteps) {
        ArrayList<ArrayList<Integer>> allWays = new ArrayList<>();
        climbingDownHelper(totalSteps, new ArrayList<>(), allWays);
        System.out.println("All paths for climbing down " + totalSteps + " steps : \n" + allWays);
        System.out.println();

        ArrayList<ArrayList<Integer>> stepsTaken = new ArrayList<>();
        climbingDownStepsTaken(totalSteps, new ArrayList<>(), stepsTaken);
        System.out.println("All steps taken for each path : \n" + stepsTaken);
        System.out.println();
    }

    private static void climbingUpHelper(int totalSteps, int currStep, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> allPaths) {
        if (currStep > totalSteps) return;

        path.add(currStep);

        if (currStep == totalSteps) {
            allPaths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        // take 1 step
        climbingUpHelper(totalSteps, currStep + 1, path, allPaths);

        // take 2 steps
        climbingUpHelper(totalSteps, currStep + 2, path, allPaths);

        // backtrack
        path.remove(path.size() - 1);
    }


    public static void climbingDownHelper(int N, ArrayList<Integer> currWay, ArrayList<ArrayList<Integer>> allWays) {
        if (N < 0) return;

        currWay.add(N);

        if (N == 0) {
            allWays.add(new ArrayList<>(currWay));
            currWay.remove(currWay.size() - 1);
            return;
        }

        climbingDownHelper(N - 1, currWay, allWays);


        climbingDownHelper(N - 2, currWay, allWays);
        currWay.remove(currWay.size() - 1);

    }

    public static void climbingDownStepsTaken(int N, ArrayList<Integer> currWay, ArrayList<ArrayList<Integer>> allWays) {
        if (N < 0) return;

        if (N == 0) {
            allWays.add(new ArrayList<>(currWay));
            return;
        }

        // climb one step
        currWay.add(1);
        climbingDownStepsTaken(N - 1, currWay, allWays);
        currWay.remove(currWay.size() - 1);

        // climb two steps
        currWay.add(2);
        climbingDownStepsTaken(N - 2, currWay, allWays);
        currWay.remove(currWay.size() - 1);

    }



}
