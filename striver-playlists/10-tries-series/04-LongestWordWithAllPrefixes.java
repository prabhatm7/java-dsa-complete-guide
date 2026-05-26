/*
 * Problem: Longest word such that every prefix exists in the dictionary.
 *
 * Intuition: Insert all into Trie; DFS only descending through end-flagged nodes; track lex-smallest longest.
 * Time: O(N*L)  Space: O(N*L)
 */
public class LongestWordWithAllPrefixes {
    class Node { Node[] ch = new Node[26]; boolean end; String word; }
    Node root = new Node();
    public String completeString(String[] words) {
        for (String w : words) insert(w);
        return dfs(root);
    }
    private void insert(String w) {
        Node n = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (n.ch[i] == null) n.ch[i] = new Node();
            n = n.ch[i];
        }
        n.end = true; n.word = w;
    }
    private String dfs(Node n) {
        String best = n.word == null ? "" : n.word;
        for (int i = 0; i < 26; i++)
            if (n.ch[i] != null && n.ch[i].end) {
                String c = dfs(n.ch[i]);
                if (c.length() > best.length() || (c.length() == best.length() && c.compareTo(best) < 0)) best = c;
            }
        return best;
    }
}
