/*
 * Problem: LRU Cache — O(1) get and put.
 *
 * Intuition: HashMap of key -> doubly-linked-list node; move to head on access; evict tail when full.
 * Time: O(1)  Space: O(capacity)
 */
import java.util.*;
public class LRUCache {
    class Node { int k, v; Node p, n; Node(int k, int v){this.k=k;this.v=v;} }
    int cap; Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0), tail = new Node(0, 0);
    public LRUCache(int c) { cap = c; head.n = tail; tail.p = head; }
    public int get(int k) {
        if (!map.containsKey(k)) return -1;
        Node n = map.get(k); remove(n); addToFront(n);
        return n.v;
    }
    public void put(int k, int v) {
        if (map.containsKey(k)) { Node n = map.get(k); n.v = v; remove(n); addToFront(n); return; }
        if (map.size() == cap) { Node lru = tail.p; remove(lru); map.remove(lru.k); }
        Node nn = new Node(k, v); addToFront(nn); map.put(k, nn);
    }
    private void remove(Node n) { n.p.n = n.n; n.n.p = n.p; }
    private void addToFront(Node n) { n.n = head.n; n.p = head; head.n.p = n; head.n = n; }
}
