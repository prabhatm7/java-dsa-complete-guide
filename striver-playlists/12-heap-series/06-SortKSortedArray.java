/*
 * Problem: Sort a Nearly Sorted Array (each element at most k positions from final).
 *
 * Intuition: Min-heap of size k+1.
 * Time: O(n log k)  Space: O(k)
 */
import java.util.*;
public class SortKSortedArray {
    public int[] sortNearly(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = a.length, idx = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            pq.offer(a[i]);
            if (pq.size() > k) res[idx++] = pq.poll();
        }
        while (!pq.isEmpty()) res[idx++] = pq.poll();
        return res;
    }
}
