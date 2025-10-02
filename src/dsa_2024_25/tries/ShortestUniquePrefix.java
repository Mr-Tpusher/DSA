package dsa_2024_25.tries;
/*
* Given a list of N words, find the shortest unique prefix, to represent each word in the list.
* Input = { "zebra", "dog", "duck", "dove"}
* output = { "z", "dog", "du", "dov"}
* */

import java.util.Arrays;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        String[] input = { "zebra", "dog", "duck", "dove"};

        String[] output = bruteForce(input);
        for (String s : output) {
            System.out.println(s);
        }


        String[] output2 = shortestUniquePrefixUsingTrie(input);
        for (String s : output2) {
            System.out.println(s);
        }
    }

    public static String[] shortestUniquePrefixUsingTrie(String[] input) {
        Trie trie = new Trie();

        for (String s : input) {
            trie.insert(s);
        }

        String[] output = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = trie.getShortestPrefix(input[i]);
        }
        return output;
    }




    public static String[] bruteForce(String[] input) {
        int length = input.length;
        String[] output = new String[length];

        // iterate through each word
        for (int i = 0; i < length; i++) {
            String word = input[i];

            for (int j = 1; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                boolean isUnique = true;

                // compare the prefix
                for (String s : input) {
                    if (word.equals(s)) continue;

                   if (s.length() > i && prefix.equals(s.substring(0,j))) {
                       isUnique = false;
                       break;
                   }
                }
                if (isUnique) {
                    output[i] = prefix;
                    break;
                }
            }
        }
        return output;
    }
}
