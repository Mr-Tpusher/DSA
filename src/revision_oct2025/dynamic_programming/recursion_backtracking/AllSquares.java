package revision_oct2025.dynamic_programming.recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Given a number N, find all possible combinations of perfect squares that sum to N.
* N = 6
* { {1,1,1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1} }
* */
public class AllSquares {
    public static void main(String[] args) {
        //allSquareCombinations(10);
        allUniqueSquareCombinations(10);
    }

    static void allSquareCombinations(int N) {
        ArrayList<ArrayList<Integer>> allSquares = new ArrayList<>();
        allSquaresHelper(N, new ArrayList<>(), allSquares);
        System.out.println(allSquares);
    }

    static void allUniqueSquareCombinations(int N) {
        ArrayList<ArrayList<Integer>> allSquares = new ArrayList<>();
        uniqueSquaresHelper(N, 1, new ArrayList<>(), allSquares);
        System.out.println(allSquares);
    }

    static void allSquaresHelper(int N, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> all) {
        if (N < 0) return;

        if (N == 0) {
            all.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 1; i <= Math.sqrt(N); i++) {
            if ( (N - i * i) >= 0) {
                curr.add(i);
                allSquaresHelper(N - i * i , curr, all);
                curr.remove(curr.size() - 1);
            }
        }
    }

    static void uniqueSquaresHelper(int N, int start, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> all) {
        if (N < 0) return;

        if (N == 0) {
            all.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i * i <= N; i++) {
            if ((N - i * i) >= 0) {
                curr.add(i);
                uniqueSquaresHelper(N - i * i, i, curr, all);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
