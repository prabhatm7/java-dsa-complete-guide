/*
 * Problem: Min-Heap implementation (insert, extractMin, build).
 *
 * Intuition: Array-backed binary heap; sift-up on insert, sift-down on extract.
 * Time: O(log n) per op, O(n) build  Space: O(n)
 */
public class MinHeapImplementation {
    int[] a; int sz = 0;
    public MinHeapImplementation(int cap) { a = new int[cap]; }
    public void insert(int x) {
        a[sz++] = x;
        siftUp(sz - 1);
    }
    public int extractMin() {
        int min = a[0];
        a[0] = a[--sz];
        siftDown(0);
        return min;
    }
    public void build(int[] in) {
        a = in.clone(); sz = in.length;
        for (int i = sz / 2 - 1; i >= 0; i--) siftDown(i);
    }
    private void siftUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (a[p] <= a[i]) break;
            int t = a[p]; a[p] = a[i]; a[i] = t; i = p;
        }
    }
    private void siftDown(int i) {
        while (true) {
            int l = 2*i+1, r = 2*i+2, s = i;
            if (l < sz && a[l] < a[s]) s = l;
            if (r < sz && a[r] < a[s]) s = r;
            if (s == i) break;
            int t = a[s]; a[s] = a[i]; a[i] = t; i = s;
        }
    }
}
