package hashing.strings;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string, return first non-repeating character.
* */
public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String s = "abcdabcee";
        System.out.println(firstNonRepeating(s));
        System.out.println(firstNonRepeatingOfStream(s));
    }

    public static Character firstNonRepeating(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int freq = hm.getOrDefault(c, 0);
            hm.put(c, ++freq);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    // You are not allowed to iterate the array again
    public static Character firstNonRepeatingOfStream(String s) {
        HashMap<Character, CountAndLastIndex> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
                CountAndLastIndex element = hm.get(c);
                int count = element.getCount();
                element.setCount(++count);
                element.setLastIndex(i);
            } else {
                CountAndLastIndex element = new CountAndLastIndex(1, i);
                hm.put(c, element);
            }
        }

        int smallestIndex = Integer.MAX_VALUE;
        Character ans = null;
        for (Map.Entry<Character, CountAndLastIndex> e : hm.entrySet()) {
            if (e.getValue().getCount() == 1 && e.getValue().getLastIndex() < smallestIndex) {
                smallestIndex = e.getValue().getLastIndex();
                ans = e.getKey();
            }
        }
        return ans;
    }


}

class CountAndLastIndex {
    int count;
    int lastIndex;

    public CountAndLastIndex(int count, int lastIndex) {
        this.count = count;
        this.lastIndex = lastIndex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    @Override
    public String toString() {
        return "CountAndLastIndex{" +
                "count=" + count +
                ", lastIndex=" + lastIndex +
                '}';
    }
}
