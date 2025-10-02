package dsa_2024_25.tries;

public class TrieMain {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("mat");
        trie.insert("dog");
        trie.insert("dope");
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("bat"));
        System.out.println(trie.search("dog"));

        trie.printAllWords();
    }
}
