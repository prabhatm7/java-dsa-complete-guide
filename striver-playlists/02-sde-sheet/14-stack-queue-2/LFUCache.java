/*
 * Problem: LFU Cache — evict least frequently used (LRU among tied).
 *
 * Intuition: Map key->node; map freq->DLL of nodes at that freq; track minFreq.
 * Time: O(1)  Space: O(capacity)
 */
import java.util.*;
public class LFUCache {
    class Node { int k, v, f = 1; Node p, n; Node(int k, int v){this.k=k;this.v=v;} }
    class DLL { Node h = new Node(0,0), t = new Node(0,0); int size = 0; DLL(){h.n=t;t.p=h;}
        void add(Node x) { x.n = h.n; x.p = h; h.n.p = x; h.n = x; size++; }
        void rm(Node x) { x.p.n = x.n; x.n.p = x.p; size--; }
        Node last() { return t.p; } }
    int cap, minF = 0;
    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, DLL> freq = new HashMap<>();
    public LFUCache(int c) { cap = c; }
    public int get(int k) {
        if (!map.containsKey(k)) return -1;
        Node n = map.get(k); bump(n);
        return n.v;
    }
    public void put(int k, int v) {
        if (cap == 0) return;
        if (map.containsKey(k)) { Node n = map.get(k); n.v = v; bump(n); return; }
        if (map.size() == cap) {
            DLL d = freq.get(minF); Node lru = d.last(); d.rm(lru); map.remove(lru.k);
        }
        Node nn = new Node(k, v); map.put(k, nn);
        freq.computeIfAbsent(1, x -> new DLL()).add(nn);
        minF = 1;
    }
    private void bump(Node n) {
        DLL d = freq.get(n.f); d.rm(n);
        if (d.size == 0 && n.f == minF) minF++;
        n.f++;
        freq.computeIfAbsent(n.f, x -> new DLL()).add(n);
    }
}
