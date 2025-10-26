package revison_oct2025.tries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given an array, find two elements such that their xor is max
* A = [2, 1, 3, 5, 4]
* ans = [2,5]
*
* */
public class MaxXorPair {

    public static void main(String[] args) {
        BitTrie trie = new BitTrie();
        int[] output = trie.getMaxXor(new int[] {2, 1, 3, 5, 4});
        System.out.println(Arrays.toString(output));
    }



    private static class BitTrie {
        BitTrieNode root;

        BitTrie() {
            this.root = new BitTrieNode();
        }

        void insert(String word) {
            BitTrieNode currNode = root;

            for (char c : word.toCharArray()) {
                currNode = currNode.children.computeIfAbsent(c, k -> new BitTrieNode());
            }
        }

        int[] getMaxXor(int[] A) {

            int[] output = new int[2];

            // put the binary representation of all numbers in the trie.
            for (int i = 0; i < A.length ; i++) {
                int number = A[i];
                StringBuilder binaryOfNumber = new StringBuilder();
                for (int bit = 31; bit >= 0; bit--) {
                    char currentBit = ((number >> bit) & 1) == 0 ? '0' : '1';
                    binaryOfNumber.append(currentBit);
                }
                insert(binaryOfNumber.toString());
            }

            // now check the differing bits in the trie
            // create inverted bits map to simplify querying
            Map<Character, Character> invertedBitMap = new HashMap<>();
            invertedBitMap.put('1', '0');
            invertedBitMap.put('0', '1');
            int maxXor = Integer.MIN_VALUE;

            for (int i = 0; i < A.length; i++) {
                BitTrieNode currNode = root;
                int first = A[i];
                StringBuilder secondBinary = new StringBuilder();
                for (int bit = 31; bit >= 0; bit--) {
                    char currBit = ((first >> bit) & 1) == 1 ? '1' : '0';
                    char invertedBit = invertedBitMap.get(currBit);
                    BitTrieNode child = currNode.children.get(invertedBit);
                    if (child != null) {
                        secondBinary.append(invertedBit);
                    } else {
                        secondBinary.append(currBit);
                        child = currNode.children.get(currBit);
                    }
                    currNode = child;
                }

                int secondInt = Integer.parseInt(secondBinary.toString(), 2);
                int currXor = first ^ secondInt;
                if (currXor > maxXor) {
                    maxXor = currXor;
                    output[0] = first;
                    output[1] = secondInt;
                }

            }

            return output;
        }



        private static class BitTrieNode {
            Map<Character, BitTrieNode> children;
            boolean isEndOfWord;

            BitTrieNode() {
                this.children = new HashMap<>();
                this.isEndOfWord = false;
            }
        }
    }
}
