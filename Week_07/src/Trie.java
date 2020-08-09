class Trie {

    private boolean isEnd;
    Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (char w : words) {
            if (node.next[w - 'a'] == null) node.next[w - 'a'] = new Trie();
            node = node.next[w - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = prefixWord(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = prefixWord(prefix);
        return node != null;
    }

    public Trie prefixWord(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (char w : words) {
            if (node.next[w - 'a'] == null) return null;
            node = node.next[w - 'a'];
        }
        return node;
    }
}