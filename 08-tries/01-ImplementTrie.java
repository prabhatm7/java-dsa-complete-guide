// LC 208. Implement Trie (Prefix Tree)
// Approach: TrieNode array of 26 children + isEnd flag
// Time: O(m) per operation where m = word length | Space: O(n*m)
class ImplementTrie {
    private ImplementTrie[] children = new ImplementTrie[26];
    private boolean isEnd = false;

    public void insert(String word) {
        ImplementTrie node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new ImplementTrie();
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        ImplementTrie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private ImplementTrie searchPrefix(String word) {
        ImplementTrie node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return null;
            node = node.children[c - 'a'];
        }
        return node;
    }
}
