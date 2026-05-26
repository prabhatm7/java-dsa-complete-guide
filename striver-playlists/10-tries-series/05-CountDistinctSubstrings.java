/*
 * Problem: Count Distinct Substrings of a string using Trie.
 *
 * Intuition: Insert every suffix; each new node = a new distinct substring.
 * Time: O(n^2)  Space: O(n^2)
 */
public class CountDistinctSubstrings {
    class Node { Node[] ch = new Node[26]; }
    public int countDistinctSubstrings(String s) {
        Node root = new Node();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            Node n = root;
            for (int j = i; j < s.length(); j++) {
                int k = s.charAt(j) - 'a';
                if (n.ch[k] == null) { n.ch[k] = new Node(); cnt++; }
                n = n.ch[k];
            }
        }
        return cnt;
    }
}
