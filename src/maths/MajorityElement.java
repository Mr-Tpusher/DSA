package maths;
/*
 * Given an array, Find the element which occurs
 * (N/2) + 1  times.
 */


import java.util.*;
public class MajorityElement {
    public static void main(String[] args) {

        int[] A = {3, 1, 3, 3, 3, 2};

        System.out.println("majority1(A):" + majority1(A));
        System.out.println("majority2(A):" + majority2(A));
        System.out.println("majority3(A):" + majority3(A));
        
    }

    public static int majority1(int[] A) {
        int length = A.length;
        int majorityFreq = (length / 2) + 1;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int freq = hm.getOrDefault(A[i], 0);
            hm.put(A[i], ++freq);
        }

        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() == majorityFreq) {
                return e.getKey();
            }
        }
        return -1;
    }

    public static int majority2(int[] A) {
        int length = A.length;
        int majorityFreq = (length / 2) + 1;

        Arrays.sort(A);

        int count = 1;
        for (int i = 1; i < length; i++) {
            if (A[i] == A[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count == majorityFreq) {
                return A[i];
            }
        }
        return -1;
    }

    public static int majority3(int[] A) {
        int length = A.length;
        int majorityFreq = (length / 2) + 1;

        int count = 1;
        int majorityElement = A[0];
        for (int i = 1; i < length; i++) {
            if (A[i] == majorityElement) {
                count++;
            } else {
                count --;
                majorityElement = A[i + 1];
            }
        }

        if (count == 0) {
            return -1;
        }

        int freq = 0;
        for (int i = 0; i < length; i++) {
            if (A[i] == majorityElement) {
                freq++;
            }
        }

        if (freq >= majorityFreq) {
            return majorityElement;
        }
        else {
            return -1;
        }
    }
}
