/*
 * Problem: LRU Cache.
 *
 * Intuition: HashMap + doubly linked list; head = most recent, tail = LRU; move to head on access.
 * Time: O(1) per op  Space: O(cap)
 */
import java.util.*;
public class LRUCache {
    class Node { int k, v; Node prev, next; Node(int k, int v){this.k=k; this.v=v;} }
    int cap;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0), tail = new Node(0, 0);
    public LRUCache(int c) { cap = c; head.next = tail; tail.prev = head; }
    public int get(int k) {
        Node n = map.get(k);
        if (n == null) return -1;
        remove(n); addFront(n);
        return n.v;
    }
    public void put(int k, int v) {
        Node n = map.get(k);
        if (n != null) { n.v = v; remove(n); addFront(n); return; }
        if (map.size() == cap) { Node lru = tail.prev; remove(lru); map.remove(lru.k); }
        n = new Node(k, v); map.put(k, n); addFront(n);
    }
    private void remove(Node n) { n.prev.next = n.next; n.next.prev = n.prev; }
    private void addFront(Node n) { n.next = head.next; n.prev = head; head.next.prev = n; head.next = n; }
}
