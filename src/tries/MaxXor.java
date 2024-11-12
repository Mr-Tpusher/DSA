package tries;

import java.util.Arrays;
import java.util.HashMap;

/*
* Problem statement:
* Given an array, find two elements such that their xor is maximum.
* A = {2, 1, 3, 5, 4}
* ans = {2, 5}
*
* Solution:
* Insert binary representation of numbers in a Trie.
* Then iterate over every input number, bit by bit, and check in the trie for a number
* with a differing bit value.
* Because we'll get max XOR when the bits of two numbers are differing.
* */
public class MaxXor {
    public static void main(String[] args) {
        int[] input = {2, 1, 3, 5, 4};
        int[] output = getMaxXor(input);
        System.out.println(Arrays.toString(output));

    }

    private static int[] getMaxXor(int[] input) {
        Trie trie = new Trie();
        int[] output = new int[2];
        int maxXor = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            StringBuilder bitString = new StringBuilder();
            for (int bit = 31; bit >= 0; bit--) {
                char currBit = ((input[i] >> bit) & 1) == 1 ? '1' : '0';
                bitString.append(currBit);
            }
            trie.insert(bitString.toString());
        }

        HashMap<Character, Character> invertedBitMap = new HashMap<>();
        invertedBitMap.put('0', '1');
        invertedBitMap.put('1', '0');

        for (int i = 0; i < input.length; i++) {
            TrieNode currNode = trie.getRoot();
            int first = input[i];
            StringBuilder second = new StringBuilder();

            for (int bit = 31; bit >= 0; bit--) {
                char currBit = ((first >> bit) & 1) == 1 ? '1' : '0';
                    char invertedBit = invertedBitMap.get(currBit);

                    if (currNode.getChildren().containsKey(invertedBit)) {
                        second.append(invertedBit);
                        currNode = currNode.getChildren().get(invertedBit);
                    } else if (currNode.getChildren().containsKey(currBit)) {
                        second.append(currBit);
                        currNode = currNode.getChildren().get(currBit);
                    }
                }

            int secondInt = Integer.parseInt(second.toString(), 2);
            if ((first ^ secondInt) > maxXor) {
                maxXor = first ^ secondInt;
                output[0] = first;
                output[1] = secondInt;
            }
        }
        return output;
    }
}
