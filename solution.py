Here is a simple Python console application that implements an autocomplete feature using a prefix search. This application uses a Trie data structure to store words and perform prefix searches.

```python
class Node:
    def __init__(self):
        self.children = {}
        self.end_of_word = False

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word):
        current = self.root
        for letter in word:
            if letter not in current.children:
                current.children[letter] = Node()
            current = current.children[letter]
        current.end_of_word = True

    def search(self, prefix):
        current = self.root
        for letter in prefix:
            if letter not in current.children:
                return []
            current = current.children[letter]
        return self._get_words_from_node(prefix, current)

    def _get_words_from_node(self, prefix, node):
        words = []
        if node.end_of_word:
            words.append(prefix)
        for letter, child_node in node.children.items():
            words.extend(self._get_words_from_node(prefix + letter, child_node))
        return words

def main():
    trie = Trie()
    words = ["dog", "deer", "deal"]
    for word in words:
        trie.insert(word)
    while True:
        prefix = input("Search for: ")
        if prefix == "exit":
            break
        print(trie.search(prefix))

if __name__ == "__main__":
    main()
```

In this application, you can enter a prefix to search for, and it will print out all words in the Trie that start with that prefix. To exit the application, simply type "exit".