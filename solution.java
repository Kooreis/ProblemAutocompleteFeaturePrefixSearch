Here is a simple implementation of an autocomplete feature using a Trie data structure in Java:

```java
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;
    public TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}

class AutocompleteSystem {
    private TrieNode root;
    private String prefix;

    public AutocompleteSystem(String[] sentences) {
        root = new TrieNode();
        prefix = "";
        for (String s : sentences) {
            insert(s);
        }
    }

    private void insert(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(prefix);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        TrieNode curr = root;
        for (char cc : prefix.toCharArray()) {
            if (!curr.children.containsKey(cc)) {
                return new ArrayList<>();
            }
            curr = curr.children.get(cc);
        }
        List<String> result = new ArrayList<>();
        findAllWords(curr, new StringBuilder(prefix), result);
        return result;
    }

    private void findAllWords(TrieNode node, StringBuilder sb, List<String> result) {
        if (node.endOfWord) {
            result.add(sb.toString());
        }
        for (char c : node.children.keySet()) {
            findAllWords(node.children.get(c), sb.append(c), result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] sentences = {"dog", "deer", "deal"};
        AutocompleteSystem system = new AutocompleteSystem(sentences);
        System.out.println(system.input('d'));
        System.out.println(system.input('e'));
        System.out.println(system.input('a'));
        System.out.println(system.input('#'));
    }
}
```

This program creates a Trie data structure from the given sentences. When a character is input, it appends it to the current prefix and searches the Trie for all words that start with the current prefix. If the input character is '#', it inserts the current prefix into the Trie and resets the prefix.