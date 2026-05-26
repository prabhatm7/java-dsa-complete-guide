/*
 * Problem: Maximum XOR of Two Numbers in array.
 *
 * Intuition: Binary trie of bits (MSB-first); for each x, traverse choosing opposite bit when possible to maximize XOR.
 * Time: O(n*32)  Space: O(n*32)
 */
public class MaximumXOROfTwoNumbers {
    class Node { Node[] ch = new Node[2]; }
    public int findMaximumXOR(int[] a) {
        Node root = new Node();
        for (int x : a) insert(root, x);
        int best = 0;
        for (int x : a) best = Math.max(best, query(root, x));
        return best;
    }
    private void insert(Node r, int x) {
        Node n = r;
        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1;
            if (n.ch[b] == null) n.ch[b] = new Node();
            n = n.ch[b];
        }
    }
    private int query(Node r, int x) {
        Node n = r; int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int b = (x >> i) & 1, want = 1 - b;
            if (n.ch[want] != null) { xor |= (1 << i); n = n.ch[want]; }
            else n = n.ch[b];
        }
        return xor;
    }
}
