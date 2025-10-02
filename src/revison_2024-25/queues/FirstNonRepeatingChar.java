package queues;

import java.util.*;

/*
 * For each given element find the first non-repeating character in a stream of characters.
 * c   = a,b,a,c,c,b
 * ans = a,a,b,b,b,#
 * */
public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        char[] c = {'a', 'b', 'a', 'c', 'c', 'b'};
        System.out.println(Arrays.toString(getFirstNonRepeatingUsingStacks(c)));
        System.out.println(Arrays.toString(getFirstNonRepeatingUsingQueue(c)));
    }

    public static char[] getFirstNonRepeatingUsingStacks(char[] c) {
        int length = c.length;
        char[] answer = new char[length];
        Stack<Character> nonRepeatingStack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();

        for (int i = 0; i < length; i++) {
            Character currChar = c[i];
            int freq = frequencyMap.getOrDefault(currChar, 0) + 1;
            frequencyMap.put(currChar, freq);

            if (freq == 1) {
                while (!nonRepeatingStack.isEmpty()) {
                    tempStack.push(nonRepeatingStack.pop());
                }
                nonRepeatingStack.push(currChar);
                while (!tempStack.isEmpty()) {
                    nonRepeatingStack.push(tempStack.pop());
                }
            }

            while (!nonRepeatingStack.isEmpty() && frequencyMap.get(nonRepeatingStack.peek()) > 1) {
                nonRepeatingStack.pop();
            }

            if (nonRepeatingStack.isEmpty()) {
                answer[i] = '#';
            } else {
                answer[i] = nonRepeatingStack.peek();
            }
        }
        return answer;
    }

    public static char[] getFirstNonRepeatingUsingQueue(char[] c) {
        int length = c.length;
        char[] answer = new char[length];
        LinkedList<Character> nonRepeatingQueue = new LinkedList<>();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char currChar = c[i];
            int freq = frequencyMap.getOrDefault(currChar, 0) + 1;
            frequencyMap.put(currChar, freq);

            if (freq == 1) {
                nonRepeatingQueue.offer(currChar);
            }

            while (!nonRepeatingQueue.isEmpty() && frequencyMap.get(nonRepeatingQueue.peek()) > 1) {
                nonRepeatingQueue.poll();
            }
            if (nonRepeatingQueue.isEmpty()) {
                answer[i] = '#';
            } else {
                answer[i] = nonRepeatingQueue.peek();
            }
        }
        return answer;
    }
}
