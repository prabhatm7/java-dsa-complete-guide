/*
 * Problem: Implement Trie — insert/search/startsWith.
 *
 * Intuition: 26-children nodes; flag end-of-word.
 * Time: O(L) per op  Space: O(N*L)
 */
public class ImplementTrie {
    class Node { Node[] ch = new Node[26]; boolean end; }
    Node root = new Node();
    public void insert(String w) {
        Node n = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (n.ch[i] == null) n.ch[i] = new Node();
            n = n.ch[i];
        }
        n.end = true;
    }
    public boolean search(String w) { Node n = walk(w); return n != null && n.end; }
    public boolean startsWith(String p) { return walk(p) != null; }
    private Node walk(String s) {
        Node n = root;
        for (char c : s.toCharArray()) { n = n.ch[c - 'a']; if (n == null) return null; }
        return n;
    }
}
