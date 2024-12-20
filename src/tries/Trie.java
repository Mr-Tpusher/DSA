package tries;

import java.util.Map;
import java.util.NoSuchElementException;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    public void insert(String word) {
        TrieNode currNode = root;

        for (char c : word.toCharArray()) {
            currNode.getChildren().putIfAbsent(c, new TrieNode());
            currNode.setCount(currNode.getCount() + 1);
            currNode = currNode.getChildren().get(c);
        }
        currNode.setEnd(true);
    }

    public boolean search(String word) {
        TrieNode currNode = root;

        for (char c : word.toCharArray()) {
            if (!currNode.getChildren().containsKey(c)) {
                return false;
            }
                currNode = currNode.getChildren().get(c);
        }
        return currNode.isEnd();
    }

    public void printAllWords() {
        TrieNode curr = root;
        StringBuilder currWord = new StringBuilder();
        printAllWordsFromNode(curr, currWord);
    }

    private void printAllWordsFromNode(TrieNode curr, StringBuilder currWord) {
        if (curr.isEnd()) {
            System.out.println(currWord);
        }

        // Print all words using recursion and backtracking
        for (Map.Entry<Character, TrieNode> entry : curr.getChildren().entrySet()) {
            currWord.append(entry.getKey());
            printAllWordsFromNode(entry.getValue(), currWord); // Recurse
            currWord.deleteCharAt(currWord.length() - 1); // Backtrack
        }
    }

    public String getShortestPrefix(String s) {
      TrieNode currNode = root;
      StringBuilder sb = new StringBuilder();

      for (char c : s.toCharArray()) {
          if (currNode.getChildren().containsKey(c)) {
              currNode = currNode.getChildren().get(c);
              sb.append(c);
              if (currNode.getCount() == 1)
                  break;
          } else {
              throw new NoSuchElementException();
          }
      }
      return sb.toString();
    }
}
