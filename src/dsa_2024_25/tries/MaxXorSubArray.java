package dsa_2024_25.tries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given an array, find the sub-array with max xor.
* A = {2, 1, 3, 5, 4}
* Answer = {3, 5}
*
* */
public class MaxXorSubArray {
    public static void main(String[] args) {
        BitwiseTrie trie = new BitwiseTrie();

        int[] A = {2, 1, 3, 5, 4};

        int[] prefixXor = new int[A.length];
        prefixXor[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ A[i];
        }

        System.out.println(Arrays.toString(prefixXor));

        for (int i : prefixXor) {
            trie.insert(i);
        }
        trie.printAllNumber();

        int[] maxXorPairIndex = trie.getMaxXor(prefixXor);
        System.out.println(Arrays.toString(maxXorPairIndex));
    }
}

class BitwiseTrieNode {
   Map<Integer, BitwiseTrieNode> children;

   BitwiseTrieNode() {
       children = new HashMap<>();
   }
}

class BitwiseTrie {
    BitwiseTrieNode root;
    int MAX_LENGTH = 32;

    public BitwiseTrie() {
        root = new BitwiseTrieNode();
    }

    public void insert(Integer number) {
        BitwiseTrieNode currNode = root;
        for (int i = MAX_LENGTH - 1; i >= 0; i--) {
            int bit = (number >> i) & 1;
            currNode.children.putIfAbsent(bit, new BitwiseTrieNode());
            currNode = currNode.children.get(bit);
        }
    }

    public void printAllNumber() {
        printNumberForNode(root, new StringBuilder());
    }

    private void printNumberForNode(BitwiseTrieNode node, StringBuilder currNumberString) {

       if (node.children.isEmpty()) {
           System.out.println(currNumberString.toString());
           return;
       }

        for (Map.Entry<Integer, BitwiseTrieNode> entry : node.children.entrySet()) {
            currNumberString.append(entry.getKey());
            printNumberForNode(entry.getValue(), currNumberString);
            currNumberString.deleteCharAt(currNumberString.length() - 1);
        }

    }

    public int[] getMaxXor(int[] input) {
        int maxXor = Integer.MIN_VALUE;
        int[] output = new int[2];

        for (int firstIndex = 0; firstIndex < input.length; firstIndex++) {
            int number = input[firstIndex];
            BitwiseTrieNode currNode = root;
            int second = 0;
            for (int i = MAX_LENGTH - 1; i >= 0; i--) {
                int bit = (number >> i) & 1;
                int invertedBit = bit == 1 ? 0 : 1;
                if (currNode.children.containsKey(invertedBit)) {
                    second |= (invertedBit << i);
                    currNode = currNode.children.get(invertedBit);
                } else if (currNode.children.containsKey(bit)) {
                    second |= (bit << i);
                    currNode = currNode.children.get(bit);
                }
            }
            if ((number ^ second) > maxXor) {
                maxXor = number ^ second;
                output[0] = firstIndex;
                int secondIndex = 0;
                for ( ; secondIndex < input.length; secondIndex++) {
                    if (input[secondIndex] == second)
                        break;
                }
                output[1] = secondIndex;
            }
        }
        output[0] = output[0] + 1;
        return output;
    }
}
