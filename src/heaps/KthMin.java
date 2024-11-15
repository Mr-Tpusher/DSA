package heaps;

import java.util.Arrays;

/*
* Given an unsorted array, find kth smallest element.
* Arr = {13, 11, 10, 68, 25}, k = 4
* Answer = 25
*
* */
public class KthMin {
    public static void main(String[] args) {
        int[] Arr = {13, 11, 10, 68, 25};
        int k = 4;
        System.out.println(bruteForce(Arr, k));
    }

    public static int bruteForce(int[] Arr, int k) {
        Arrays.sort(Arr);
        return Arr[k - 1];
    }
}
