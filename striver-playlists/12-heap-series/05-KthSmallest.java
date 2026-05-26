/*
 * Problem: Kth Smallest Element in array.
 *
 * Intuition: Max-heap of size k; final root is kth smallest.
 * Time: O(n log k)  Space: O(k)
 */
import java.util.*;
public class KthSmallest {
    public int kthSmallest(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : a) { pq.offer(x); if (pq.size() > k) pq.poll(); }
        return pq.peek();
    }
}
