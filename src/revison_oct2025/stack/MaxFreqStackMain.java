package revison_oct2025.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaxFreqStackMain {
    public static void main(String[] args) {
        int[][] A = {{1, 5}, {1, 7}, {1, 5}, {1, 7}, {1, 4}, {1, 5}, {2, 0}, {2, 0}, {2, 0}, {2, 0}};

        MaxFreqStack mfStack = new MaxFreqStack(A.length);

        int[] output = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                mfStack.push(A[i][1]);
                output[i] = -1;
            } else {
                int x = mfStack.pop();
                output[i] = x;
            }
        }
        System.out.println(Arrays.toString(output));
    }
}

    class MaxFreqStack {
        private Stack<Integer>[] freqStacks;
        private HashMap<Integer, Integer> hm = new HashMap<>();
        private int maxFreq = 0;

        MaxFreqStack(int size) {
            freqStacks = new Stack[size + 1];
        }

        int push(int x) {
            // increase the frequency in the map
            int freq = hm.getOrDefault(x, 0);
            hm.put(x, ++freq);

            // if freq is greater than the max freq, we need to create the stack in the array
            if (freq > maxFreq) {
                maxFreq = freq;
                freqStacks[maxFreq] = new Stack<Integer>();
            }

            // put x in the freq Stack
            freqStacks[freq].push(x);

            // update the max frequency
            // maxFreq = Math.max(maxFreq, freq);

            return -1;
        }

        int pop() {
            if (maxFreq == 0)
                throw new RuntimeException("Underflow");

            // pop the element of the max frequency stack
            int x = freqStacks[maxFreq].pop();

            // update the frequency in the map
            hm.put(x, (hm.get(x) - 1));

            if (freqStacks[maxFreq].isEmpty())
                --maxFreq;

            return x;

        }
    }

