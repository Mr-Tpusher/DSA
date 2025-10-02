package tries;

public class ArrayTrieNode {
    char data;
    ArrayTrieNode[] children;
    boolean isEnd;

    public ArrayTrieNode() {
        children = new ArrayTrieNode[26];
        isEnd = false;
    }

    public ArrayTrieNode(char data) {
        this.data = data;
        children = new ArrayTrieNode[26];
        isEnd = false;
    }
}
