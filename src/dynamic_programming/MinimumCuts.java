package dynamic_programming;

import java.util.ArrayList;

/*
 * Given a string s, find the minimum number of cuts required to make all the partitions
 * palindromes.
 * e.g. aab
 * ---> 2 ways to make cuts here
 *       aa | b      ---> total cuts = 1
 *       a | a | b   ---> total cuts = 2
 * answer = 1
 *
 * */
public class MinimumCuts {
    public static void main(String[] args) {
        String s = "abcdcab";
        //bruteForce(s);
        System.out.println(bruteForce(s));
    }

    public static int bruteForce(String s) {
        ArrayList<ArrayList<String>> partitions = new ArrayList<>();
        ArrayList<String> currPartition = new ArrayList<>();
        bruteForce(s, 0,  partitions, currPartition);

        int minCuts = s.length() - 1;
        for (ArrayList<String> al : partitions) {
            System.out.println(al);
            if (allPalindrome(al)) {
                minCuts = Math.min(minCuts, al.size() - 1);
            }
        }
        return minCuts;
    }

    public static boolean allPalindrome(ArrayList<String> al) {
        for (String s : al) {
            if (!isPalindrome(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int i = 0; int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void bruteForce(String s,int startIndex, ArrayList<ArrayList<String>> partitions,
                                  ArrayList<String> currPartition) {

        if (startIndex == s.length()) {
            partitions.add(new ArrayList<>(currPartition));
            return;
        }

        // Try all possible cuts at each position from startIndex to the end of the string
        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {

            String subString = s.substring(startIndex, endIndex);
            currPartition.add(subString);

            // recursively partition the remaining part of the substring
            bruteForce(s, endIndex, partitions, currPartition);

            // backtrack last added substring
            currPartition.remove(currPartition.size() - 1);
        }
    }
}
