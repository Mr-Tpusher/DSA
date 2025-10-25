package revison_oct2025.tries;

import dsa_2024_25.tries.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class ArrayTrie {
    TrieNode root;

    ArrayTrie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        ArrayTrie trie = new ArrayTrie();
        trie.insert("cat");
        trie.insert("cow");
        trie.insert("can");
        trie.insert("camel");
        trie.insert("coward");
        System.out.println(trie.getAllWords());
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("co"));
        System.out.println(trie.isPrefix("co"));
        System.out.println(trie.isPrefix("ab"));
        System.out.println(trie.autoComplete("ca"));
        System.out.println(trie.getAllWords());
        trie.delete("cat");
        System.out.println(trie.getAllWords());
        trie.delete("cow");
        System.out.println(trie.getAllWords());

    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int childIndex = c - 'a';
            TrieNode child = node.children[childIndex];
            if (child == null) {
                child = new TrieNode(c);
                node.children[childIndex] = child;
            } else {
                child.count++;
            }
            node = child;
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int childIndex = c - 'a';
            TrieNode child = node.children[childIndex];
            if (child == null) {
                return false;
            }
            node = child;
        }
        return node.isEndOfWord;
    }

    boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int index) {
        // recursed till the end of the word
        if (index == word.length()) {
            // the word is not found
            if (!node.isEndOfWord)
                return false;

            // if the word is found, mark it's isEndOfWord flag as false
            node.isEndOfWord = false;

            // if the node does not have any children, it can be deleted
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null)
                    return false;
            }
            return true;
        }

        int childIndex = word.charAt(index) - 'a';
        TrieNode nextNode = node.children[word.charAt(index) - 'a'];
        // word not found
        if (nextNode == null)
            return false;


        boolean canCurrBeDeleted = delete(nextNode, word, index + 1);
        // child nodes confirmed deletion of the current node
        if (canCurrBeDeleted) {
            // remove mapping from the parent
            node.children[childIndex] = null;

            boolean doesCurrentHaveChildren = false;
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    doesCurrentHaveChildren = true;
                    break;
                }
            }
            return !doesCurrentHaveChildren && !node.isEndOfWord;
        }

        return false;
    }

    boolean isPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int childIndex = c - 'a';
            TrieNode child = node.children[childIndex];
            if (child == null)
                return false;
            node = child;
        }
        return true;
    }

    ArrayList<String> autoComplete(String prefix) {
        ArrayList<String> candidates = new ArrayList<>();
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int childIndex = c - 'a';
            TrieNode child = node.children[childIndex];
            if (child == null)
                return candidates;
            node = child;
        }

        // dfs-ing to get all the words starting from this prefix
        dfs(node, new StringBuilder(prefix), candidates);
        return candidates;

    }

    ArrayList<String> getAllWords() {
        TrieNode node = root;
        ArrayList<String> allWords = new ArrayList<>();

        dfs(node, new StringBuilder(), allWords);
        return allWords;
    }

    private void dfs(TrieNode node, StringBuilder path, ArrayList<String> candidates) {
        if (node.isEndOfWord) {
            candidates.add(path.toString());
        }

        TrieNode[] children = node.children;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                path.append((char) ('a' + i));
                dfs(children[i], path, candidates);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }



    @Override
    public String toString() {
        return "ArrayTrie{" +
                "root=" + root +
                '}';
    }

    private static class TrieNode {
        TrieNode[] children;
        int count;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
            isEndOfWord = false;
        }

        TrieNode(char data) {
            this();
            this.count = 1;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    ", children=" + Arrays.toString(children) +
                    ", count=" + count +
                    ", isEndOfWord=" + isEndOfWord +
                    '}';
        }
    }
}
