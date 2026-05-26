/*
 * Problem: LFU Cache.
 *
 * Intuition: Maps for key->node, freq->doubly-linked-list; track minFreq.
 * Time: O(1) per op  Space: O(cap)
 */
import java.util.*;
public class LFUCache {
    class Node { int k, v, f; Node prev, next; Node(int k, int v){this.k=k; this.v=v; this.f=1;} }
    class DLL { Node head = new Node(0,0), tail = new Node(0,0); int size; DLL(){ head.next = tail; tail.prev = head; }
        void add(Node n) { n.next = head.next; n.prev = head; head.next.prev = n; head.next = n; size++; }
        void rem(Node n) { n.prev.next = n.next; n.next.prev = n.prev; size--; }
        Node removeLast() { Node n = tail.prev; rem(n); return n; }
    }
    int cap, minF = 0;
    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, DLL> fmap = new HashMap<>();
    public LFUCache(int c) { cap = c; }
    public int get(int k) {
        Node n = map.get(k);
        if (n == null) return -1;
        bump(n);
        return n.v;
    }
    public void put(int k, int v) {
        if (cap <= 0) return;
        Node n = map.get(k);
        if (n != null) { n.v = v; bump(n); return; }
        if (map.size() == cap) {
            Node rem = fmap.get(minF).removeLast();
            map.remove(rem.k);
        }
        n = new Node(k, v);
        map.put(k, n);
        fmap.computeIfAbsent(1, x -> new DLL()).add(n);
        minF = 1;
    }
    private void bump(Node n) {
        DLL d = fmap.get(n.f);
        d.rem(n);
        if (d.size == 0 && n.f == minF) minF++;
        n.f++;
        fmap.computeIfAbsent(n.f, x -> new DLL()).add(n);
    }
}
