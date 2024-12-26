import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;
    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}