package dsa_2024_25.tries;

public class ArrayTrie {
    private ArrayTrieNode root;

    public ArrayTrie() {
        root = new ArrayTrieNode();
    }

    public void insert(String word) {
        ArrayTrieNode currentNode = root;
        char[] charArray = word.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int nodeIndex = c - 97;
            if (currentNode.children[nodeIndex] == null) {
                currentNode.children[nodeIndex] = new ArrayTrieNode(c);
            }
            currentNode = currentNode.children[nodeIndex];
            if (i == charArray.length - 1) {
                currentNode.isEnd = true;
            }
        }
    }
}
