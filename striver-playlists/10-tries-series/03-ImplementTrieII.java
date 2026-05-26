/*
 * Problem: Implement Trie II — counts of equal word and prefix; supports erase.
 *
 * Intuition: Each node stores cntEnd and cntPrefix.
 * Time: O(L) per op  Space: O(N*L)
 */
public class ImplementTrieII {
    class Node { Node[] ch = new Node[26]; int end, pre; }
    Node root = new Node();
    public void insert(String w) {
        Node n = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (n.ch[i] == null) n.ch[i] = new Node();
            n = n.ch[i]; n.pre++;
        }
        n.end++;
    }
    public int countWordsEqualTo(String w) {
        Node n = walk(w); return n == null ? 0 : n.end;
    }
    public int countWordsStartingWith(String p) {
        Node n = walk(p); return n == null ? 0 : n.pre;
    }
    public void erase(String w) {
        Node n = root;
        for (char c : w.toCharArray()) { n = n.ch[c - 'a']; n.pre--; }
        n.end--;
    }
    private Node walk(String s) {
        Node n = root;
        for (char c : s.toCharArray()) { n = n.ch[c - 'a']; if (n == null) return null; }
        return n;
    }
}
