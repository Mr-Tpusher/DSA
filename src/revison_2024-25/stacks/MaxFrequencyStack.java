package stacks;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Implement a stack which supports below operations:
 * 1) push - Push an item x to the stack
 * 2) pop - remove the most recent item with max frequency
 * e.g. 1,1,2,2,3,3,4 -> pop() will return 3.
 * */
public class MaxFrequencyStack {
    Stack<Integer>[] stackArray;
    int maxFreq = 0;
    HashMap<Integer, Integer> frequencies;

    public MaxFrequencyStack(int inputSize) {
        stackArray = new Stack[inputSize + 1];
        for (int i = 0; i < inputSize + 1; i++) {
            stackArray[i] = new Stack<>();
        }
        frequencies = new HashMap<>();
    }

    public void push(int element) {
        int freq = frequencies.getOrDefault(element, 0) + 1;
        frequencies.put(element, freq);
        stackArray[freq].push(element);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        if (maxFreq == 0) {
            throw new RuntimeException("Underflow!");
        }
        int ele = stackArray[maxFreq].pop();
        if (stackArray[maxFreq].isEmpty()) {
            --maxFreq;
        }
        return ele;
    }

    @Override
    public String toString() {
        String str = Arrays.toString(stackArray);
        System.out.println(str);
        return str;
    }
}

class Main {
    public static void main(String[] args) {
        int[] input = {1, 1, 2, 2, 3, 3, 4, 2, 6, 7, 8};
        MaxFrequencyStack stack = new MaxFrequencyStack(input.length);
        for (int i : input) {
            stack.push(i);
        }
        stack.toString();

        int i = input.length;
        while (i >= 0) {
            System.out.println(stack.pop());
            i--;
        }
    }
}

