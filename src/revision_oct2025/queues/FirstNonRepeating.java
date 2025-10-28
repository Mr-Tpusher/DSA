package revision_oct2025.queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
* Find first non-repeating character in a stream of characters
*
* */
public class FirstNonRepeating {
    public static void main(String[] args) {
        char[] stream = {'a', 'b', 'a', 'c', 'c', 'b', 'd', 'e', 'f', 'd', 'e','f', 'a'};
        char[] answer = getFirstNonRepeating(stream);

        System.out.println(answer);

    }

    static char[] getFirstNonRepeating(char[] stream) {

        HashMap<Character, Integer> hm = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        char[] answer = new char[stream.length];

        for (int i = 0; i < stream.length; i++) {
            char element = stream[i];
            int freq = hm.getOrDefault(element, 0);
            freq++;
            hm.put(element, freq);

            if (freq == 1)
                queue.offer(element);

            while (!queue.isEmpty() && hm.get(queue.peek()) > 1)
                queue.poll();

            if (queue.isEmpty())
                answer[i] = '#';
            else
                answer[i] = queue.peek();

        }
        return answer;
    }
}
