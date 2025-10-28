package revision_oct2025.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapTrie {
    TrieNode root;

    static class TrieNode {

        private final Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + children +
                    ", isEndOfWord=" + isEndOfWord +
                    '}';
        }
    }

    public MapTrie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        MapTrie trie = new MapTrie();
        trie.insert("cat");
        trie.insert("bat");
        trie.insert("camel");
        trie.insert("camera");
        trie.insert("dot");
        trie.insert("cattle");
        //System.out.println(trie);
        System.out.println(trie.getAllWords());

        String word = "cat";
        System.out.println("does the word " + word + " exist : " + trie.search(word));

        System.out.println("deleting cat : " + trie.delete("cat"));
        //System.out.println(trie);
        System.out.println(trie.getAllWords());

        System.out.println("does the word " + word + " exist : " + trie.search(word));
    }

    public void insert(String word) {
        TrieNode currNode = root;
        for (char c : word.toCharArray()) {
/*          TrieNode child = currNode.children.getOrDefault(c, new TrieNode());
            currNode.children.put(c, child);
            currNode = child;*/
            currNode = currNode.children.computeIfAbsent(c, k -> new TrieNode());
        }
        currNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currNode = root;
        for (char c : word.toCharArray()) {
            if (!currNode.children.containsKey(c))
                return false;
            currNode = currNode.children.get(c);
        }
        return currNode.isEndOfWord;
    }

    public boolean delete(String word) {
        // if the word does not exist
        if (!search(word))
            return false;

        delete(root, word, 0);
        return true;
    }

    // we are recursing till the end, and at any checking if
    // 1) child can be deleted and deleting it
    // 2) returning to the caller(previous node) if current can be deleted

    private boolean delete(TrieNode currNode, String word, int index) {
        // we have reached last character of the word, here index will ahead than the last character, base condition.
        // at this point we are basically checking and returning if parent of last character can delete this char.
        if (index == word.length()) {
            if (!currNode.isEndOfWord) {
                System.out.println("the word does not exist.");
                return false;
            }
            currNode.isEndOfWord = false;
            return currNode.children.isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode child = currNode.children.get(ch);

        // if the node for current char doesn't exist, then return false, there's no word to be deleted
        if (child == null)
            return false; // word not found


        // if the node exists, simply ask the child node if it(child) can be deleted
        boolean canChildBeDeleted = delete(child, word, index + 1);
        if (canChildBeDeleted) {
            currNode.children.remove(word.charAt(index));
            // now return to the parent of current node whether this current node can be deleted.
            return !currNode.isEndOfWord && currNode.children.isEmpty();
        }
        return false;

    }

    // we need to do dfs to get all the words
    public ArrayList<String> getAllWords() {
        ArrayList<String> allWords = new ArrayList<>();
        dfs(root, new StringBuilder(), allWords);
        return allWords;
    }

    private void dfs(TrieNode currNode, StringBuilder path, ArrayList<String> result) {
        if (currNode.isEndOfWord)
            result.add(path.toString());

        for (Map.Entry<Character, TrieNode> entry : currNode.children.entrySet()) {
            path.append(entry.getKey());
            dfs(entry.getValue(), path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (char c : prefix.toCharArray()) {
            if (!currNode.children.containsKey(c))
                return false;
            currNode = currNode.children.get(c);
        }
        return true;
    }

    @Override
    public String toString() {
        return "MapTrie{" +
                "root=" + root +
                '}';
    }
}
