package revison_oct2025.tries;

import dsa_2024_25.maths.MajorityElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a list of N words, find the shortest unique prefix to represent each word in the list.
NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible.
Example Input

Input 1:
 A = ["zebra", "dog", "duck", "dove"]

Output 1:
 ["z", "dog", "du", "dov"]


Input 2:
A = ["apple", "ball", "cat"]

Output 2:
 ["a", "b", "c"]

*

* */
public class ShortestUniquePrefix {
    public static void main(String[] args) {
        Trie trie = new Trie();
        // ArrayList<String> output = trie.shortestCommonPrefix(new ArrayList<>(List.of("zebra", "dog", "dove", "duck")));
        ArrayList<String> output = trie.shortestCommonPrefix(new ArrayList<>(List.of("bearcat", "bert")));
        System.out.println(trie);
        System.out.println(trie.getAllWords());
        System.out.println(output);
    }

    static class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currNode = root;
            for (char c : word.toCharArray()) {
                currNode = currNode.children.computeIfAbsent(c, k -> new TrieNode());
                currNode.count++;
            }
            currNode.isEndOfWord = true;
        }

        public ArrayList<String> getAllWords() {
            ArrayList<String> allWords = new ArrayList<>();
            dfs(root, new StringBuilder(), allWords);
            return allWords;
        }

        public void dfs(TrieNode currNode, StringBuilder path, ArrayList<String> output) {
            if (currNode.isEndOfWord)
                output.add(path.toString());

            for (Map.Entry<Character, TrieNode> entry : currNode.children.entrySet()) {
                path.append(entry.getKey());
                dfs(entry.getValue(), path, output);
                path.deleteCharAt(path.length() - 1);
            }
        }

        ArrayList<String> shortestCommonPrefix(ArrayList<String> words) {
            for (String word : words) {
                insert(word);
            }

            ArrayList<String> output = new ArrayList<>();

            for (String word : words) {
                output.add(getShortestPrefix(word));
            }
            return output;
        }

        // doesn't preserve the insertion order
        private void getAllShortestCommonPrefix(TrieNode currNode, StringBuilder path, ArrayList<String> output) {
            if (currNode.children.size() <= 1) {
                output.add(path.toString());
                return;
            }

            for (Map.Entry<Character, TrieNode> entry : currNode.children.entrySet()) {
                path.append(entry.getKey());
                getAllShortestCommonPrefix(entry.getValue(), path, output);
                path.deleteCharAt(path.length() - 1);
            }

        }

        private String getShortestPrefix(String word) {
            StringBuilder prefix = new StringBuilder();
            TrieNode currNode = root;
            for(char c : word.toCharArray()) {
                prefix.append(c);
                TrieNode child = currNode.children.get(c);
                if (child.count <= 1)
                    return prefix.toString();
                currNode = child;
            }
            if (currNode.isEndOfWord)
                return prefix.toString();
            else
                return null;

        }


        static class TrieNode {
            final Map<Character, TrieNode> children;
            boolean isEndOfWord;
            int count;
            public TrieNode() {
                this.children = new HashMap<>();
                this.isEndOfWord = false;
                count = 0;
            }

            @Override
            public String toString() {
                return "TrieNode{" +
                        "children=" + children +
                        ", isEndOfWord=" + isEndOfWord +
                        ", count=" + count +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Trie{" +
                    "root=" + root +
                    '}';
        }
    }

}
