/*
 * Problem: Max-Heap implementation.
 *
 * Intuition: Same as min-heap with comparison flipped.
 * Time: O(log n) per op, O(n) build  Space: O(n)
 */
public class MaxHeapImplementation {
    int[] a; int sz = 0;
    public MaxHeapImplementation(int cap) { a = new int[cap]; }
    public void insert(int x) { a[sz++] = x; siftUp(sz - 1); }
    public int extractMax() { int v = a[0]; a[0] = a[--sz]; siftDown(0); return v; }
    private void siftUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (a[p] >= a[i]) break;
            int t = a[p]; a[p] = a[i]; a[i] = t; i = p;
        }
    }
    private void siftDown(int i) {
        while (true) {
            int l = 2*i+1, r = 2*i+2, s = i;
            if (l < sz && a[l] > a[s]) s = l;
            if (r < sz && a[r] > a[s]) s = r;
            if (s == i) break;
            int t = a[s]; a[s] = a[i]; a[i] = t; i = s;
        }
    }
}
