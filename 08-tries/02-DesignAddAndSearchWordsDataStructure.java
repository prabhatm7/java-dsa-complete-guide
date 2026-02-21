// LC 211. Design Add and Search Words Data Structure
// Approach: Trie with DFS for '.' wildcard - try all 26 children on '.'
// Time: insert O(m), search O(m) or O(26^m) worst case with dots | Space: O(n*m)
class DesignAddAndSearchWordsDataStructure {
    private DesignAddAndSearchWordsDataStructure[] children = new DesignAddAndSearchWordsDataStructure[26];
    private boolean isEnd = false;

    public void addWord(String word) {
        DesignAddAndSearchWordsDataStructure node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new DesignAddAndSearchWordsDataStructure();
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, this);
    }

    private boolean searchHelper(String word, int idx, DesignAddAndSearchWordsDataStructure node) {
        if (idx == word.length()) return node.isEnd;
        char c = word.charAt(idx);
        if (c == '.') {
            for (var child : node.children) {
                if (child != null && searchHelper(word, idx + 1, child)) return true;
            }
            return false;
        } else {
            if (node.children[c - 'a'] == null) return false;
            return searchHelper(word, idx + 1, node.children[c - 'a']);
        }
    }
}
