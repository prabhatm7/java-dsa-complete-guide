/*
 * Problem: Kth Largest Element in array.
 *
 * Intuition: Min-heap of size k; final root is kth largest.
 * Time: O(n log k)  Space: O(k)
 */
import java.util.*;
public class KthLargest {
    public int kthLargest(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : a) { pq.offer(x); if (pq.size() > k) pq.poll(); }
        return pq.peek();
    }
}
