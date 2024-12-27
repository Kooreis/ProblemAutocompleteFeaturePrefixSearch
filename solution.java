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
}